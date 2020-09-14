<template>
  <div id='container' style="width: 100%;height: 100%;"></div>
</template>

<script>
export default{
  name: 'homeMap',
  data () {
    return {

    }
  },
  methods: {
    init () {
      let map = new AMap.Map('container', {
        zoom: 17, // 级别
        center: [104.14573, 30.673878], // 中心点坐标
        // resizeEnable: true
        pitch: 60, // 地图俯仰角度，有效范围 0 度- 83 度
        viewMode: '3D', // 地图模式
        mapStyle: 'amap://styles/normal'
      })
      AMap.plugin([
        'AMap.ControlBar'
      ], function () {
        // 添加 3D 罗盘控制
        map.addControl(new AMap.ControlBar({
          showZoomBar: false,
          showControlButton: true
        }))
      })
    }
  },
  mounted () {
    this.init()
  }
}
</script>

<style>
</style>
