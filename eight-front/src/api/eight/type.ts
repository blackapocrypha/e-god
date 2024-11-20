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
   * 日干颜色
   */
  dayGanColor: string
  /**
   * 日支颜色
   */
  dayZhiColor: string
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
   * 空亡
   */
  fallList: Array<string[]>
  /**
   * 月干
   */
  monthGan: string
  /**
   * 月支
   */
  monthZhi: string
  /**
   * 月干-颜色
   */
  monthGanColor: string
  /**
   * 月支-颜色
   */
  monthZhiColor: string
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
   * 时干颜色
   */
  timeGanColor: string
  /**
   * 时支颜色
   */
  timeZhiColor: string
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
   * 年干颜色
   */
  yearGanColor: string
  /**
   * 年支颜色
   */
  yearZhiColor: string
  /**
   * 地支藏干List  数组0 1 2 3分别对应年 月 日 时 地支的藏干信息
   */
  zhiHiddenGanList: ZhiHiddenGanList[]
  /**
   * 地支合冲状态
   */
  zhiSyzygyStatus: string
  /**
   * 感情桃花位
   */
  loveInHome: string

  /**
   * 社会桃花位
   */
  loveInSociety: string

  /**
   * 文昌位
   */
  literature: string

  /**
   * 起运时间
   */
  fateStart: string

  /**
   * 袁天罡称骨
   */
  yuanTianGang: string
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
   * 日干颜色
   */
  dayGanColor: string
  /**
   * 日支颜色
   */
  dayZhiColor: string
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
   * 月干颜色
   */
  monthGanColor: string
  /**
   * 月支颜色
   */
  monthZhiColor: string
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
   * 流年 - 日干
   */
  timeDayGan: string
  /**
   * 流年 - 日干颜色
   */
  timeDayGanColor: string
  /**
   * 流年 - 日支
   */
  timeDayZhi: string
  /**
   * 流年 - 日支颜色
   */
  timeDayZhiColor: string
  /**
   * 时干
   */
  timeGan: string
  /**
   * 时干颜色
   */
  timeGanColor: string
  /**
   * 流年 - 大运干
   */
  timeLuckyGan: string
  /**
   * 流年 - 大运干颜色
   */
  timeLuckyGanColor: string
  /**
   * 流年 - 大运支
   */
  timeLuckyZhi: string
  /**
   * 流年 - 大运支颜色
   */
  timeLuckyZhiColor: string
  /**
   * 流年 - 月干
   */
  timeMonthGan: string
  /**
   * 流年 - 月干颜色
   */
  timeMonthGanColor: string
  /**
   * 流年 - 月支
   */
  timeMonthZhi: string
  /**
   * 流年 - 月支颜色
   */
  timeMonthZhiColor: string
  /**
   * 流年 - 年干
   */
  timeYearGan: string
  /**
   * 流年 - 年干颜色
   */
  timeYearGanColor: string
  /**
   * 流年 - 年支
   */
  timeYearZhi: string
  /**
   * 流年 - 年支颜色
   */
  timeYearZhiColor: string
  /**
   * 时支
   */
  timeZhi: string
  /**
   * 时支颜色
   */
  timeZhiColor: string
  /**
   * 年干
   */
  yearGan: string
  /**
   * 年干颜色
   */
  yearGanColor: string
  /**
   * 年支
   */
  yearZhi: string
  /**
   * 年支颜色
   */
  yearZhiColor: string
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

export interface TimeLuckyMonthDayVO {
  /**
   * 日
   */
  day?: number
  /**
   * 日干支
   */
  dayGanZhi?: string
  /**
   * 完整日期
   */
  date?: string
  [property: string]: any
}

export interface FullYearMonthDaysVO {
  /**
   * 年
   */
  year?: number

  /**
   * 月
   */
  month?: number

  /**
   * 月干支
   */
  monthGanZhi?: string

  /**
   * 流日
   */
  days?: TimeLuckyMonthDayVO[]
  [property: string]: any
}
