import Router from 'vue-router'
import Vue from 'vue'
import Foo from '../views/router-demo/componentes/foo.vue'
import Bar from '../views/router-demo/componentes/bar.vue'
import routerMain from '../views/router-demo/index'
import SubRouter from '../views/router-demo/componentes/subrouter.vue'
import SubRouterOne from '../views/router-demo/componentes/subrouter-one.vue'
import SubRouterTwo from '../views/router-demo/componentes/subrouter-two.vue'
import RouterPush from '../views/router-demo/componentes/router-push.vue'
import RouterView from '../views/router-demo/componentes/router-view.vue'
import RouterViewOne from '../views/router-demo/componentes/router-view-one.vue'
import RouterViewTwo from '../views/router-demo/componentes/router-view-two.vue'
import RouterRedirect from '../views/router-demo/componentes/router-redirect.vue'
import RouterParam from '../views/router-demo/componentes/router-params.vue'
import RouterMeta from '../views/router-demo/componentes/router-meta.vue'
import RouterTransition from '../views/router-demo/componentes/router-transition.vue'
import asyncModule from './example-utils'
import RouterFailure from '../views/router-demo/componentes/router-failure.vue'
Vue.use(Router)
const { isNavigationFailure, NavigationFailureType } = Router
Vue.prototype.$isNavigationFailure = isNavigationFailure
Vue.prototype.$NavigationFailureType = NavigationFailureType
const router = new Router({
  routes: [
    {
      path: '/',
      name: 'routerMain',
      component: routerMain // 基本的路由跳转
    },
    {
      path: '/foo/:id',
      name: 'Foo',
      component: Foo // 路由参数跳转
    },
    {
      path: '/bar/:id',
      name: 'Bar',
      component: Bar
    },
    {
      path: '/subrouter', // 嵌套路由
      name: 'SubRouter',
      component: SubRouter,
      children: [
        {
          path: 'one',
          component: SubRouterOne
        },
        {
          path: 'two',
          component: SubRouterTwo
        }
      ]
    },
    {
      path: '/routerpush', // 路由导航push
      name: 'RouterPush',
      component: RouterPush
    },
    {
      path: '/routerview', // 路由视图支持多个router-view
      name: 'RouterView',
      component: RouterView,
      children: [
        {
          path: '/',
          components: {
            default: RouterView,
            one: RouterViewOne,
            two: RouterViewTwo
          }
        }
      ]
    },
    {
      path: '/redirect', // 路由匹配重定向
      name: 'redirect',
      redirect: '/foo/redirect'
    },
    {
      path: '/routerparam', // 路由组件传参和组件内守卫
      name: 'RouterParam',
      component: RouterParam,
      props: { default: true, info: 'liu' }
    },
    {
      path: '/meta', // 路由元信息meta
      name: 'routerMeta',
      component: RouterMeta,
      meta: { requiresAuth: true }
    },
    {
      path: '/transition', // 路由过渡实现
      name: 'transition',
      component: RouterTransition
    },
    {
      path: '/failure', // 路由导航故障
      name: 'failure',
      component: RouterFailure
    },
    {
      path: '/asyncmodule', // 路由懒加载异步组件webpack代码分离路由组件为单一chunk
      name: 'asyncmodule',
      component: asyncModule
    },
    {
      path: '*', // 任意路由匹配404匹配
      name: 'root',
      component: routerMain
    }
  ],
  scrollBehavior (to, from, savedPosition) {
    return { x: 100, y: 100 }
  }// 设置滚动行为
})
console.log(asyncModule)
// 路由获取数据俩种方式:
// 1.在路由导航完成后获取即在组件内获取比如created()方法
// 2.在路由导航完成前获取即在路由组件内的导航守卫方法中获取
// 全局守卫
router.beforeEach((to, from, next) => {
  next()
  console.log(to.matched)
})
router.beforeResolve((to, from, next) => {
  next()
  // console.log(to)
})
router.afterEach((to, from) => {
  // console.log(to)
})
export default router
