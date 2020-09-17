<template>
  <div class="viewContent">
    <div class="title">专家个人信息</div>
    <span class="label">&nbsp;&nbsp;&nbsp;姓&nbsp;名：</span><Input v-model="formData.professorName" placeholder="请输入" style="width: 300px" />
    <span class="label">&nbsp;&nbsp;&nbsp;性&nbsp;别：</span><RadioGroup v-model="formData.gender" style="width: 300px">
        <Radio :label="1">男</Radio>
        <Radio :label="0">女</Radio>
    </RadioGroup>
    <span class="label">出生日期：</span> <DatePicker v-model="formData.data" type="date" placeholder="选择出生日期" style="width: 300px"></DatePicker>
    <span class="label">家庭住址：</span><Input v-model="formData.address" placeholder="请输入" style="width: 300px" />
    <span class="label">联系方式：</span><Input v-model="formData.telephone" placeholder="请输入" style="width: 300px" />
    <span class="label">所属领域：</span><Input v-model="formData.field" placeholder="请输入" style="width: 300px" />
    <span class="label">所属专业：</span><Input v-model="formData.professional" placeholder="请输入" style="width: 300px" />
    <span class="label">相关经验：</span><Input v-model="formData.relatedExperience" placeholder="请输入" style="width: 300px" />
    <span class="label">资质政府：</span><Input v-model="formData.qualificationGovernment" placeholder="请输入" style="width: 300px" />
    <span class="label">所获奖项：</span><Input v-model="formData.awards" placeholder="请输入" style="width: 300px" />
    </div>
</template>

<script>
export default {
  name: 'viewExpert',
  props: {
    formData: {
      type: Object,
      default: () => {}
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
      width: 70px;
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
