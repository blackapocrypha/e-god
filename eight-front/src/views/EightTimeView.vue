<!-- eslint-disable vue/require-v-for-key -->
<!-- eslint-disable vue/valid-v-for -->
<template>
  <div class="eight-time-view">
    <div class="page-toolbar">
      <h2 class="page-title">大运流年</h2>
    </div>

    <!-- ===== 核心表格 ===== -->
    <div class="table-card">
      <div class="card-header">
        <span class="card-title">八字运程详批</span>
      </div>

      <!-- 表头 -->
      <div class="table-row table-header">
        <div class="table-label">时间</div>
        <div class="table-cell">流日</div>
        <div class="table-cell">流月</div>
        <div class="table-cell">流年</div>
        <div class="table-cell">大运</div>
        <div class="table-cell">年柱</div>
        <div class="table-cell">月柱</div>
        <div class="table-cell highlight">日元</div>
        <div class="table-cell">时柱</div>
      </div>

      <!-- 十神 -->
      <div class="table-row row-alt">
        <div class="table-label label-secondary">十神</div>
        <div class="table-cell">{{ findTenGod(eightData.timeDayGan) }}</div>
        <div class="table-cell">{{ findTenGod(eightData.timeMonthGan) }}</div>
        <div class="table-cell">{{ findTenGod(eightData.timeYearGan) }}</div>
        <div class="table-cell">{{ findTenGod(eightData.timeLuckyGan) }}</div>
        <div class="table-cell">{{ findTenGod(eightData.yearGan) }}</div>
        <div class="table-cell">{{ findTenGod(eightData.monthGan) }}</div>
        <div class="table-cell highlight">{{ eightData.gender }}</div>
        <div class="table-cell">{{ findTenGod(eightData.timeGan) }}</div>
      </div>

      <!-- 天干 -->
      <div class="table-row">
        <div class="table-label label-primary">天干</div>
        <div class="table-cell gan-cell" :style="eightData.timeDayGanColor">{{ eightData.timeDayGan }}</div>
        <div class="table-cell gan-cell" :style="eightData.timeMonthGanColor">{{ eightData.timeMonthGan }}</div>
        <div class="table-cell gan-cell" :style="eightData.timeYearGanColor">{{ eightData.timeYearGan }}</div>
        <div class="table-cell gan-cell" :style="eightData.timeLuckyGanColor">{{ eightData.timeLuckyGan }}</div>
        <div class="table-cell gan-cell" :style="eightData.yearGanColor">{{ eightData.yearGan }}</div>
        <div class="table-cell gan-cell" :style="eightData.monthGanColor">{{ eightData.monthGan }}</div>
        <div class="table-cell highlight gan-cell" :style="eightData.dayGanColor">{{ eightData.dayGan }}</div>
        <div class="table-cell gan-cell" :style="eightData.timeGanColor">{{ eightData.timeGan }}</div>
      </div>

      <!-- 地支 -->
      <div class="table-row">
        <div class="table-label label-primary">地支</div>
        <div class="table-cell gan-cell" :style="eightData.timeDayZhiColor">{{ eightData.timeDayZhi }}</div>
        <div class="table-cell gan-cell" :style="eightData.timeMonthZhiColor">{{ eightData.timeMonthZhi }}</div>
        <div class="table-cell gan-cell" :style="eightData.timeYearZhiColor">{{ eightData.timeYearZhi }}</div>
        <div class="table-cell gan-cell" :style="eightData.timeLuckyZhiColor">{{ eightData.timeLuckyZhi }}</div>
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
            <span class="hg-item" v-show="item.heightGodName">{{ item.heightGodName }}</span>
            <span class="hg-item" v-show="item.middleGodName">{{ item.middleGodName }}</span>
            <span class="hg-item" v-show="item.lowGodName">{{ item.lowGodName }}</span>
          </div>
        </div>
      </div>
    </div>

    <!-- ===== 大运选择 ===== -->
    <div class="table-card section-card">
      <div class="card-header">
        <span class="card-title">十年大运</span>
      </div>
      <div class="scrollable-container">
        <div class="lucky-grid">
          <div
            v-for="(item, index) in eightData.tenLuckyList"
            :key="index"
            class="lucky-item"
            :class="{ active: selectedLuckyIndex === index }"
            @click="pickLucky(index, item.name, 1)"
          >
            <span class="lucky-ganzhi">{{ item.name }}</span>
            <span class="lucky-years">{{ item.startYear }}</span>
          </div>
        </div>
      </div>
    </div>

    <!-- ===== 流年选择 ===== -->
    <div class="table-card section-card">
      <div class="card-header">
        <span class="card-title">流年</span>
      </div>
      <div class="scrollable-container">
        <div class="lucky-grid">
          <div
            v-for="(item, index) in eightData.flowYearList"
            :key="index"
            class="lucky-item"
            :class="{ active: selectedFlowYearIndex === index }"
            @click="pickFlowYear(index, item.name, 1)"
          >
            <span class="lucky-ganzhi">{{ item.name }}</span>
            <span class="lucky-years">{{ item.startYear }}</span>
          </div>
        </div>
      </div>
    </div>

    <!-- ===== 流月选择（仅选了流年后显示） ===== -->
    <div v-if="fullYearMonthDaysArray.length > 0" class="table-card section-card">
      <div class="card-header">
        <span class="card-title">流月</span>
        <span class="card-hint">以节令划分为准</span>
      </div>
      <div class="scrollable-container">
        <div class="lucky-grid">
          <div
            v-for="(item, index) in fullYearMonthDaysArray"
            :key="item.month"
            class="lucky-item"
            :class="{ active: selectedFlowMonthIndex === index }"
            @click="pickFlowMonth(item.month, item.monthGanZhi)"
          >
            <span class="lucky-ganzhi">{{ item.monthGanZhi }}</span>
            <span class="lucky-years">{{ item.month }}月</span>
          </div>
        </div>
      </div>
    </div>

    <!-- ===== 流日选择（仅选了流月后显示） ===== -->
    <div v-if="fullDays.length > 0" class="table-card section-card">
      <div class="card-header">
        <span class="card-title">流日</span>
        <span class="card-hint">所选月份内</span>
      </div>
      <div class="scrollable-container">
        <div class="lucky-grid">
          <div
            v-for="(item, index) in fullDays"
            :key="item.date"
            class="lucky-item"
            :class="{ active: selectedFlowDayIndex === index }"
            @click="pickFlowDay(item.date, item.dayGanZhi)"
          >
            <span class="lucky-ganzhi">{{ item.dayGanZhi }}</span>
            <span class="lucky-years">{{ item.date?.substring(5, 10) }}</span>
          </div>
        </div>
      </div>
    </div>

    <!-- ===== 合化 ===== -->
    <div class="table-card section-card">
      <div class="table-row row-full">
        <div class="table-label label-primary">天干合化</div>
        <div class="table-cell full-cell">{{ eightData.ganSyzygyStatus }}</div>
      </div>
      <div class="table-row row-full">
        <div class="table-label label-primary">地支合化</div>
        <div class="table-cell full-cell">{{ eightData.zhiSyzygyStatus }}</div>
      </div>
    </div>
  </div>

</template>

<script setup lang="ts">
//@ts-ignore
import { onMounted, reactive, watchEffect, ref } from 'vue'
import { useInfoStore } from '@/stores/info'
import { REQ_SUCCESS } from '@/util/resultStatus'
import type { jsonResult } from '@/api/common/type'
import type {
  userTimeInfo,
  EightGodTimeVO,
  FullYearMonthDaysVO,
  TimeLuckyMonthDayVO
} from '@/api/eight/type'
import { apiGetLucky, getFullYearMonthDays } from '@/api/eight/index'

const info = useInfoStore()
const selectedLuckyIndex = ref<number>()
const selectedFlowYearIndex = ref<number | any>()
const selectedFlowMonthIndex = ref<number>()
const selectedFlowDayIndex = ref<number>()

const fullYearMonthDaysArray = ref<FullYearMonthDaysVO[]>([])
const fullDays = ref<TimeLuckyMonthDayVO[]>([])

let userInfoData = reactive<userTimeInfo>({
  birth: info.birth,
  gender: info.gender,
  lucky: null,
  year: null,
  month: null,
  day: null
})

//@ts-ignore
let eightData = reactive<EightGodTimeVO>({
  dayGan: '',
  dayZhi: '',
  dayGanColor: '',
  dayZhiColor: '',
  ganSyzygyStatus: '',
  gender: '',
  monthGan: '',
  monthZhi: '',
  monthGanColor: '',
  monthZhiColor: '',
  tenGodStatusList: [],
  timeGan: '',
  timeZhi: '',
  yearGan: '',
  yearZhi: '',
  timeGanColor: '',
  timeZhiColor: '',
  yearGanColor: '',
  yearZhiColor: '',
  timeLuckyGan: '',
  timeLuckyZhi: '',
  timeMonthGan: '',
  timeMonthZhi: '',
  timeYearGan: '',
  timeYearZhi: '',
  timeDayGan: '',
  timeDayZhi: '',
  timeLuckyGanColor: '',
  timeLuckyZhiColor: '',
  timeMonthGanColor: '',
  timeMonthZhiColor: '',
  timeYearGanColor: '',
  timeYearZhiColor: '',
  timeDayGanColor: '',
  timeDayZhiColor: '',
  zhiHiddenGanList: [],
  zhiSyzygyStatus: '',
  tenLuckyList: [],
  flowYearList: [],
  flowMonthList: [],
  flowDayList: []
})

const getLucky = async (queryData: userTimeInfo) => {
  //@ts-ignore
  let result: jsonResult | any = await apiGetLucky(queryData)
  clearEightData(eightData)
  if (result.status === REQ_SUCCESS) {
    //@ts-ignore
    Object.assign(eightData, result.data)
    if (eightData.timeLuckyGan != null) {
      userInfoData.lucky = eightData.timeLuckyGan + eightData.timeLuckyZhi
    }
    eightData.monthGan = result.data.monthGan
    eightData.monthZhi = result.data.monthZhi
  }
  findLuckyZone()
  findFlowYearZone()
}

const getFullDays = async (year: number) => {
  //@ts-ignore
  let result: jsonResult | any = await getFullYearMonthDays(year)
  if (result.status === REQ_SUCCESS) {
    fullYearMonthDaysArray.value = [...result.data]
    // 自动选中当前月份（或保持已有选中）
    findFlowMonthZone()
    // 根据选中月份加载流日
    fullYearMonthDaysArray.value.forEach((element) => {
      if (userInfoData.month == element.month) {
        fullDays.value = [...element.days]
        findFlowDayZone()
        return
      }
    })
  }
}

const findTenGod = (data: string) => {
  for (let i = 0; i < eightData.tenGodStatusList.length; i++) {
    if (eightData.tenGodStatusList[i].gan === data) {
      return eightData.tenGodStatusList[i].god
    }
  }
}

const findLuckyZone = () => {
  for (let i = 0; i < eightData.tenLuckyList.length; i++) {
    if (eightData.tenLuckyList[i].name == eightData.timeLuckyGan + eightData.timeLuckyZhi) {
      selectedLuckyIndex.value = i
    }
  }
}

const findFlowYearZone = () => {
  if (userInfoData.year == null) {
    for (let i = 0; i < eightData.flowYearList.length; i++) {
      let y = new Date().getFullYear()
      if (eightData.flowYearList[i].startYear == y) {
        selectedFlowYearIndex.value = i
        userInfoData.year = y
      }
    }
  } else {
    for (let i = 0; i < eightData.flowYearList.length; i++) {
      if (eightData.flowYearList[i].startYear == userInfoData.year) {
        selectedFlowYearIndex.value = i
      }
    }
  }
}

const findFlowMonthZone = () => {
  if (userInfoData.month == null) {
    for (let i = 0; i < fullYearMonthDaysArray.value.length; i++) {
      if (fullYearMonthDaysArray.value[i].month == new Date().getMonth() + 1) {
        selectedFlowMonthIndex.value = i
        userInfoData.month = fullYearMonthDaysArray.value[i].month
      }
    }
  } else {
    for (let i = 0; i < fullYearMonthDaysArray.value.length; i++) {
      if (fullYearMonthDaysArray.value[i].month == userInfoData.month) {
        selectedFlowMonthIndex.value = i
        userInfoData.month = fullYearMonthDaysArray.value[i].month
      }
    }
  }
}

const findFlowDayZone = () => {
  if (userInfoData.day == null) {
    for (let i = 0; i < fullDays.value.length; i++) {
      if (fullDays.value[i].day == new Date().getDay()) {
        selectedFlowDayIndex.value = i
        userInfoData.day = fullDays.value[i].day
      }
    }
  } else {
    for (let i = 0; i < fullDays.value.length; i++) {
      if (fullDays.value[i].day == userInfoData.day) {
        selectedFlowDayIndex.value = fullDays.value[i].day
        userInfoData.day = fullDays.value[i].day
      }
    }
  }
}

const pickLucky = (index: any, data: string | undefined, type: number) => {
  selectedLuckyIndex.value = index
  selectedFlowYearIndex.value = null
  selectedFlowMonthIndex.value = null
  selectedFlowDayIndex.value = null
  userInfoData.lucky = data
  userInfoData.year = null
  userInfoData.month = null
  userInfoData.day = null
  // 清空流月流日数据（切换大运后需重新选年才能加载）
  fullYearMonthDaysArray.value = []
  fullDays.value = []
  eightData.timeYearGan = ''
  eightData.timeYearZhi = ''
  eightData.timeMonthGan = ''
  eightData.timeMonthZhi = ''
  eightData.timeDayGan = ''
  eightData.timeDayZhi = ''
  userInfoData.birth = formartDate(info.birth)
  userInfoData.gender = info.gender
  getLucky(userInfoData)
}

const pickFlowYear = (index: any, data: string | undefined, type: number) => {
  eightData.timeYearGan = ''
  eightData.timeYearZhi = ''
  eightData.timeMonthGan = ''
  eightData.timeMonthZhi = ''
  eightData.timeDayGan = ''
  eightData.timeDayZhi = ''
  userInfoData.month = null
  userInfoData.day = null
  selectedFlowMonthIndex.value = null
  selectedFlowDayIndex.value = null
  // 清空流日数据（切换流年后需重新选月才能加载）
  fullDays.value = []
  selectedFlowYearIndex.value = index
  for (let i = 0; i < eightData.flowYearList.length; i++) {
    if (eightData.flowYearList[i].name === data) {
      userInfoData.year = eightData.flowYearList[i].startYear
      userInfoData.birth = formartDate(info.birth)
      userInfoData.gender = info.gender
      getLucky(userInfoData)
    }
  }
  getFullDays(userInfoData.year)
}

const pickFlowMonth = (month: number, _ganzhi: string) => {
  userInfoData.month = month
  userInfoData.day = null
  // 找到月份对应索引，更新高亮
  const idx = fullYearMonthDaysArray.value.findIndex((m) => m.month === month)
  if (idx >= 0) selectedFlowMonthIndex.value = idx
  // 刷新流日列表
  fullYearMonthDaysArray.value.forEach((element) => {
    if (userInfoData.month == element.month) {
      fullDays.value = [...element.days]
    }
  })
  selectedFlowDayIndex.value = null
  // 调用后端刷新排盘
  getLucky(userInfoData)
}

const pickFlowDay = (dateStr: string, _ganzhi: string) => {
  if (!dateStr) return
  const dateObject = new Date(dateStr)
  userInfoData.year = dateObject.getFullYear()
  userInfoData.month = dateObject.getMonth() + 1
  userInfoData.day = dateObject.getDate()
  // 找到日期对应索引，更新高亮
  const idx = fullDays.value.findIndex((d) => d.date === dateStr)
  if (idx >= 0) selectedFlowDayIndex.value = idx
  getLucky(userInfoData)
}

const clearEightData = (eightData: EightGodTimeVO): void => {
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

const clearUserInfoData = (userInfoData: userTimeInfo): void => {
  for (const key in userInfoData) {
    if (typeof userInfoData[key] === 'string') {
      userInfoData[key] = ''
    } else if (typeof userInfoData[key] === 'number') {
      userInfoData[key] = null
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
})

onMounted(() => {
  clearUserInfoData(userInfoData)
  clearEightData(eightData)
  if (info.birth == null) {
    info.birth = new Date()
  }
  userInfoData.birth = formartDate(info.birth)
  userInfoData.gender = info.gender
  getLucky(userInfoData)
  let year: number = new Date().getFullYear()
  userInfoData.year = year
  getFullDays(year)
})
</script>

<style lang="scss" scoped>
.eight-time-view {
  width: 100%;
  max-width: 900px;
  margin: 0 auto;
  display: flex;
  flex-direction: column;
  gap: var(--space-md);
}

/* ===== 页面工具栏 ===== */
.page-toolbar {
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.page-title {
  font-family: var(--font-serif);
  font-size: var(--text-2xl);
  font-weight: var(--weight-bold);
  color: var(--color-text);
  letter-spacing: 0.06em;
}

/* ===== 表格卡片 (复用 EightGodView 的类) ===== */
.table-card {
  background: var(--color-bg-elevated);
  border: 1px solid var(--color-border-light);
  border-radius: var(--radius-lg);
  box-shadow: var(--shadow-md);
  overflow: hidden;

  &.section-card {
    box-shadow: var(--shadow-sm);
  }
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
  font-size: var(--text-base);
  font-weight: var(--weight-semibold);
  color: var(--color-text);
  letter-spacing: 0.04em;
}

.card-hint {
  font-size: var(--text-xs);
  color: var(--color-text-mute);
  letter-spacing: 0.02em;
}

/* ===== 表格行 ===== */
.table-row {
  display: grid;
  grid-template-columns: 64px repeat(8, minmax(64px, 1fr));
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
    font-size: var(--text-xs);
    color: var(--color-text-soft);

    &:hover {
      background: var(--color-primary-light);
    }
  }
}

.table-label {
  display: flex;
  align-items: center;
  padding: 0 var(--space-sm);
  font-size: var(--text-xs);
  font-weight: var(--weight-semibold);
  color: var(--color-text-soft);
  background: oklch(93% 0.010 82);
  border-right: 1px solid var(--color-border-light);

  &.label-secondary { color: var(--color-text-mute); }
  &.label-primary { color: var(--color-text); }
}

.table-cell {
  display: flex;
  align-items: center;
  justify-content: center;
  padding: var(--space-xs) var(--space-sm);
  font-size: var(--text-sm);
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

.gan-cell {
  font-family: var(--font-serif);
  font-size: var(--text-lg);
  font-weight: var(--weight-bold);
  letter-spacing: 0.04em;
}

/* ===== 藏干 ===== */
.hidden-gan-col {
  padding: var(--space-xs) !important;
}

.hidden-gan-list {
  display: flex;
  flex-direction: column;
  gap: 1px;
  width: 100%;
}

.hg-item {
  font-size: 0.65rem;
  color: var(--color-text-soft);
  line-height: 1.6;
  padding: 0 2px;
  text-align: center;
}

/* ===== 大运 / 流年选择 ===== */
.scrollable-container {
  width: 100%;
  overflow-x: auto;
  padding: var(--space-md);

  &::-webkit-scrollbar {
    height: 6px;
  }
  &::-webkit-scrollbar-thumb {
    background: var(--color-border-hover);
    border-radius: 3px;
  }
  &::-webkit-scrollbar-track {
    background: var(--color-bg-soft);
    border-radius: 3px;
  }
}

.lucky-grid {
  display: flex;
  gap: var(--space-sm);
  min-width: max-content;
}

.lucky-item {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 2px;
  padding: var(--space-sm) var(--space-md);
  min-width: 72px;
  border: 1px solid var(--color-border-light);
  border-radius: var(--radius-md);
  background: var(--color-bg);
  cursor: pointer;
  transition: all var(--duration-fast) var(--ease-out-quart);

  &:hover {
    border-color: var(--color-primary-soft);
    background: var(--color-primary-light);
  }

  &.active {
    border-color: var(--color-primary);
    background: var(--color-primary);
    box-shadow: 0 2px 12px oklch(52% 0.18 25 / 0.25);

    .lucky-ganzhi,
    .lucky-years {
      color: #fff;
    }
  }
}

.lucky-ganzhi {
  font-family: var(--font-serif);
  font-size: var(--text-base);
  font-weight: var(--weight-semibold);
  color: var(--color-text);
}

.lucky-years {
  font-size: var(--text-xs);
  color: var(--color-text-mute);
}

/* ===== 响应式 ===== */
@media (max-width: 768px) {
  .table-row {
    grid-template-columns: 48px repeat(8, 1fr);
  }
  .table-row.row-full {
    grid-template-columns: 48px 1fr;
  }
  .table-cell {
    font-size: var(--text-xs);
    padding: var(--space-xs) 2px;
  }
  .gan-cell {
    font-size: var(--text-sm);
  }
  .page-title {
    font-size: var(--text-xl);
  }
}
</style>
