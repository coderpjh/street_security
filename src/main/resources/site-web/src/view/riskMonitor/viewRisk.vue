<template>
  <div class="viewContent">
    <div class="title">{{title}}</div>
    <span class="label">&nbsp;风险名称：</span><Input v-model="formData.riskName" placeholder="请输入" style="width: 290px" />
    <span class="label">&nbsp;所属区域：</span><Input v-model="formData.riskScope" placeholder="请输入" style="width: 290px" />
    <span class="label">&nbsp;风险等级：</span><RadioGroup v-model="formData.riskLevel" style="width: 270px;height: 30px;">
        <Radio :label="1">轻微</Radio>
        <Radio :label="2">一般</Radio>
        <Radio :label="3">较重</Radio>
        <Radio :label="4">严重</Radio>
    </RadioGroup>
    <!-- <Input v-model="formData.riskLevel" placeholder="请输入" style="width: 290px" /> -->
    <span class="label">&nbsp;风险类型：</span><Input v-model="formData.riskType" placeholder="请输入" style="width: 290px" />
    <span class="label">&nbsp;上报部门：</span><Input v-model="formData.reportDepartment" placeholder="请输入" style="width: 290px" />
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
    title: {
      type: String,
      default: ''
    },
    formData: {
      type: Object,
      default: () => {}
    }
  },
  data () {
    return {
    }
  },
  mounted () {
  },
  methods: {
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
