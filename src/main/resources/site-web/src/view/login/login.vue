<template>
  <div class="loginFrame">
      <div class="systemName">街道办安全管理系统</div>
    <div class="formContainer">
      <div class="loginChoice">
        <span v-for="(item,index) in loginType" :key='index' @click="changeTab(item)" :class="{'active':item.active}">{{item.label}}</span>
      </div>
         <Form ref="formLogin" class="loginForm" v-show="isLogin" :model="loginData" :rules="loginRules">
                <FormItem prop="userName">
                    <Input type="text" placeholder="请输入用户名" v-model="loginData.userName">
                        <Icon type="ios-person-outline" slot="prepend"></Icon>
                    </Input>
                </FormItem>
                <FormItem prop="password" style="margin-top: 25px;">
                    <Input type="password" placeholder="请输入密码" v-model="loginData.password">
                        <Icon type="ios-lock-outline" slot="prepend"></Icon>
                    </Input>
                </FormItem>
                <FormItem prop="level" style="margin-top: 25px;">
                    <Select  prefix="ios-home" placeholder="请选择权限等级" v-model="loginData.level">
                            <Option value="1">街办监督科室</Option>
                            <Option value="2">科室监督社区</Option>
                            <Option value="3">社区监督企业</Option>
                            <Option value="4">个体经营户</Option>
                        </Select>
                </FormItem>
                <div class="pswChoice">
                  <Checkbox>记住密码</Checkbox>
                  <span class="forgetPsw">忘记密码</span>
                </div>
                <FormItem  style="margin-top: 20px;">
                    <Button type="primary" @click="handleSubmit('formLogin')">登录</Button>
                </FormItem>
            </Form>
            <Form ref="formRegister" class="loginForm" v-show="!isLogin" :model="registerData" :rules="registerRules">
                   <FormItem prop="userName">
                       <Input type="text" placeholder="注册用户名" v-model="registerData.userName">
                           <Icon type="ios-person-outline" slot="prepend"></Icon>
                       </Input>
                   </FormItem>
                   <FormItem prop="password">
                       <Input type="password" placeholder="请输入密码" v-model="registerData.password">
                           <Icon type="ios-lock-outline" slot="prepend"></Icon>
                       </Input>
                   </FormItem>
                   <FormItem prop="confirmPsw">
                       <Input type="password" placeholder="请再次输入密码" v-model="registerData.confirmPsw">
                           <Icon type="ios-lock-outline" slot="prepend"></Icon>
                       </Input>
                   </FormItem>
                   <FormItem prop="telephone">
                       <Input type="tel" placeholder="请输入联系电话" v-model="registerData.telephone">
                           <Icon type="ios-call-outline" slot="prepend"></Icon>
                       </Input>
                   </FormItem>
                   <FormItem prop="level">
                       <Select  prefix="ios-home" placeholder="请选择权限等级" v-model="registerData.level">
                               <Option value="1">街办监督科室</Option>
                               <Option value="2">科室监督社区</Option>
                               <Option value="3">社区监督企业</Option>
                               <Option value="4">个体经营户</Option>
                           </Select>
                   </FormItem>
                   <FormItem style="margin-bottom: 25px;margin-top: 20px;">
                       <Button type="primary" @click="handleSubmit('formRegister')">注册</Button>
                   </FormItem>
               </Form>
    </div>
  </div>
</template>

<script>
import { handlelogin, register, listOrder, check} from '../../axios/login.js'
export default {
  components: {
  },
  data () {
    return {
      isLogin: true,
      loginType: [
        {
          label: '用户登录',
          active: true
        },
        {
          label: '用户注册',
          active: false
        }
      ],
      loginData: {},
      registerData: {},
      loginRules: {
        userName: [{ required: true, message: '用户名不能为空', trigger: 'blur' }],
        password: [{ required: true, message: '密码不能为空', trigger: 'blur' }],
        level: [{ required: true, message: '权限等级不能为空', trigger: 'change' }]
      },
      registerRules: {
        userName: [{ required: true, message: '用户名不能为空', trigger: 'blur' }],
        password: [{ required: true, message: '密码不能为空', trigger: 'blur' }],
        level: [{ required: true, message: '权限等级不能为空', trigger: 'change' }],
        confirmPsw: [{ required: true, message: '请再次输入密码', trigger: 'blur' }],
        telephone: [{ required: true, message: '联系电话不能为空', trigger: 'blur' }]
      }
    }
  },
  methods: {
    changeTab (item) {
      this.loginType[0].active = false
      this.loginType[1].active = false
      item.active = true
      if (item.label === '用户登录') {
        this.isLogin = true
      } else this.isLogin = false
    },
    handleSubmit (name) {
      check().then(res => {
        console.log(res)
      })
      // handlelogin().then(res => {
      //   console.log(res)
      // })
      this.$refs[name].validate((valid) => {
        if (valid) {
          this.$Message.success('Success!')
          if (name === 'formLogin') {
            this.$router.push({path: '/home'})
          } else if (name === 'formRegister') {
            if (this.registerData.password !== this.registerData.confirmPsw) {
              this.$Message.error('两次密码输入不一致！')
              return
            }

            register(this.registerData).then(() => {
              alert('注册成功')
            })
            console.log(this.registerData)
          }
        } else {
          this.$Message.error('Fail!')
        }
      })
    }
  },
  mounted () {
  }
}
</script>

<style lang="less">
@import "./login.less";
</style>
