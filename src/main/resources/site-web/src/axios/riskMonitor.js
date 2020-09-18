import { fetch } from './axios'
/* 风险列表 */
export const getList = () => {
  return fetch('get', '/risk/risk/list')
}

/* 风险删除 */
export const deleteRisk = id => {
  return fetch('post', '/risk/risk/delete/' + id)
}

/* 风险更新 */
export const updateRisk = data => {
  return fetch('post', '/risk/risk/update', data)
}

/* 风险添加 */
export const addRisk = data => {
  return fetch('post', '/risk/risk/add', data)
}
