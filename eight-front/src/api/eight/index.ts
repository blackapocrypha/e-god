import request from '@/util/request'
import type { userInfo, EightGodVO } from '@/api/eight/type'
// 统一管理接口
enum API {
  GET_EIGHT = '/getEight'
}

// 获取八字排盘信息
export const apiGetEight = (data: userInfo) =>
  request.get<EightGodVO>(API.GET_EIGHT + '?birth=' + data.birth + '&gender=' + data.gender)
