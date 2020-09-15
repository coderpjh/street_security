import Vue from 'vue'
import Router from 'vue-router'

import main from '@/components/main/main.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'login',
      component: () => import('@/view/login/login.vue')
    },
    {
      path: '/home',
      component: main,
      meta: {
        label: '首页'
      },
      redirect: '/homeMap',
      children: [
        {
          path: '/homeMap',
          meta: {
            label: '首页地图'
          },
          component: () => import('@/view/homeMap/homeMap.vue')
        },
        {
          path: '/employee',
          meta: {
            label: '增加人员'
          },
          component: () => import('@/view/employee/employee.vue')
        },
        {
          path: '/riskMonitor',
          meta: {
            label: '风险图表'
          },
          component: () => import('@/view/riskMonitor/riskMonitor.vue')
        },
        {
          path: '/Expert',
          meta: {
            label: '专家库列表'
          },
          component: () => import('@/view/Expert/Expert.vue')
        }
      ]
    }
  ]
})
