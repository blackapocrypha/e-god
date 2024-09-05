<!-- eslint-disable vue/require-v-for-key -->
<!-- eslint-disable vue/valid-v-for -->
<template>
  <div class="all">
    <!--四柱-->
    <el-row :gutter="1">
      <el-col :span="4" class="topColum"> 四柱:</el-col>
      <el-col :span="4" class="topColum"> 年柱</el-col>
      <el-col :span="4" class="topColum"> 月柱</el-col>
      <el-col :span="4" class="topColum"> 日元</el-col>
      <el-col :span="4" class="topColum"> 时柱</el-col>
    </el-row>

    <!--十神-->
    <el-row :gutter="1">
      <el-col :span="4" class="godColum"> 十神:</el-col>
      <el-col :span="4" class="godColum"> {{ findTenGod(eightData.yearGan) }}</el-col>
      <el-col :span="4" class="godColum"> {{ findTenGod(eightData.monthGan) }}</el-col>
      <el-col :span="4" class="godColum"> {{ eightData.gender }}</el-col>
      <el-col :span="4" class="godColum"> {{ findTenGod(eightData.timeGan) }}</el-col>
    </el-row>

    <!--天干-->
    <el-row :gutter="1">
      <el-col :span="4" class="topColum" style="font-size: 16px"> 天干:</el-col>
      <el-col :span="4" class="ganColum" :style="eightData.yearGanColor">
        {{ eightData.yearGan }}</el-col
      >
      <el-col :span="4" class="ganColum" :style="eightData.monthGanColor">
        {{ eightData.monthGan }}</el-col
      >
      <el-col :span="4" class="ganColum" :style="eightData.dayGanColor">
        {{ eightData.dayGan }}</el-col
      >
      <el-col :span="4" class="ganColum" :style="eightData.timeGanColor">
        {{ eightData.timeGan }}</el-col
      >
    </el-row>

    <!--地支-->
    <el-row :gutter="1">
      <el-col :span="4" class="topColum" style="font-size: 16px"> 地支:</el-col>
      <el-col :span="4" class="ganColum" :style="eightData.yearZhiColor">
        {{ eightData.yearZhi }}</el-col
      >
      <el-col :span="4" class="ganColum" :style="eightData.monthZhiColor">
        {{ eightData.monthZhi }}</el-col
      >
      <el-col :span="4" class="ganColum" :style="eightData.dayZhiColor">
        {{ eightData.dayZhi }}</el-col
      >
      <el-col :span="4" class="ganColum" :style="eightData.timeZhiColor">
        {{ eightData.timeZhi }}</el-col
      >
    </el-row>

    <!--藏干-->
    <el-row :gutter="1">
      <el-col :span="4" class="hiddeColum"> 藏干:</el-col>
      <el-col :span="4" class="hiddeColum" v-for="item in eightData.zhiHiddenGanList">
        <el-row class="hiddenGan">
          <el-col class="hiddenGanString">{{ item.height }} ({{ item.heightGodName }})</el-col>
          <el-col class="hiddenGanString" v-show="item.middle != null"
            >{{ item.middle }} ({{ item.middleGodName }})</el-col
          >
          <el-col class="hiddenGanString" v-show="item.low != null"
            >{{ item.low }} ({{ item.lowGodName }})</el-col
          >
        </el-row>
      </el-col>
    </el-row>

    <!--纳音-->
    <el-row :gutter="1">
      <el-col :span="4" class="voiceColum"> 纳音:</el-col>
      <el-col :span="4" class="voiceColum"> {{ eightData.voliceList[0] }}</el-col>
      <el-col :span="4" class="voiceColum"> {{ eightData.voliceList[1] }}</el-col>
      <el-col :span="4" class="voiceColum"> {{ eightData.voliceList[2] }}</el-col>
      <el-col :span="4" class="voiceColum"> {{ eightData.voliceList[3] }}</el-col>
    </el-row>

    <!--神煞-->
    <el-row :gutter="1">
      <el-col :span="4" class="shenShaColum"> 神煞:</el-col>
      <el-col :span="4" class="shenShaColum">
        <p v-for="item in eightData.holyGeneralList[0]">{{ item }}</p>
      </el-col>
      <el-col :span="4" class="shenShaColum">
        <p v-for="item in eightData.holyGeneralList[1]">{{ item }}</p>
      </el-col>
      <el-col :span="4" class="shenShaColum">
        <p v-for="item in eightData.holyGeneralList[2]">{{ item }}</p>
      </el-col>
      <el-col :span="4" class="shenShaColum">
        <p v-for="item in eightData.holyGeneralList[3]">{{ item }}</p>
      </el-col>
    </el-row>

    <!--空亡-->
    <el-row :gutter="1">
      <el-col :span="4" class="fallColum"> 空亡:</el-col>
      <el-col :span="4" class="fallColum"> {{ eightData.fallList[0] }}</el-col>
      <el-col :span="4" class="fallColum"> {{ eightData.fallList[1] }}</el-col>
      <el-col :span="4" class="fallColum"> {{ eightData.fallList[2] }}</el-col>
      <el-col :span="4" class="fallColum"> {{ eightData.fallList[3] }}</el-col>
    </el-row>

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

// 查询数据
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
  zhiSyzygyStatus: ''
})

// 查询菜单数据
const getEight = async (queryData: userInfo) => {
  //@ts-ignore
  let result: jsonResult | any = await apiGetEight(queryData)
  clearEightData(eightData)
  if (result.status === REQ_SUCCESS) {
    //@ts-ignore
    Object.assign(eightData, result.data)
  }
}

// 根据对应天干找到十神
const findTenGod = (data: string) => {
  for (let i = 0; i < eightData.tenGodStatusList.length; i++) {
    if (eightData.tenGodStatusList[i].gan === data) {
      return eightData.tenGodStatusList[i].god
    }
  }
}

// 清空缓存数据
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
  //getEight(userInfoData)
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

<style lang="scss">
.all {
  height: 100%;
  width: 100%;

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
  .fallColum {
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
  .ganStatusColum {
    height: 40px;
    background-color: rgb(229, 233, 242);
  }
  .zhiStatusColum {
    height: 40px;
    background-color: rgb(164, 166, 169);
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
