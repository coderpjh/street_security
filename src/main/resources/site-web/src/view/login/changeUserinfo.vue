<template>
  <div class="userContent">
    <span class="label">&nbsp;用户名：</span><Input v-model="changeData.userName" readonly placeholder="请输入" style="width: 290px" />
    <span class="label">&nbsp;旧密码：</span><Input v-model="changeData.oldPwd" type='password' placeholder="请输入" style="width: 290px" />
    <span class="label">&nbsp;新密码：</span><Input v-model="changeData.newPwd" type='password' placeholder="请输入" style="width: 290px" />
    <span class="label">&nbsp;确认密码：</span><Input v-model="changeData.confirmPwd" type='password' placeholder="请输入" style="width: 290px" />
    </div>
</template>

<script>
export default{
  name: 'changeUserinfo',
  props: {
    changeData: {
      type: Object,
      default: function () {
        return {
          oldPwd: '',
          newPwd: '',
          confirmPwd: ''
        }
      }
    }
  }
}
</script>

<style lang="less">
  .userContent{
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
