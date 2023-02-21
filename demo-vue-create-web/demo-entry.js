import Vue from 'vue'
import App from './src/App.vue'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import http from './src/utils/cross-access'
import XeUtils from 'xe-utils'
import ViewUI from 'view-design'
import locale from 'view-design/dist/locale/en-US'
import 'view-design/dist/styles/iview.css'
import Sortable from 'sortablejs'
import vuex from './vuex/vuex'
import vuexModule from './vuex/vuex-module'
Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.use(router)
Vue.use(ViewUI, { locale })
Vue.use(vuex)
Vue.use(vuexModule)
Vue.prototype.$http = http
Vue.prototype.$XeUtils = XeUtils
Vue.prototype.$Sortable = Sortable
/* eslint-disable no-new */
new Vue({
  el: '#app', router, store: vuexModule, render: h => h(App)
})
