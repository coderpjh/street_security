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
          path: '/Task',
          meta: {
            label: '任务列表'
          },
          component: () => import('@/view/Task/Task.vue')
        },
        {
          path: '/riskMonitor',
          meta: {
            label: '风险图表'
          },
          component: () => import('@/view/riskMonitor/riskMonitor.vue')
        },
        {
          path: '/riskMap',
          meta: {
            label: '风险地图'
          },
          component: () => import('@/view/riskMap/riskMap.vue')
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
