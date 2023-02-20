import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import displayPage from '@/components/display-page'
import vuexDemo from './router-utils'// 练习vuex相关的组件
Vue.use(Router)
export default new Router({
  routes: [
    {
      path: '/HelloWorld',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/',
      name: 'displayPage',
      component: displayPage
    },
    {
      path: '/vuex/index',
      name: 'index',
      component: vuexDemo.Index
    },
    {
      path: '/vuex/parent',
      name: 'parent',
      component: vuexDemo.Parent
    },
    {
      path: '/vuex/parent/son',
      name: 'son',
      component: vuexDemo.Son
    },
    {
      path: '/vuex/brother',
      name: 'brother',
      component: vuexDemo.parentBrother
    },
    {
      path: '/vuex/brother/son',
      name: 'brotherson',
      component: vuexDemo.brotherSon
    },
    {
      path: '/vuex/grand/son',
      name: 'grandson',
      component: vuexDemo.grandSon
    }
  ]
})
