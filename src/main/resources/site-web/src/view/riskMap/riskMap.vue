<template>
  <div id="map">
 <Modal v-model="modal" :title="showData.riskName"
                        :closable='false'
                        :footerHide="true"
                        width="400px"
                        class='tipModal'
                        :mask="false">
        <span class="label" @click="this.modal=false">&nbsp;所属区域：</span><p style="width: 275px">{{showData.riskScope}}</p><br />
        <span class="label">&nbsp;风险等级：</span><p style="width: 275px">{{showData.riskLevel}}</p><br />
        <span class="label">&nbsp;风险类型：</span><p v-model="showData.riskType" style="width: 275px">{{showData.riskType}}</p><br />
        <span class="label">&nbsp;&nbsp;&nbsp;&nbsp;经&nbsp;度：&nbsp;&nbsp;&nbsp;</span><p style="width: 275px">{{showData.longitude}}</p><br />
        <span class="label">&nbsp;&nbsp;&nbsp;&nbsp;纬&nbsp;度：&nbsp;&nbsp;&nbsp;</span><p style="width: 275px">{{showData.latitude}}</p><br />
        <span class="label">风险上报人：</span><p style="width: 275px">{{showData.reportName}}</p><br />
        <span class="label">风险负责人：</span><p style="width: 275px">{{showData.responsibleName}}</p><br />
        <span class="label">&nbsp;风险描述：</span><p style="width: 275px">{{showData.riskDescription}}</p><br />
    </Modal>
  </div>
</template>

<script>
import viewRisk from './viewRisk.vue'

import {getList, updateRisk, deleteRisk} from '../../axios/riskMonitor.js'

export default{
  name: 'riskMap',
  components: {
    viewRisk
  },
  data () {
    return {
      map: null,
      infoWindow: null,
      mes: '',
      formData: null,
      modal: false,
      showData: {
        riskName: '风险点暂无数据',
        riskScope: null,
        riskLevel: null,
        riskType: null,
        longitude: null,
        latitude: null,
        reportName: null,
        responsibleName: null,
        riskDescription: null
      }
    }
  },
  methods: {
    addmarker () {
      getList().then(res => {
        console.log(res)
        let data = res.data.data
        data.forEach(item => {
          let lon = item.longitude
          let lat = item.latitude
          if (lon && lat) {
            let marker = new AMap.Marker({
              position: [lon, lat],
              content: "<div class='markerClass'></div>", // 自定义覆盖物
              offset: new AMap.Pixel(-105, -115),
              extData: item
            })

            marker.on('mouseover', this.infoOpen)
            marker.on('mouseout', this.infoClose)

            this.map.add(marker)
          }
        })
      })
    },
    infoClose (e) {
      this.modal = false
    },
    infoOpen (e) {
      this.showData = e.target.Ce.extData
      console.log(e.target)
      this.modal = true
      // this.$Modal.info({
      //   render: (h) => {
      //     return h(viewRisk, {
      //       props: {
      //       },
      //       on: {
      //         input: (val) => {
      //         }
      //       }
      //     })
      //   },
      //   onOk: () => {
      // updateRisk(this.formData).then(res => {
      //   this.$Message.success({
      //     content: '更新成功'
      //   })
      //   this.getData()
      // })
      //   },
      //   mask: false
      // })
      // this.infoWindow.setContent(e.target.content)
      // this.infoWindow.open(this.map, e.target.getPosition())
    }
  },
  mounted () {
    this.map = new AMap.Map('map', {
      zoom: 16, // 级别
      center: [104.148318, 30.676421] // 中心点坐标
    })
    this.addmarker()
  }
}
</script>

<style lang="less">
  @import "./riskMap.less";
  .tipModal{
    .ivu-modal-header{
      padding: 10px 12px;
    }
    .ivu-modal-header-inner{
      height: 30px;
      font-size: 20px;
      text-align: center;
      font-weight: bold;
      line-height: 30px;
      // margin-bottom: 5px;
      }

    p{
      display: inline-block;
      text-align: center;
      height: 32px;
      line-height: 32px;
      vertical-align: top;
      // font-size: 16px;
      border-bottom: 1px solid #dcdee2;
      }
    .label{
      display: inline-block;
      height: 32px;
      line-height: 32px;
      width: 75px;
    }
    .ivu-input-wrapper{
      margin-bottom: 5px;
    }
    .ivu-radio-group{
      margin-bottom: 5px;
    }
    .ivu-date-picker-rel {
        left: -5px;
    }
  }
</style>
