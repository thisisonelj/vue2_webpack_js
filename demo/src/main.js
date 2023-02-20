import Vue from 'vue'
import App from './App'
import VueRouter from 'vue-router'
// import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import http from './cross-access'
import XeUtils from 'xe-utils'
import router from './router/router-demo.js'
Vue.config.productionTip = false
const debugmode = process.env.NODE_ENV !== 'production' // 是否为开发环境
Vue.config.debug = debugmode
Vue.config.devtools = debugmode // 开启Vue调试（使用调试工具必须开启）
Vue.config.productionTip = debugmode
Vue.use(ElementUI)
Vue.use(router)
const { isNavigationFailure, NavigationFailureType } = VueRouter
Vue.prototype.$isNavigationFailure = isNavigationFailure
Vue.prototype.$NavigationFailureType = NavigationFailureType
Vue.prototype.$http = http
Vue.prototype.$XeUtils = XeUtils
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {App},
  template: '<App/>'
})
