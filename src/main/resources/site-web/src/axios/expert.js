import { fetch } from './axios'

export const getList = () => {
  return fetch('get', '/professor/professor/list')
}
