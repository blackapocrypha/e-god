<!-- eslint-disable vue/require-v-for-key -->
<!-- eslint-disable vue/valid-v-for -->
<template>
  <div class="all">
    <div style="float: right; margin-bottom: 10px">
      <el-button size="large" @click="openDialog">流月流日</el-button>
    </div>
    <!--四柱-->
    <el-row :gutter="1">
      <el-col :span="4" class="topColum"> 时间:</el-col>
      <el-col :span="2" class="topColum"> 流日</el-col>
      <el-col :span="2" class="topColum"> 流月</el-col>
      <el-col :span="2" class="topColum"> 流年</el-col>
      <el-col :span="2" class="topColum"> 大运</el-col>
      <el-col :span="2" class="topColum"> 年柱</el-col>
      <el-col :span="2" class="topColum"> 月柱</el-col>
      <el-col :span="2" class="topColum"> 日元</el-col>
      <el-col :span="2" class="topColum"> 时柱</el-col>
    </el-row>

    <!--十神-->
    <el-row :gutter="1">
      <el-col :span="4" class="godColum"> 十神:</el-col>
      <el-col :span="2" class="godColum"> {{ findTenGod(eightData.timeDayGan) }}</el-col>
      <el-col :span="2" class="godColum"> {{ findTenGod(eightData.timeMonthGan) }}</el-col>
      <el-col :span="2" class="godColum"> {{ findTenGod(eightData.timeYearGan) }}</el-col>
      <el-col :span="2" class="godColum"> {{ findTenGod(eightData.timeLuckyGan) }}</el-col>
      <el-col :span="2" class="godColum"> {{ findTenGod(eightData.yearGan) }}</el-col>
      <el-col :span="2" class="godColum"> {{ findTenGod(eightData.monthGan) }}</el-col>
      <el-col :span="2" class="godColum"> {{ eightData.gender }}</el-col>
      <el-col :span="2" class="godColum"> {{ findTenGod(eightData.timeGan) }}</el-col>
    </el-row>

    <!--天干-->
    <el-row :gutter="1">
      <el-col :span="4" class="topColum" style="font-size: 16px"> 天干:</el-col>
      <el-col :span="2" class="ganColum">
        {{ eightData.timeDayGan }}
      </el-col>
      <el-col :span="2" class="ganColum"> {{ eightData.timeMonthGan }}</el-col>
      <el-col :span="2" class="ganColum"> {{ eightData.timeYearGan }}</el-col>
      <el-col :span="2" class="ganColum"> {{ eightData.timeLuckyGan }}</el-col>
      <el-col :span="2" class="ganColum"> {{ eightData.yearGan }}</el-col>
      <el-col :span="2" class="ganColum"> {{ eightData.monthGan }}</el-col>
      <el-col :span="2" class="ganColum"> {{ eightData.dayGan }}</el-col>
      <el-col :span="2" class="ganColum"> {{ eightData.timeGan }}</el-col>
    </el-row>

    <!--地支-->
    <el-row :gutter="1">
      <el-col :span="4" class="topColum" style="font-size: 16px"> 地支:</el-col>
      <el-col :span="2" class="ganColum"> {{ eightData.timeDayZhi }}</el-col>
      <el-col :span="2" class="ganColum"> {{ eightData.timeMonthZhi }}</el-col>
      <el-col :span="2" class="ganColum"> {{ eightData.timeYearZhi }}</el-col>
      <el-col :span="2" class="ganColum"> {{ eightData.timeLuckyZhi }}</el-col>
      <el-col :span="2" class="ganColum"> {{ eightData.yearZhi }}</el-col>
      <el-col :span="2" class="ganColum"> {{ eightData.monthZhi }}</el-col>
      <el-col :span="2" class="ganColum"> {{ eightData.dayZhi }}</el-col>
      <el-col :span="2" class="ganColum"> {{ eightData.timeZhi }}</el-col>
    </el-row>

    <!--藏干-->
    <el-row :gutter="1">
      <el-col :span="4" class="hiddeColum"> 藏干:</el-col>
      <el-col :span="2" class="hiddeColum" v-for="item in eightData.zhiHiddenGanList">
        <el-row class="hiddenGan">
          <el-col class="hiddenGanString"> {{ item.heightGodName }}</el-col>
          <el-col class="hiddenGanString" v-show="item.middle != null">
            {{ item.middleGodName }}</el-col
          >
          <el-col class="hiddenGanString" v-show="item.low != null"> {{ item.lowGodName }}</el-col>
        </el-row>
      </el-col>
    </el-row>

    <!--大运-->
    <el-row :gutter="1">
      <el-col :span="4" class="tenColum"> 大运:</el-col>
      <el-col :span="2" class="tenColum" v-for="(item, index) in eightData.tenLuckyList">
        <span
          class="pointer"
          :style="selectedLuckyIndex === index ? 'color: blue' : 'color: rgb(44, 62, 80)'"
          @click="pickLucky(index, item.name, 1)"
        >
          {{ item.name }}
        </span>
      </el-col>
    </el-row>
    <el-row :gutter="1">
      <el-col :span="4" class="tenColum"></el-col>
      <el-col :span="2" class="tenColum" v-for="item in eightData.tenLuckyList">
        {{ item.startYear }}
      </el-col>
    </el-row>

    <!--流年-->
    <div class="scrollable-container">
      <el-row :gutter="1">
        <el-col :span="4" class="flowYearColum"> 流年:</el-col>
        <el-col :span="2" class="flowYearColum" v-for="(item, index) in eightData.flowYearList">
          <span
            class="pointer"
            :style="selectedFlowYearIndex === index ? 'color: blue' : 'color: rgb(44, 62, 80)'"
            @click="pickFlowYear(index, item.name, 1)"
          >
            {{ item.name }}</span
          >
        </el-col>
      </el-row>
      <el-row :gutter="1">
        <el-col :span="4" class="flowYearColum"></el-col>
        <el-col :span="2" class="flowYearColum" v-for="item in eightData.flowYearList">
          {{ item.startYear }}
        </el-col>
      </el-row>
    </div>

    <!--天干合化-->
    <el-row :gutter="1">
      <el-col :span="4" class="ganStatusColum"> 天干合化:</el-col>
      <el-col :span="16" class="ganStatusColum" style="text-align: left">
        {{ eightData.ganSyzygyStatus }}
      </el-col>
    </el-row>

    <!--地支合化-->
    <el-row :gutter="1">
      <el-col :span="4" class="zhiStatusColum"> 地支合化:</el-col>
      <el-col :span="16" class="zhiStatusColum" style="text-align: left">
        {{ eightData.zhiSyzygyStatus }}
      </el-col>
    </el-row>
  </div>

  <el-dialog v-model="dialogFormVisible" title="流月流日" width="700">
    <template #footer>
      <el-form label-width="auto">
        <el-form-item label="流月">
          <el-radio-group v-model="userInfoData.month">
            <el-radio
              v-for="item in eightData.flowMonthList"
              @click="freshFlowDayWhenChosenMonth()"
              :value="item.startYear"
              >{{ item.name }}({{ item.startYear }}月)</el-radio
            >
          </el-radio-group>
        </el-form-item>
        <el-form-item label="流日">
          <el-radio-group v-model="userInfoData.day">
            <el-radio
              style="width: 120px"
              v-for="item in eightData.flowDayList"
              :value="item.startYear"
              >{{ item.name }} ({{ item.startYear }})</el-radio
            >
          </el-radio-group>
        </el-form-item>
        <br />
      </el-form>

      <div class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button type="primary" @click="getLucky(userInfoData)"> 确定 </el-button>
      </div>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
//@ts-ignore
import { onMounted, reactive, watchEffect, ref } from 'vue'
import { ElMessage } from 'element-plus'
import { useInfoStore } from '@/stores/info'
import { REQ_SUCCESS } from '@/util/resultStatus'
import type { jsonResult } from '@/api/common/type'
import type { userTimeInfo, EightGodTimeVO } from '@/api/eight/type'
import { apiGetLucky } from '@/api/eight/index'

const info = useInfoStore()
const selectedLuckyIndex = ref<number>()
const selectedFlowYearIndex = ref<number | any>()
const selectedFlowMonthIndex = ref<number>()
const selectedFlowDayIndex = ref<number>()

const dialogFormVisible = ref(false)

// 查询数据
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
  ganSyzygyStatus: '',
  gender: '',
  monthGan: '',
  tenGodStatusList: [],
  timeGan: '',
  timeZhi: '',
  yearGan: '',
  yearZhi: '',
  timeLuckyGan: '',
  timeLuckyZhi: '',
  timeMonthGan: '',
  timeMonthZhi: '',
  timeYearGan: '',
  timeYearZhi: '',
  timeDayGan: '',
  timeDayZhi: '',
  zhiHiddenGanList: [],
  zhiSyzygyStatus: '',
  tenLuckyList: [],
  flowYearList: [],
  flowMonthList: [],
  flowDayList: []
})

// 查询菜单数据
const getLucky = async (queryData: userTimeInfo) => {
  dialogFormVisible.value = false
  //@ts-ignore
  let result: jsonResult | any = await apiGetLucky(queryData)
  clearEightData(eightData)
  if (result.status === REQ_SUCCESS) {
    //@ts-ignore
    Object.assign(eightData, result.data)
    // 单独载入大运、流年月日等干支
    if (eightData.timeLuckyGan != null) {
      userInfoData.lucky = eightData.timeLuckyGan + eightData.timeLuckyZhi
    }
  }

  findLuckyZone()
  findFlowYearZone()
  findFlowMonthZone()
  findFlowDayZone()
}

// 选中月份时同步更新流日
const freshFlowDayWhenChosenMonth = async () => {
  //@ts-ignore
  let result: jsonResult | any = await apiGetLucky(userInfoData)
  clearEightData(eightData)
  if (result.status === REQ_SUCCESS) {
    //@ts-ignore
    Object.assign(eightData, result.data)
    // 单独载入大运、流年月日等干支
    if (eightData.timeLuckyGan != null) {
      userInfoData.lucky = eightData.timeLuckyGan + eightData.timeLuckyZhi
    }
  }

  findLuckyZone()
  findFlowYearZone()
  findFlowMonthZone()
  findFlowDayZone()
}

// 根据对应天干找到十神
const findTenGod = (data: string) => {
  for (let i = 0; i < eightData.tenGodStatusList.length; i++) {
    if (eightData.tenGodStatusList[i].gan === data) {
      return eightData.tenGodStatusList[i].god
    }
  }
}

// 打开对话框
const openDialog = () => {
  if (userInfoData.year == null) {
    ElMessage({
      message: '请先选择对应年份',
      type: 'warning'
    })
  } else {
    dialogFormVisible.value = true
  }
}

// 默认选中当前大运所在年份
const findLuckyZone = () => {
  for (let i = 0; i < eightData.tenLuckyList.length; i++) {
    if (eightData.tenLuckyList[i].name == eightData.timeLuckyGan + eightData.timeLuckyZhi) {
      selectedLuckyIndex.value = i
    }
  }
}
// 默认选中当前流年所在的年份
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
// 默认选中当前流月所在的月份
const findFlowMonthZone = () => {
  if (userInfoData.month == null) {
    for (let i = 0; i < eightData.flowMonthList.length; i++) {
      if (eightData.flowMonthList[i].startYear == new Date().getMonth() + 1) {
        selectedFlowMonthIndex.value = i
        userInfoData.month = eightData.flowMonthList[i].startYear
      }
    }
  } else {
    for (let i = 0; i < eightData.flowMonthList.length; i++) {
      if (eightData.flowMonthList[i].startYear == userInfoData.month) {
        selectedFlowMonthIndex.value = i
        userInfoData.month = eightData.flowMonthList[i].startYear
      }
    }
  }
}
// 默认选中当前流日所在的日期
const findFlowDayZone = () => {
  if (userInfoData.day == null) {
    for (let i = 0; i < eightData.flowDayList.length; i++) {
      if (eightData.flowDayList[i].startYear == new Date().getDay()) {
        selectedFlowDayIndex.value = i
        userInfoData.day = eightData.flowDayList[i].startYear
      }
    }
  } else {
    for (let i = 0; i < eightData.flowDayList.length; i++) {
      if (eightData.flowDayList[i].startYear == userInfoData.day) {
        selectedFlowDayIndex.value = i
        userInfoData.day = eightData.flowDayList[i].startYear
      }
    }
  }
}

// 选中对应的大运
const pickLucky = (index: any, data: string | undefined, type: number) => {
  selectedLuckyIndex.value = index
  selectedFlowYearIndex.value = null
  userInfoData.lucky = data
  userInfoData.year = null
  userInfoData.month = null
  userInfoData.day = null
  eightData.timeYearGan = ''
  eightData.timeYearZhi = ''
  eightData.timeMonthGan = ''
  eightData.timeMonthZhi = ''
  eightData.timeDayGan = ''
  eightData.timeDayZhi = ''
  selectedFlowYearIndex.value = null
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
  selectedFlowYearIndex.value = index
  for (let i = 0; i < eightData.flowYearList.length; i++) {
    if (eightData.flowYearList[i].name === data) {
      userInfoData.year = eightData.flowYearList[i].startYear
      userInfoData.birth = formartDate(info.birth)
      userInfoData.gender = info.gender
      getLucky(userInfoData)
    }
  }
}

// 清空缓存数据
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

// 格式化日期
const formartDate = (date: any) => {
  const year = date.getFullYear()
  const month = (date.getMonth() + 1).toString().padStart(2, '0')
  const day = date.getDate().toString().padStart(2, '0')
  const hours = date.getHours().toString().padStart(2, '0')
  const minutes = date.getMinutes().toString().padStart(2, '0')
  const seconds = date.getSeconds().toString().padStart(2, '0')
  return `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`
}

// 监听数据变化
watchEffect(() => {
  userInfoData.birth = formartDate(info.birth)
  userInfoData.gender = info.gender
  //getLucky(userInfoData)
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
})
</script>

<style lang="scss">
.all {
  height: 100%;
  width: 100%;

  .scrollable-container {
    width: 100%; /* 根据需要调整容器宽度 */
    overflow-x: auto; /* 当内容超出容器宽度时显示滚动条 */
  }

  .pointer {
    cursor: pointer;
  }

  .monthItem {
    display: inline-block;
    width: calc(100% / 12);
    height: 50px;
    background-color: lightblue;
    text-align: center;
    line-height: 50px;
  }

  .el-row {
    width: 120%;
  }

  .topColum {
    height: 40px;
    background-color: rgb(164, 166, 169);
    //border: 1px solid rgb(167, 160, 160);
  }
  .godColum {
    height: 40px;
    background-color: rgb(229, 233, 242);
  }
  .ganColum {
    height: 40px;
    background-color: rgb(164, 166, 169);
    font-size: 22px;
    font-weight: bold;
    // border: 1px solid rgb(167, 160, 160);
  }
  .hiddeColum {
    background-color: rgb(229, 233, 242);
    height: 86px;
    .hiddenGan {
      font-size: 12px;
      margin-top: 0px;
      .hiddenGanString {
        height: 22px;
      }
    }
  }

  .voiceColum {
    height: 40px;
    background-color: rgb(164, 166, 169);
  }
  .shenShaColum {
    background-color: rgb(229, 233, 242);
    p {
      background-color: rgb(229, 233, 242);
      height: 24px;
      line-height: 22px;
    }
  }
  .tenColum {
    height: 40px;
    background-color: rgb(164, 166, 169);
    .pointer {
      cursor: pointer;
    }
  }
  .flowYearColum {
    height: 40px;
    background-color: rgb(229, 233, 242);
  }
  .flowMonthColum {
    height: 40px;
    background-color: rgb(164, 166, 169);
  }
  .ganStatusColum {
    height: 40px;
    background-color: rgb(164, 166, 169);
  }
  .zhiStatusColum {
    background-color: rgb(229, 233, 242);
  }
}
.el-row {
  margin-bottom: 0px;
}
.el-row:last-child {
  margin-bottom: 0;
}
.el-col {
  line-height: 40px;
  text-align: center;
  font-size: 16px;
}
</style>
