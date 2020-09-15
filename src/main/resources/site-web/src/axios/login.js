import { fetch } from './axios'

export const listOrder = function () {
  return fetch('post', '/user/user/delete/1303583637324816386')
}

export const handlelogin = data => {
  return fetch('get', '/user/user/login', data)
}

export const register = data => {
  return fetch('post', '/user/user/add', data)
}


