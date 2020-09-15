import { fetch } from './axios'
/* 专家库列表 */
export const getList = () => {
  return fetch('get', '/professor/professor/list')
}

/* 专家删除 */
export const deleteExpert = id => {
  return fetch('post', '/professor/professor/delete/' + id)
}
