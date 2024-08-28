/**
 * 用户信息
 */
export interface userInfo {
  birth: any
  /**
   * 性别 1男 2女
   */
  gender: any

  [property: string]: any
}

export interface userTimeInfo {
  /**
   * 生日
   */
  birth: any
  /**
   * 性别 1男 2女
   */
  gender: any
  /**
   * 大运
   */
  lucky: any

  /**
   * 年份
   */
  year: any

  /**
   * 月份
   */
  month: any

  /**
   * 日
   */
  day: any
  [property: string]: any
}

/**
 * EightGodVO
 */
export interface EightGodVO {
  /**
   * 日干
   */
  dayGan: string
  /**
   * 日支
   */
  dayZhi: string
  /**
   * 天干合冲信息
   */
  ganSyzygyStatus: string
  /**
   * 性别
   */
  gender: string
  /**
   * 神煞
   */
  holyGeneralList: Array<string[]>
  /**
   * 月干
   */
  monthGan: string
  /**
   * 月支
   */
  monthZhi: string
  /**
   * 天干十神信息
   */
  tenGodStatusList: TenGodStatusList[]
  /**
   * 时干
   */
  timeGan: string
  /**
   * 时支
   */
  timeZhi: string
  /**
   * 纳音
   */
  voliceList: string[]
  /**
   * 年干
   */
  yearGan: string
  /**
   * 年支
   */
  yearZhi: string
  /**
   * 地支藏干List  数组0 1 2 3分别对应年 月 日 时 地支的藏干信息
   */
  zhiHiddenGanList: ZhiHiddenGanList[]
  /**
   * 地支合冲状态
   */
  zhiSyzygyStatus: string
  [property: string]: any
}

export interface TenGodStatusList {
  /**
   * 天干
   */
  gan?: string
  /**
   * 十神
   */
  god?: string
  [property: string]: any
}

export interface ZhiHiddenGanList {
  /**
   * 本气
   */
  height?: string
  /**
   * 本气对应十神
   */
  heightGodName?: string
  /**
   * 余气
   */
  low?: string
  /**
   * 余气对应十神
   */
  lowGodName?: string
  /**
   * 中气
   */
  middle?: string
  /**
   * 中气对应十神
   */
  middleGodName?: string
  [property: string]: any
}

/**
 * EightGodTimeVO
 */
export interface EightGodTimeVO {
  /**
   * 日干
   */
  dayGan: string
  /**
   * 日支
   */
  dayZhi: string
  /**
   * 天干合冲信息
   */
  ganSyzygyStatus: string
  /**
   * 性别
   */
  gender: string
  /**
   * 月干
   */
  monthGan: string
  /**
   * 月支
   */
  monthZhi: string
  /**
   * 天干十神信息
   */
  tenGodStatusList: TenGodStatusList[]
  /**
   * 十年大运
   */
  tenLuckyList: TenLuckyList[]

  /**
   * 流年
   */
  flowYearList: TenLuckyList[]

  /**
   * 流月
   */
  flowMonthList: TenLuckyList[]

  /**
   * 流日
   */
  flowDayList: TenLuckyList[]
  /**
   * 流年 - 日干
   */
  timeDayGan: string
  /**
   * 流年 - 日支
   */
  timeDayZhi: string
  /**
   * 时干
   */
  timeGan: string
  /**
   * 流年 - 大运
   */
  timeLuckyGan: string
  /**
   * 流年 - 大运
   */
  timeLuckyZhi: string
  /**
   * 流年 - 月干
   */
  timeMonthGan: string
  /**
   * 流年 - 月支
   */
  timeMonthZhi: string
  /**
   * 流年 - 年干
   */
  timeYearGan: string
  /**
   * 流年 - 年支
   */
  timeYearZhi: string
  /**
   * 时支
   */
  timeZhi: string
  /**
   * 年干
   */
  yearGan: string
  /**
   * 年支
   */
  yearZhi: string
  /**
   * 地支藏干List  数组0 1 2 3分别对应年 月 日 时 地支的藏干信息
   */
  zhiHiddenGanList: ZhiHiddenGanList[]
  /**
   * 地支合冲状态
   */
  zhiSyzygyStatus: string
  [property: string]: any
}

export interface TenLuckyList {
  /**
   * 结束年份
   */
  endYear?: number
  /**
   * 大运名称
   */
  name?: string
  /**
   * 开始年份
   */
  startYear?: number
  [property: string]: any
}
