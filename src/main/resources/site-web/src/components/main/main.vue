<template>
  <div class="layout">
          <Layout>
              <Header>
                  <Menu mode="horizontal" theme="dark">
                      <div class="layout-title"><span>街道办安全管理系统</span></div>
                      <div class="layout-nav">
                          <MenuItem name="1" class='welcome'>
                              欢迎您 {{userName}}
                          </MenuItem>
                          <MenuItem name="4" style="text-align: left;width: 90px;" >
                              <Dropdown>
                                      <a href="javascript:void(0)">
                                          <Avatar style="background-color: #87d068" icon="ios-person"/>
                                      </a>
                                      <DropdownMenu slot="list">
                                          <DropdownItem @click.native="openInfo">修改信息</DropdownItem>
                                          <DropdownItem @click.native="toOther('/')">退出登录</DropdownItem>
                                      </DropdownMenu>
                                  </Dropdown>
                          </MenuItem>
                      </div>
                  </Menu>
              </Header>
              <Layout>
                  <Sider hide-trigger :style="{background: '#fff'}">
                      <Menu active-name="1" theme="light" width="auto" :open-names="[]">
                        <MenuItem name="1" @click.native="toOther('/homeMap')">
                                    <Icon type="md-home" />
                                    首页总览
                                </MenuItem>
                          <Submenu name="2">
                              <template slot="title">
                                  <Icon type="md-card" />
                                  任务栏
                              </template>
                              <MenuItem v-for="(item ,index) in TaskList" :key="index" :name="item.name" @click.native="transtoTask(item)">{{item.label}}</MenuItem>
                          </Submenu>
                          <Submenu name="3">
                              <template slot="title">
                                  <Icon type="ios-nuclear" />
                                  上报风险
                              </template>
                              <MenuItem name="3-1"  @click.native="reportRisk('综治办')">综治办</MenuItem>
                              <MenuItem name="3-2" @click.native="reportRisk('党政办')">党政办</MenuItem>
                              <MenuItem name="3-3" @click.native="reportRisk('党建办')">党建办</MenuItem>
                              <MenuItem name="3-4" @click.native="reportRisk('经发办')">经发办</MenuItem>
                          </Submenu>

                          <Submenu name="4">
                              <template slot="title">
                                  <Icon type="ios-person" />
                                  安全风险监管
                              </template>
                              <MenuItem name="4-1"  @click.native="toOther('/riskMonitor')">风险列表</MenuItem>
                              <MenuItem name="4-2"  @click.native="toOther('/riskMap')">风险地图</MenuItem>
                          </Submenu>
                          <MenuItem name="5">
                                      <Icon type="ios-people" />
                                      部门监管
                                  </MenuItem>
                          <MenuItem name="6" @click.native="toOther('/Expert')">
                                              <Icon type="ios-school" />
                                              专家库
                                          </MenuItem>
                      </Menu>
                  </Sider>
                  <Layout :style="{padding: '0 24px 24px'}">
                      <Breadcrumb :style="{margin: '24px 0'}">
                          <BreadcrumbItem v-for="(item ,index) in nav" :key="index">{{item}}</BreadcrumbItem>
                      </Breadcrumb>
                      <Content :style="{padding: '24px', minHeight: '280px', background: '#fff'}">
                          <router-view/>
                          <Modal
                                  v-model="userModal"
                                  title="用户信息修改"
                                  :closable="false"
                                  :width="416"
                                  :footer-hide='true'
                                  :transfer="false"
                                  class-name="userChange">
                                  <change-userinfo :changeData="changeData"></change-userinfo>
                                  <div class="userfooter">
                                    <div class="cancel" @click="closeInfo">取消</div>
                                    <Button type='info'@click.native="changeUserinfo">修改</Button>
                                  </div>
                              </Modal>
                      </Content>
                  </Layout>
              </Layout>
          </Layout>
      </div>
</template>

<script>
import viewRisk from '../../view/riskMonitor/viewRisk.vue'
import changeUserinfo from '../../view/login/changeUserinfo.vue'

import {addRisk} from '../../axios/riskMonitor.js'
import {changeUser} from '../../axios/user.js'

export default{
  name: 'main',
  components: {
    changeUserinfo,
    viewRisk
  },
  data () {
    return {
      userChoice: false,
      nav: [],
      formData: null,
      changeData: {},
      userModal: false,
      TaskList: [
        {
          label: '常规任务',
          name: '2-1',
          type: '1'
        },
        {
          label: '专项任务',
          name: '2-2',
          type: '2'
        },
        {
          label: '通用任务',
          name: '2-3',
          type: '3'
        },
        {
          label: '特性任务',
          name: '2-4',
          type: '4'
        }
      ]
    }
  },
  watch: {
    $route () {
      this.nav = []
      let arr = this.$route.matched
      arr.forEach(item => {
        this.nav.push(item.meta.label)
      })
    }
  },
  methods: {
    closeInfo () {
      this.userModal = false
    },
    toOther (path) {
      this.$router.push({path: path})
    },
    reportRisk (depart) {
      this.formData = {}
      this.formData['reportDepartment'] = depart
      this.$Modal.confirm({
        render: (h) => {
          return h(viewRisk, {
            props: {
              title: depart + '风险上报',
              formData: this.formData
            },
            on: {
              input: (val) => {
              }
            }
          })
        },
        onOk: () => {
          console.log(this.formData)
          addRisk(this.formData).then(res => {
            this.$Message.success({
              content: '添加成功'
            })
          })
        }
      })
    },
    transtoTask (item) {
      if (this.$route.path !== '/Task') {
        this.$router.push({path: '/Task', meta: {label: item.label}, query: {type: item.type, label: item.label}})
      } else if (this.$route.query.type !== item.type) {
        this.$router.push({path: '/Task', meta: {label: item.label}, query: {type: item.type, label: item.label}})
      }
    },
    openInfo () {
      this.changeData = {}
      this.changeData['userName'] = sessionStorage.getItem('userName')
      this.userModal = true
    },
    changeUserinfo () {
      console.log(this.changeData)
      if (!this.changeData.oldPwd || !this.changeData.newPwd || !this.changeData.confirmPwd) {
        this.$Message.error('请输入完整信息！')
        return
      }
      if (this.changeData.newPwd !== this.changeData.confirmPwd) {
        this.$Message.error('两次密码输入不一致！')
        return
      }
      changeUser(this.changeData).then(res => {
        console.log(res)
        this.$Message.success({
          content: '修改成功'
        })
        this.userModal = false
      })
    }
  },
  computed: {
    userName () {
      return sessionStorage.getItem('userName')
    }
  },
  mounted () {
    this.nav = []
    let arr = this.$route.matched
    arr.forEach(item => {
      this.nav.push(item.meta.label)
    })
  }
}
</script>

<style lang="less">
  @import "./main.less";
</style>
