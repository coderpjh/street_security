import { fetch } from './axios'
/* 任务列表 */
export const getList = type => {
  let url = '/task/task/list?type=' + type
  return fetch('get', url)
}

/* 任务删除 */
export const deleteTask = id => {
  return fetch('post', '/task/task/delete/' + id)
}

/* 任务更新 */
export const updateTask = data => {
  return fetch('post', '/task/task/update', data)
}

/* 任务添加 */
export const increaseTask = data => {
  return fetch('post', '/task/task/add', data)
}

/* 任务审核 */
export const auditTask = data => {
  return fetch('post', '/task/task/verify', data)
}
