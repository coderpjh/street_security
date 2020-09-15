import { fetch } from './axios'
/* 专家库列表 */
export const getList = () => {
  return fetch('get', '/professor/professor/list')
}

/* 专家删除 */
export const deleteExpert = id => {
  return fetch('post', '/professor/professor/delete/' + id)
}

/* 专家更新 */
export const updateExpert = data => {
  return fetch('post', '/professor/professor/update', data)
}

/* 专家添加 */
export const increaseExpert = data => {
  return fetch('post', '/professor/professor/add', data)
}
