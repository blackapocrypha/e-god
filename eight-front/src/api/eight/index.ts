import request from '@/util/request'
import type {
  userInfo,
  userTimeInfo,
  EightGodVO,
  EightGodTimeVO,
  FullYearMonthDaysVO
} from '@/api/eight/type'
type FullVO = FullYearMonthDaysVO[]

// 统一管理接口
enum API {
  GET_EIGHT = '/getEight',
  GET_LUCKY = '/getLucky',
  GET_FULLDAYS = '/getFullYearMonthDays',
  CHAT = '/chat'
}

// 获取八字排盘信息
export const apiGetEight = (data: userInfo) =>
  request.get<EightGodVO>(API.GET_EIGHT + '?birth=' + data.birth + '&gender=' + data.gender)

// 获取八字大运排盘信息
export const apiGetLucky = (data: userTimeInfo) => {
  let url: string = API.GET_LUCKY + '?birth=' + data.birth + '&gender=' + data.gender
  if (data.lucky !== null) {
    url += '&lucky=' + data.lucky
  }
  if (data.year !== null) {
    url += '&year=' + data.year
  }
  if (data.month !== null) {
    url += '&month=' + data.month
  }
  if (data.day !== null) {
    url += '&day=' + data.day
  }

  return request.get<EightGodTimeVO>(url)
}

// 获取当前年份全部流月流日
export const getFullYearMonthDays = (data: number) =>
  request.get<FullVO>(API.GET_FULLDAYS + '?year=' + data)

/**
 * 打开 AI 对话流式连接（SSE）
 * @param data 与 getEight 一致的参数：birth、gender
 * @returns EventSource 实例，调用方负责监听 onmessage / onerror / onclose
 */
export const createChatStream = (data: userInfo): EventSource => {
  const url = `http://127.0.0.1:9369${API.CHAT}?birth=${encodeURIComponent(data.birth)}&gender=${data.gender}`
  return new EventSource(url)
}
