<!-- eslint-disable vue/require-v-for-key -->
<!-- eslint-disable vue/valid-v-for -->
<template>
  <div class="eight-god-view">
    <div class="table-card">
      <div class="card-header">
        <span class="card-title">四柱八字排盘</span>
        <span class="card-badge" v-if="eightData.structure">{{ eightData.structure }}格</span>
      </div>

      <!-- 表头：四柱 -->
      <div class="table-row table-header">
        <div class="table-label">四柱</div>
        <div class="table-cell">年柱</div>
        <div class="table-cell">月柱</div>
        <div class="table-cell highlight">日元</div>
        <div class="table-cell">时柱</div>
      </div>

      <!-- 十神 -->
      <div class="table-row row-alt">
        <div class="table-label label-secondary">十神</div>
        <div class="table-cell">{{ findTenGod(eightData.yearGan) }}</div>
        <div class="table-cell">{{ findTenGod(eightData.monthGan) }}</div>
        <div class="table-cell highlight">{{ eightData.gender }}</div>
        <div class="table-cell">{{ findTenGod(eightData.timeGan) }}</div>
      </div>

      <!-- 天干 -->
      <div class="table-row">
        <div class="table-label label-primary">天干</div>
        <div class="table-cell gan-cell" :style="eightData.yearGanColor">{{ eightData.yearGan }}</div>
        <div class="table-cell gan-cell" :style="eightData.monthGanColor">{{ eightData.monthGan }}</div>
        <div class="table-cell highlight gan-cell" :style="eightData.dayGanColor">
          <el-tooltip effect="light" placement="top" :show-after="300">
            <template #content>
              <div class="tooltip-content">
                <div class="tooltip-row"><span class="tt-label">起运</span>{{ eightData.fateStart }}</div>
                <div class="tooltip-row"><span class="tt-label">格局</span>{{ eightData.structure }}格</div>
                <div class="tooltip-row"><span class="tt-label">文昌位</span>{{ eightData.literature }}</div>
                <div class="tooltip-row"><span class="tt-label">姻缘桃花</span>{{ eightData.loveInHome }}</div>
                <div class="tooltip-row"><span class="tt-label">社会桃花</span>{{ eightData.loveInSociety }}</div>
              </div>
            </template>
            <span class="day-gan">{{ eightData.dayGan }}</span>
          </el-tooltip>
        </div>
        <div class="table-cell gan-cell" :style="eightData.timeGanColor">{{ eightData.timeGan }}</div>
      </div>

      <!-- 地支 -->
      <div class="table-row">
        <div class="table-label label-primary">地支</div>
        <div class="table-cell gan-cell" :style="eightData.yearZhiColor">{{ eightData.yearZhi }}</div>
        <div class="table-cell gan-cell" :style="eightData.monthZhiColor">{{ eightData.monthZhi }}</div>
        <div class="table-cell highlight gan-cell" :style="eightData.dayZhiColor">{{ eightData.dayZhi }}</div>
        <div class="table-cell gan-cell" :style="eightData.timeZhiColor">{{ eightData.timeZhi }}</div>
      </div>

      <!-- 藏干 -->
      <div class="table-row row-alt">
        <div class="table-label label-secondary">藏干</div>
        <div class="table-cell hidden-gan-col" v-for="item in eightData.zhiHiddenGanList">
          <div class="hidden-gan-list">
            <span class="hg-item">{{ item.height }}<small>({{ item.heightGodName }})</small></span>
            <span class="hg-item" v-show="item.middle != null">{{ item.middle }}<small>({{ item.middleGodName }})</small></span>
            <span class="hg-item" v-show="item.low != null">{{ item.low }}<small>({{ item.lowGodName }})</small></span>
          </div>
        </div>
      </div>

      <!-- 纳音 -->
      <div class="table-row">
        <div class="table-label label-primary">纳音</div>
        <div class="table-cell voice-cell" v-for="item in eightData.voliceList">{{ item }}</div>
      </div>

      <!-- 神煞 -->
      <div class="table-row row-alt">
        <div class="table-label label-secondary">神煞</div>
        <div class="table-cell shensha-col" v-for="(shaList, _i) in eightData.holyGeneralList">
          <span class="sha-tag" v-for="item in shaList">{{ item }}</span>
        </div>
      </div>

      <!-- 空亡 -->
      <div class="table-row">
        <div class="table-label label-primary">空亡</div>
        <div class="table-cell" v-for="item in eightData.fallList">{{ item }}</div>
      </div>

      <!-- 天干合化 -->
      <div class="table-row row-full">
        <div class="table-label label-primary">天干合化</div>
        <div class="table-cell full-cell">{{ eightData.ganSyzygyStatus }}</div>
      </div>

      <!-- 地支合化 -->
      <div class="table-row row-full row-alt">
        <div class="table-label label-primary">地支合化</div>
        <div class="table-cell full-cell">{{ eightData.zhiSyzygyStatus }}</div>
      </div>

      <!-- 袁天罡称骨 -->
      <div class="table-row row-full">
        <div class="table-label label-accent">袁天罡称骨</div>
        <div class="table-cell full-cell yuan-cell">{{ eightData.yuanTianGang }}</div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
//@ts-ignore
import { onMounted, reactive, watchEffect } from 'vue'
import { useInfoStore } from '@/stores/info'
import { REQ_SUCCESS } from '@/util/resultStatus'
import type { jsonResult } from '@/api/common/type'
import type { userInfo, EightGodVO } from '@/api/eight/type'
import { apiGetEight } from '@/api/eight/index'

const info = useInfoStore()

let userInfoData = reactive<userInfo>({
  birth: info.birth,
  gender: info.gender
})

//@ts-ignore
let eightData = reactive<EightGodVO>({
  dayGan: '',
  dayGanColor: '',
  dayZhi: '',
  dayZhiColor: '',
  ganSyzygyStatus: '',
  gender: '',
  holyGeneralList: [],
  monthGan: '',
  monthGanColor: '',
  tenGodStatusList: [],
  timeGan: '',
  timeGanColor: '',
  timeZhi: '',
  timeZhiColor: '',
  voliceList: [],
  fallList: [],
  yearGan: '',
  yearGanColor: '',
  yearZhi: '',
  yearZhiColor: '',
  zhiHiddenGanList: [],
  zhiSyzygyStatus: '',
  yuanTianGang: '',
  fateStart: '',
  structure: ''
})

const getEight = async (queryData: userInfo) => {
  //@ts-ignore
  let result: jsonResult | any = await apiGetEight(queryData)
  clearEightData(eightData)
  if (result.status === REQ_SUCCESS) {
    //@ts-ignore
    Object.assign(eightData, result.data)
  }
}

const findTenGod = (data: string) => {
  for (let i = 0; i < eightData.tenGodStatusList.length; i++) {
    if (eightData.tenGodStatusList[i].gan === data) {
      return eightData.tenGodStatusList[i].god
    }
  }
}

const clearEightData = (eightData: EightGodVO): void => {
  for (const key in eightData) {
    if (typeof eightData[key] === 'string') {
      eightData[key] = ''
    } else if (Array.isArray(eightData[key])) {
      eightData[key] = []
    } else if (typeof eightData[key] === 'number') {
      eightData[key] = null
    }
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

watchEffect(() => {
  userInfoData.birth = formartDate(info.birth)
  userInfoData.gender = info.gender
  getEight(userInfoData)
})

onMounted(() => {
  if (info.birth == null) {
    info.birth = new Date()
  }
  userInfoData.birth = formartDate(info.birth)
  userInfoData.gender = info.gender
  getEight(userInfoData)
})
</script>

<style lang="scss" scoped>
.eight-god-view {
  width: 100%;
  max-width: 900px;
  margin: 0 auto;
}

.table-card {
  background: var(--color-bg-elevated);
  border: 1px solid var(--color-border-light);
  border-radius: var(--radius-lg);
  box-shadow: var(--shadow-md);
  overflow: hidden;
}

.card-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: var(--space-md) var(--space-lg);
  background: linear-gradient(135deg, var(--color-bg-soft), var(--color-bg-mute));
  border-bottom: 1px solid var(--color-border-light);
}

.card-title {
  font-family: var(--font-serif);
  font-size: var(--text-lg);
  font-weight: var(--weight-bold);
  color: var(--color-text);
  letter-spacing: 0.04em;
}

.card-badge {
  font-size: var(--text-xs);
  font-weight: var(--weight-semibold);
  color: var(--color-primary);
  background: var(--color-primary-light);
  padding: 3px 12px;
  border-radius: var(--radius-full);
}

/* ===== 表格行 ===== */
.table-row {
  display: grid;
  grid-template-columns: 80px repeat(4, minmax(96px, 1fr));
  min-height: 44px;
  border-bottom: 1px solid var(--color-border-light);
  transition: background-color var(--duration-fast) var(--ease-out-quart);

  &:last-child {
    border-bottom: none;
  }

  &.row-full {
    grid-template-columns: 80px 1fr;
  }

  &.row-alt {
    background: oklch(96% 0.008 82);
  }

  &:hover {
    background: oklch(93% 0.012 82);
  }

  &.table-header {
    background: var(--color-primary-light);
    font-weight: var(--weight-semibold);
    font-size: var(--text-sm);
    color: var(--color-text-soft);
    text-transform: none;

    &:hover {
      background: var(--color-primary-light);
    }
  }
}

.table-label {
  display: flex;
  align-items: center;
  padding: 0 var(--space-md);
  font-size: var(--text-sm);
  font-weight: var(--weight-semibold);
  color: var(--color-text-soft);
  background: oklch(93% 0.010 82);
  border-right: 1px solid var(--color-border-light);

  &.label-secondary {
    color: var(--color-text-mute);
  }

  &.label-primary {
    color: var(--color-text);
  }

  &.label-accent {
    color: var(--color-primary);
  }
}

.table-cell {
  display: flex;
  align-items: center;
  justify-content: center;
  padding: var(--space-sm) var(--space-md);
  font-size: var(--text-base);
  color: var(--color-text);
  text-align: center;

  &.highlight {
    position: relative;
    &::before {
      content: '';
      position: absolute;
      inset: 1px;
      border-left: 2px solid var(--color-accent);
      border-right: 2px solid var(--color-accent);
      border-radius: 2px;
      opacity: 0.4;
      pointer-events: none;
    }
  }
}

.full-cell {
  justify-content: flex-start;
  text-align: left;
  font-size: var(--text-sm);
  padding: var(--space-md) var(--space-lg);
  line-height: var(--leading-relaxed);
}

/* ===== 天干 / 地支 单元格 ===== */
.gan-cell {
  font-family: var(--font-serif);
  font-size: var(--text-xl);
  font-weight: var(--weight-bold);
  letter-spacing: 0.04em;
}

.day-gan {
  cursor: pointer;
  text-decoration: underline;
  text-decoration-style: dotted;
  text-underline-offset: 4px;
  text-decoration-color: var(--color-primary-soft);
}

/* ===== 藏干 ===== */
.hidden-gan-col {
  padding: var(--space-sm) var(--space-xs) !important;
}

.hidden-gan-list {
  display: flex;
  flex-direction: column;
  gap: 2px;
  width: 100%;
}

.hg-item {
  display: block;
  font-size: var(--text-xs);
  color: var(--color-text-soft);
  line-height: 1.8;
  padding: 1px 4px;
  border-radius: 3px;
  background: oklch(90% 0.015 80);
  text-align: center;

  small {
    font-size: 0.7rem;
    color: var(--color-text-mute);
    margin-left: 2px;
  }
}

/* ===== 纳音 ===== */
.voice-cell {
  font-size: var(--text-sm);
  color: var(--color-text-soft);
  font-family: var(--font-serif);
}

/* ===== 神煞 ===== */
.shensha-col {
  flex-wrap: wrap;
  gap: 3px;
  padding: var(--space-sm) var(--space-xs) !important;
}

.sha-tag {
  display: inline-block;
  font-size: 0.7rem;
  color: var(--color-text-soft);
  background: oklch(94% 0.010 82);
  padding: 2px 6px;
  border-radius: var(--radius-sm);
  margin: 1px;
  line-height: 1.5;
}

/* ===== 袁天罡 ===== */
.yuan-cell {
  font-family: var(--font-serif);
  color: var(--color-primary);
  font-weight: var(--weight-medium);
}

/* ===== 响应式 ===== */
@media (max-width: 768px) {
  .table-row {
    grid-template-columns: 64px repeat(4, 1fr);
  }
  .table-row.row-full {
    grid-template-columns: 64px 1fr;
  }
  .table-cell {
    font-size: var(--text-sm);
    padding: var(--space-xs) var(--space-sm);
  }
  .gan-cell {
    font-size: var(--text-lg);
  }
}
</style>

<!-- Tooltip 弹出层挂到 body 上，scoped 无法穿透，需单独非 scoped 块 -->
<style lang="scss">
.tooltip-content {
  font-size: var(--text-sm);
  line-height: 1.8;
}

.tooltip-row {
  display: flex;
  gap: var(--space-sm);
  white-space: nowrap;
}

.tt-label {
  color: var(--color-text-mute);
  min-width: 60px;
  text-align: right;
}
</style>
