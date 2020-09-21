<template>
  <div class="viewContent">
    <div class="title">任务信息</div>
    <span class="label">任务名称：</span><Input v-model="formData.taskName" placeholder="请输入" style="width: 300px" />
    <span class="label">任务类型：</span><RadioGroup v-model="formData.taskType" style="width: 300px;height: 30px;">
        <Radio :label="1">常规任务</Radio>
        <Radio :label="2">专项任务</Radio>
        <Radio :label="3">通用任务</Radio>
        <Radio :label="4">特性任务</Radio>
    </RadioGroup>
    <!-- <Input v-model="formData.taskType" placeholder="请输入" style="width: 300px" /> -->
    <span class="label">所属部门：</span><Input v-model="formData.taskDepartment" placeholder="请输入" style="width: 300px" />
    <span class="label">任务周期：</span><Input v-model="formData.taskDate" placeholder="请输入" style="width: 300px" />
    <span class="label">紧急程度：</span><RadioGroup v-model="formData.taskUrgencyLevel" style="width: 300px;height: 30px;">
        <Radio :label="1">紧急</Radio>
        <Radio :label="2">正常</Radio>
        <Radio :label="3">可搁置</Radio>
    </RadioGroup>
    <!-- <Input v-model="formData.taskUrgencyLevel" placeholder="请输入" style="width: 300px" /> -->
    <span class="label">负责人：</span><Input v-model="formData.taskResponsible" placeholder="请输入" style="width: 300px" />
    <span class="label">任务描述：</span><Input v-model="formData.taskDescription" placeholder="请输入" style="width: 300px" />
   <!-- <span class="label">相关经验：</span><Input v-model="formData.relatedExperience" placeholder="请输入" style="width: 300px" />
    <span class="label">资质政府：</span><Input v-model="formData.qualificationGovernment" placeholder="请输入" style="width: 300px" />
    <span class="label">所获奖项：</span><Input v-model="formData.awards" placeholder="请输入" style="width: 300px" /> -->
    </div>
</template>

<script>
export default {
  name: 'viewTask',
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
    .ivu-radio-wrapper{
      margin-top: 7px;
      margin-right: 0;
    }
  }
</style>
