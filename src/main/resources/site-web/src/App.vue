<template>
  <div id="app" style="height: 100%;">
    <router-view/>
  </div>
</template>

<script>
import { listOrder } from './axios/login.js'
export default {
  name: 'App',
  mounted () {
    listOrder().then(response => {
      console.log(response.data) // 成功的返回
    })
      .catch(error => console.log(error, 'error')) // 失败的返回
  }
}
</script>

<style>
</style>
