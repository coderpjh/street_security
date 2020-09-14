import axios from 'axios'

const axiosInstance = axios.create({
  headers: {'Content-Type': 'application/json'},
  baseURL: '/api',
  timeout: 50000
})

export function fetch (method, url, data) {
  console.log(method, url, data)
  return new Promise((resolve, reject) => {
    axiosInstance({
      method,
      url,
      data
    }).then(res => {
      resolve(res)
    }).catch(err => {
      reject(err)
    })
  })
}
