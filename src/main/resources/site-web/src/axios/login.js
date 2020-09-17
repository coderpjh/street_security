import { fetch } from './axios'

export const listOrder = function () {
  return fetch('post', '/user/user/delete/1303583637324816386')
}

export const handlelogin = data => {
  let url = '/user/user/login?userName=' + data.userName + '&password=' + data.password
  return fetch('get', url, data)
}

export const register = data => {
  return fetch('post', '/user/user/add', data)
}
