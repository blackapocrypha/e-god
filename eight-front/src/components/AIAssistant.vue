<script setup lang="ts">
import { ref, computed, watch, onBeforeUnmount, nextTick } from 'vue'
import { useInfoStore } from '@/stores/info'
import { createChatStream } from '@/api/eight/index'
import type { userInfo } from '@/api/eight/type'
import { marked } from 'marked'

const info = useInfoStore()
const visible = ref(false)
const loading = ref(false)
const chatContent = ref('')
const errorText = ref('')
let eventSource: EventSource | null = null

// 渲染后的 markdown HTML
const renderedContent = computed(() => {
  if (!chatContent.value) return ''
  return marked.parse(chatContent.value, { breaks: true, gfm: true })
})

// 自动滚动到底部
const chatBodyRef = ref<HTMLElement | null>(null)
const scrollToBottom = async () => {
  await nextTick()
  if (chatBodyRef.value) {
    chatBodyRef.value.scrollTop = chatBodyRef.value.scrollHeight
  }
}

const formartDate = (date: any) => {
  const year = date.getFullYear()
  const month = (date.getMonth() + 1).toString().padStart(2, '0')
  const day = date.getDate().toString().padStart(2, '0')
  const hours = date.getHours().toString().padStart(2, '0')
  const minutes = date.getMinutes().toString().padStart(2, '0')
  const seconds = date.getSeconds().toString().padStart(2, '0')
  return `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`
}

// 缓存 key：gender + 日期（yyyy-MM-dd），日期变化时清空内容
const currentCacheKey = computed(() => {
  const dateStr = formartDate(info.birth)
  const dayKey = dateStr.split(' ')[0]
  return `${info.gender}-${dayKey}`
})

let cachedKey = ''

const openPanel = () => {
  visible.value = true
  // 日期/性别变了才清空
  if (cachedKey !== currentCacheKey.value) {
    chatContent.value = ''
    cachedKey = currentCacheKey.value
  }
  if (!chatContent.value) {
    startStream()
  }
}

const closePanel = () => {
  visible.value = false
}

const startStream = () => {
  if (eventSource) {
    eventSource.close()
    eventSource = null
  }
  loading.value = true
  errorText.value = ''
  chatContent.value = ''

  const params: userInfo = {
    birth: formartDate(info.birth),
    gender: info.gender
  }

  eventSource = createChatStream(params)

  eventSource.onmessage = (event) => {
    if (event.data === '[DONE]') {
      closeStream()
      return
    }
    chatContent.value += event.data
    scrollToBottom()
  }

  eventSource.onerror = () => {
    // 关键修复：区分"正常结束"和"真正错误"
    // 如果已经收到内容，说明流正常结束（后端 Flux 完成后关闭连接），不报错
    if (chatContent.value) {
      // 流正常结束，只是服务器关闭了 SSE 连接
      closeStream()
    } else {
      // 没收到任何内容 → 真正的连接错误
      errorText.value = 'AI 助手连接异常，请稍后重试。'
      closeStream()
    }
  }

  eventSource.onopen = () => {
    loading.value = false
  }
}

const closeStream = () => {
  loading.value = false
  if (eventSource) {
    eventSource.close()
    eventSource = null
  }
}

// 监听 store 变化：若面板打开时生日/性别变化，则立即清空并重新请求
watch(currentCacheKey, () => {
  if (visible.value) {
    chatContent.value = ''
    cachedKey = currentCacheKey.value
    startStream()
  }
})

onBeforeUnmount(() => {
  closeStream()
})

const onClickOutside = () => {
  closePanel()
}
</script>

<template>
  <div class="ai-assistant">
    <!-- 浮动入口按钮 -->
    <button
      class="ai-float-btn"
      aria-label="AI 八字助手"
      @click="openPanel"
      :class="{ active: visible }"
    >
      <img src="@/assets/AI.png" alt="AI" class="ai-avatar" />
    </button>

    <!-- 对话窗口 -->
    <transition name="ai-fade">
      <div v-if="visible" class="ai-overlay" @click="onClickOutside">
        <div class="ai-chat-window" @click.stop>
          <div class="ai-chat-header">
            <div class="ai-header-left">
              <img src="@/assets/AI.png" alt="AI" class="ai-header-avatar" />
              <div class="ai-header-info">
                <span class="ai-header-title">AI 八字助手</span>
                <span class="ai-header-status">
                  <span class="ai-status-dot" :class="{ loading: loading }"></span>
                  {{ loading ? '正在批八字…' : (chatContent ? '已完成' : '在线') }}
                </span>
              </div>
            </div>
            <button class="ai-close-btn" aria-label="关闭" @click="closePanel">×</button>
          </div>

          <div ref="chatBodyRef" class="ai-chat-body">
            <div v-if="loading && !chatContent" class="ai-loading-bubble">
              <div class="ai-thinking">
                <span></span><span></span><span></span>
              </div>
              <p class="ai-loading-text">AI 正在根据您的八字信息分析性格、婚姻、财富、健康…</p>
            </div>

            <div v-else-if="errorText" class="ai-error-bubble">
              <p>{{ errorText }}</p>
              <button class="ai-retry-btn" @click="startStream">重新获取</button>
            </div>

            <div v-else class="ai-message ai-message-ai">
              <div class="ai-message-content markdown-body" v-html="renderedContent"></div>
            </div>
          </div>

          <div class="ai-chat-footer">
            <span class="ai-footer-tip">此内容由 AI 生成，仅供参考</span>
          </div>
        </div>
      </div>
    </transition>
  </div>
</template>

<style scoped>
.ai-assistant {
  position: fixed;
  right: 24px;
  bottom: 24px;
  z-index: 1000;
}

.ai-float-btn {
  width: 64px;
  height: 64px;
  border: none;
  border-radius: 50%;
  background: #fff;
  padding: 0;
  cursor: pointer;
  box-shadow: 0 6px 20px oklch(60% 0.12 250 / 0.25), 0 2px 6px oklch(60% 0.08 250 / 0.15);
  transition: all 0.3s var(--ease-out-quart);
  display: flex;
  align-items: center;
  justify-content: center;
  overflow: hidden;
}

.ai-float-btn:hover {
  transform: translateY(-4px) scale(1.08);
  box-shadow: 0 10px 28px oklch(60% 0.14 250 / 0.3), 0 4px 10px oklch(60% 0.1 250 / 0.2);
}

.ai-float-btn.active {
  transform: scale(0.95);
  box-shadow: 0 4px 14px oklch(60% 0.1 250 / 0.2);
}

.ai-avatar {
  width: 100%;
  height: 100%;
  object-fit: cover;
  display: block;
}

/* 遮罩层 */
.ai-overlay {
  position: fixed;
  inset: 0;
  z-index: 1001;
  background: oklch(20% 0.02 80 / 0.2);
  backdrop-filter: blur(4px);
  display: flex;
  align-items: flex-end;
  justify-content: flex-end;
  padding: 24px;
  pointer-events: auto;
}

.ai-chat-window {
  width: 420px;
  max-width: calc(100vw - 48px);
  max-height: calc(100vh - 120px);
  background: var(--color-bg-elevated);
  border: 1px solid var(--color-border-light);
  border-radius: var(--radius-xl);
  box-shadow: 0 20px 60px oklch(30% 0.05 80 / 0.25);
  display: flex;
  flex-direction: column;
  overflow: hidden;
  pointer-events: auto;
}

.ai-chat-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: var(--space-md) var(--space-lg);
  background: linear-gradient(135deg, var(--color-bg-soft), var(--color-bg-mute));
  border-bottom: 1px solid var(--color-border-light);
}

.ai-header-left {
  display: flex;
  align-items: center;
  gap: var(--space-sm);
}

.ai-header-avatar {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  object-fit: cover;
  box-shadow: var(--shadow-sm);
}

.ai-header-info {
  display: flex;
  flex-direction: column;
  gap: 2px;
}

.ai-header-title {
  font-family: var(--font-serif);
  font-size: var(--text-base);
  font-weight: var(--weight-bold);
  color: var(--color-text);
  letter-spacing: 0.04em;
}

.ai-header-status {
  display: flex;
  align-items: center;
  gap: 4px;
  font-size: var(--text-xs);
  color: var(--color-text-mute);
}

.ai-status-dot {
  width: 6px;
  height: 6px;
  border-radius: 50%;
  background: var(--color-success);
}

.ai-status-dot.loading {
  background: var(--color-primary);
  animation: ai-pulse 1.2s infinite;
}

@keyframes ai-pulse {
  0%, 100% { opacity: 1; transform: scale(1); }
  50% { opacity: 0.4; transform: scale(1.3); }
}

.ai-close-btn {
  width: 32px;
  height: 32px;
  border: none;
  border-radius: 50%;
  background: transparent;
  color: var(--color-text-soft);
  font-size: 22px;
  line-height: 1;
  cursor: pointer;
  transition: all 0.2s var(--ease-out-quart);
  display: flex;
  align-items: center;
  justify-content: center;
}

.ai-close-btn:hover {
  background: var(--color-bg-soft);
  color: var(--color-text);
}

.ai-chat-body {
  flex: 1;
  overflow-y: auto;
  padding: var(--space-lg);
  background: var(--color-bg);
  min-height: 320px;
}

.ai-message {
  display: flex;
  align-items: flex-start;
  gap: var(--space-sm);
}

.ai-message-ai {
  justify-content: flex-start;
}

.ai-message-content {
  max-width: 100%;
  padding: var(--space-md);
  background: var(--color-bg-elevated);
  border: 1px solid var(--color-border-light);
  border-radius: var(--radius-lg) var(--radius-lg) var(--radius-lg) 4px;
  box-shadow: var(--shadow-sm);
  color: var(--color-text);
  font-size: var(--text-sm);
  line-height: var(--leading-relaxed);
  word-break: break-word;
}

.ai-loading-bubble {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  gap: var(--space-md);
  padding: var(--space-xl) var(--space-lg);
  text-align: center;
}

.ai-thinking {
  display: flex;
  gap: 6px;
}

.ai-thinking span {
  width: 8px;
  height: 8px;
  border-radius: 50%;
  background: var(--color-primary);
  animation: ai-bounce 1.4s infinite ease-in-out both;
}

.ai-thinking span:nth-child(1) { animation-delay: -0.32s; }
.ai-thinking span:nth-child(2) { animation-delay: -0.16s; }
.ai-thinking span:nth-child(3) { animation-delay: 0s; }

@keyframes ai-bounce {
  0%, 80%, 100% { transform: scale(0); }
  40% { transform: scale(1); }
}

.ai-loading-text {
  color: var(--color-text-soft);
  font-size: var(--text-sm);
  line-height: var(--leading-relaxed);
}

.ai-error-bubble {
  padding: var(--space-md);
  background: oklch(95% 0.03 25);
  border: 1px solid oklch(85% 0.08 25);
  border-radius: var(--radius-lg);
  color: var(--color-primary);
  font-size: var(--text-sm);
  text-align: center;
}

.ai-retry-btn {
  margin-top: var(--space-sm);
  padding: 6px 16px;
  border: none;
  border-radius: var(--radius-md);
  background: var(--color-primary);
  color: #fff;
  font-size: var(--text-sm);
  cursor: pointer;
  transition: background 0.2s var(--ease-out-quart);
}

.ai-retry-btn:hover {
  background: var(--color-primary-dark);
}

.ai-chat-footer {
  padding: var(--space-sm) var(--space-lg);
  background: var(--color-bg-soft);
  border-top: 1px solid var(--color-border-light);
  text-align: center;
}

.ai-footer-tip {
  font-size: var(--text-xs);
  color: var(--color-text-mute);
}

/* 过渡动画 */
.ai-fade-enter-active,
.ai-fade-leave-active {
  transition: opacity 0.25s var(--ease-out-quart), transform 0.25s var(--ease-out-quart);
}

.ai-fade-enter-from,
.ai-fade-leave-to {
  opacity: 0;
  transform: translateY(12px) scale(0.96);
}

/* 移动端适配 */
@media (max-width: 768px) {
  .ai-assistant {
    right: 16px;
    bottom: 16px;
  }

  .ai-float-btn {
    width: 52px;
    height: 52px;
  }

  .ai-overlay {
    padding: 16px;
    align-items: flex-end;
  }

  .ai-chat-window {
    width: 100%;
    max-width: calc(100vw - 32px);
    max-height: calc(100vh - 100px);
  }

  .ai-chat-body {
    min-height: 260px;
  }
}
</style>

<!-- Markdown 渲染样式（非 scoped，v-html 内容不受 scoped 限制） -->
<style>
.markdown-body {
  font-size: var(--text-sm);
  line-height: 1.8;
  color: var(--color-text);
}

.markdown-body h1,
.markdown-body h2,
.markdown-body h3,
.markdown-body h4 {
  font-family: var(--font-serif);
  color: var(--color-text);
  letter-spacing: 0.04em;
  margin-top: var(--space-md);
  margin-bottom: var(--space-sm);
}

.markdown-body h2 {
  font-size: var(--text-lg);
  font-weight: var(--weight-bold);
  border-bottom: 1px solid var(--color-border-light);
  padding-bottom: var(--space-xs);
}

.markdown-body h3 {
  font-size: var(--text-base);
  font-weight: var(--weight-semibold);
}

.markdown-body h4 {
  font-size: var(--text-sm);
  font-weight: var(--weight-semibold);
}

.markdown-body p {
  margin: var(--space-sm) 0;
}

.markdown-body ul,
.markdown-body ol {
  margin: var(--space-sm) 0;
  padding-left: var(--space-lg);
}

.markdown-body li {
  margin: var(--space-xs) 0;
  line-height: 1.7;
}

.markdown-body strong {
  font-weight: var(--weight-bold);
  color: var(--color-text);
}

.markdown-body em {
  color: var(--color-text-soft);
}

.markdown-body blockquote {
  margin: var(--space-sm) 0;
  padding: var(--space-sm) var(--space-md);
  border-left: 3px solid var(--color-primary);
  background: var(--color-primary-light);
  color: var(--color-text-soft);
  border-radius: 0 var(--radius-sm) var(--radius-sm) 0;
}

.markdown-body code {
  font-size: 0.85em;
  background: var(--color-bg-soft);
  padding: 2px 6px;
  border-radius: var(--radius-sm);
  color: var(--color-primary);
}

.markdown-body pre {
  margin: var(--space-sm) 0;
  padding: var(--space-md);
  background: var(--color-bg-soft);
  border-radius: var(--radius-md);
  overflow-x: auto;
}

.markdown-body pre code {
  background: transparent;
  padding: 0;
  color: var(--color-text);
}

.markdown-body hr {
  border: none;
  border-top: 1px solid var(--color-border-light);
  margin: var(--space-md) 0;
}

.markdown-body table {
  width: 100%;
  border-collapse: collapse;
  margin: var(--space-sm) 0;
}

.markdown-body th,
.markdown-body td {
  padding: var(--space-sm);
  border: 1px solid var(--color-border-light);
  text-align: left;
}

.markdown-body th {
  background: var(--color-bg-soft);
  font-weight: var(--weight-semibold);
}
</style>
