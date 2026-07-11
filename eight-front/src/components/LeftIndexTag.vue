<template>
  <div class="greetings">
    <h1 class="title">{{ msg }}</h1>
    <p class="subtitle">知天命，顺四时，晓阴阳之理</p>

    <el-form :model="form" label-width="auto" class="ba-form">
      <el-form-item label="出生日期">
        <el-date-picker
          v-model="form.birth"
          type="datetime"
          placeholder="请选择出生日期"
          format="YYYY-MM-DD HH:mm"
          class="full-width"
        />
      </el-form-item>

      <el-form-item label="性别">
        <el-radio-group v-model="form.gender" class="gender-group">
          <el-radio value="1" class="gender-radio">
            <span class="gender-label">乾造</span>
            <span class="gender-sub">男</span>
          </el-radio>
          <el-radio value="0" class="gender-radio">
            <span class="gender-label">坤造</span>
            <span class="gender-sub">女</span>
          </el-radio>
        </el-radio-group>
      </el-form-item>

      <el-form-item>
        <el-button size="large" type="primary" class="submit-btn" @click="subForm">
          开始排盘
        </el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script setup lang="ts">
import { reactive } from 'vue'
import { useInfoStore } from '@/stores/info'
import type { userInfo } from '@/api/eight/type'
import { useRouter } from 'vue-router'

const info = useInfoStore()
const route = useRouter()

let form = reactive<userInfo>({
  birth: new Date('2000-01-01 00:00:00'),
  gender: '1'
})

const subForm = () => {
  info.setBirth(form.birth)
  info.setGender(form.gender)
  route.push({
    path: '/yearEight',
    replace: true
  })
}

defineProps<{
  msg: string
}>()
</script>

<style scoped>
.greetings {
  width: 100%;
}

.title {
  font-family: var(--font-serif);
  font-size: var(--text-3xl);
  font-weight: var(--weight-bold);
  color: var(--color-text);
  letter-spacing: 0.08em;
  margin-bottom: var(--space-xs);
  line-height: 1.2;
}

.subtitle {
  font-size: var(--text-sm);
  color: var(--color-text-mute);
  margin-bottom: var(--space-xl);
  letter-spacing: 0.04em;
}

.ba-form {
  max-width: 420px;
}

.full-width {
  width: 100%;
}

.gender-group {
  display: flex;
  gap: var(--space-lg);
}

.gender-radio {
  --el-radio-input-border-color: var(--color-border-hover);
  margin-right: 0 !important;
}

.gender-label {
  font-family: var(--font-serif);
  font-size: var(--text-lg);
  font-weight: var(--weight-semibold);
  color: var(--color-text);
}

.gender-sub {
  font-size: var(--text-xs);
  color: var(--color-text-mute);
  margin-left: var(--space-xs);
}

.submit-btn {
  width: 100%;
  height: 44px;
  font-size: var(--text-base);
  font-weight: var(--weight-semibold);
  letter-spacing: 0.06em;
  font-family: var(--font-serif);
  margin-top: var(--space-sm);
}

@media (min-width: 1024px) {
  .title {
    text-align: center;
  }
  .subtitle {
    text-align: center;
  }
  .ba-form {
    margin: 0 auto;
  }
}
</style>
