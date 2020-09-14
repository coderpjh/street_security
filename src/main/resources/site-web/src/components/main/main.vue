<template>
  <div class="layout">
          <Layout>
              <Header>
                  <Menu mode="horizontal" theme="dark" active-name="1">
                      <div class="layout-title"><span>街道办安全管理系统</span></div>
                      <div class="layout-nav">
                          <MenuItem name="1">
                              <Icon type="ios-navigate"></Icon>
                              顶部页签1
                          </MenuItem>
                          <MenuItem name="2">
                              <Icon type="ios-keypad"></Icon>
                              顶部页签2
                          </MenuItem>
                          <MenuItem name="3">
                              <Icon type="ios-analytics"></Icon>
                              顶部页签3
                          </MenuItem>
                          <MenuItem name="4" style="text-align: center;width: 100px;" >
                              <Dropdown>
                                      <a href="javascript:void(0)">
                                          <Avatar style="background-color: #87d068" icon="ios-person"/>
                                      </a>
                                      <DropdownMenu slot="list">
                                          <DropdownItem>修改信息</DropdownItem>
                                          <DropdownItem @click.native="logout">退出登录</DropdownItem>
                                      </DropdownMenu>
                                  </Dropdown>
                          </MenuItem>
                      </div>
                  </Menu>
              </Header>
              <Layout>
                  <Sider hide-trigger :style="{background: '#fff'}">
                      <Menu active-name="" theme="light" width="auto" :open-names="['1']">
                          <Submenu name="1">
                              <template slot="title">
                                  <Icon type="md-card" />
                                  任务栏
                              </template>
                              <MenuItem name="1-1" @click.native="$router.push({path:'employee'})">常规任务</MenuItem>
                              <MenuItem name="1-2">专项任务</MenuItem>
                              <MenuItem name="1-3">通用任务</MenuItem>
                              <MenuItem name="1-4">特性任务</MenuItem>
                          </Submenu>
                          <MenuItem name="2" @click.native="toExpert">
                                      <Icon type="ios-people" />
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
                      </Content>
                  </Layout>
              </Layout>
          </Layout>
      </div>
</template>

<script>
export default{
  name: 'main',
  data () {
    return {
      userChoice: false,
      nav: []
    }
  },
  watch: {
    $route () {
      this.nav = []
      let arr = this.$route.matched
      arr.forEach(item => {
        this.nav.push(item.meta.label)
      })
      console.log(this.nav)
    }
  },
  methods: {
    test () {
      alert('测试哈')
    },
    toExpert () {
      this.$router.push({path: '/Expert'})
    },
    logout () {
      this.$router.push({path: '/'})
    }
  },
  mounted () {
    console.log(this.$route)
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
