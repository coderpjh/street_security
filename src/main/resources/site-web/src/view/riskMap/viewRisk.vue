<template>
  <div class="viewContent">
    <div class="title">{{formData.riskName}}</div><span class="label">&nbsp;风险名称：</span><Input v-model="formData.riskName" placeholder="请输入" style="width: 290px" />
    <span class="label">&nbsp;所属区域：</span><Input v-model="formData.riskScope" placeholder="请输入" style="width: 290px" />
    <span class="label">&nbsp;风险等级：</span><Input v-model="formData.riskLevel" placeholder="请输入" style="width: 290px" />
    <span class="label">&nbsp;风险类型：</span><Input v-model="formData.riskType" placeholder="请输入" style="width: 290px" />
    <span class="label">&nbsp;&nbsp;&nbsp;&nbsp;经&nbsp;度：</span><Input v-model="formData.longitude" placeholder="请输入" style="width: 290px" />
    <span class="label">&nbsp;&nbsp;&nbsp;&nbsp;纬&nbsp;度：</span><Input v-model="formData.latitude" placeholder="请输入" style="width: 290px" />
    <span class="label">风险上报人：</span><Input v-model="formData.reportName" placeholder="请输入" style="width: 290px" />
    <span class="label">风险负责人：</span><Input v-model="formData.responsibleName" placeholder="请输入" style="width: 290px" />
    <span class="label">&nbsp;风险描述：</span><Input v-model="formData.riskDescription" placeholder="请输入" style="width: 290px" />
    </div>
</template>

<script>
export default {
  name: 'viewExpert',
  props: {
    formData: {
      type: Object,
      default: function () {
        return {
          riskName: null,
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
    }
  }
}
</script>

<style lang="less">
  .viewContent{
    .title{
      font-size: 24px;
      text-align: center;
      font-weight: bold;
      margin-bottom: 15px;
    }
    .label{
      display: inline-block;
      width: 85px;
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
