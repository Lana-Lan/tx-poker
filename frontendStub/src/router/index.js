import Vue from 'vue'
import Router from 'vue-router'
import txpoker from '@/components/txpoker'
import login from '@/components/login'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: login
    },
    {
      path: '/txpoker',
      name: 'txpoker',
      component: txpoker
    }
  ]
})
