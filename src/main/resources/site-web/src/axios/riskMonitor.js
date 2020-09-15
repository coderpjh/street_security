import { fetch } from './axios'
/* 风险列表 */
export const getList = () => {
  return fetch('get', '/risk/risk/list')
}
