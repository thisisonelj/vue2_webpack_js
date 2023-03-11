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
      path: '/vuex/module',
      name: 'module',
      component: vuexDemo.module
    },
    {
      path: '/eventbus',
      name: 'eventBus',
      component: vuexDemo.eventBus
    },
    {
      path: '/alive',
      name: 'aliveModule',
      component: vuexDemo.aliveModule
    },
    {
      path: '/echarts',
      name: 'echartsTable',
      component: vuexDemo.echartsTable
    },
    {
      path: '/websockets',
      name: 'webSockets',
      component: vuexDemo.webSockets
    },
    {
      path: '/render',
      name: 'renderTree',
      component: vuexDemo.renderTree
    },
    {
      path: '/css3',
      name: 'css3Components',
      component: vuexDemo.css3Components
    },
    {
      path: '/transition',
      name: 'css3Transition',
      component: vuexDemo.css3Transition
    },
    {
      path: '/animation',
      name: 'css3Animation',
      component: vuexDemo.css3Animation
    },
    {
      path: '/flex',
      name: 'css3Flex',
      component: vuexDemo.css3Flex
    },
    {
      path: '/flexauto',
      name: 'css3FlexAuto',
      component: vuexDemo.css3FlexAuto
    },
    {
      path: '/flexlastrow',
      name: 'css3FlexLastRow',
      component: vuexDemo.css3FlexLastRow
    },
    {
      path: '/extend',
      name: 'extendComponent',
      component: vuexDemo.extendComponent
    },
    {
      path: '/carousel',
      name: 'carouselComponent',
      component: vuexDemo.carouselComponent
    },
    {
      path: '/debounce',
      name: 'debounceComponent',
      component: vuexDemo.debounceComponent
    },
    {
      path: '/browser',
      name: 'browserComponent',
      component: vuexDemo.browserComponent
    },
    {
      path: '/pulldown',
      name: 'pullDownRefresh',
      component: vuexDemo.pullDownRefresh
    }
  ]
})
