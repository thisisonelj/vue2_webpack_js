import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import demoTrain from '@/views/demotrain'
import MainDemo from '@/components/main'
Vue.use(Router)
export default new Router({
  routes: [
    {
      path: '/',
      name: 'MainDemo',
      component: MainDemo
    },
    {
      path: '/HelloWorld',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/demotrain',
      name: 'demotrain',
      component: demoTrain
    }
  ]
})
