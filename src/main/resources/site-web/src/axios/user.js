import { fetch } from './axios'
/* 任务列表 */
export const changeUser = data => {
  return fetch('post', '/user/user/update', data)
}
