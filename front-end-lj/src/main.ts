import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import store from '@/stores/index'
import { setGlobalDirectives } from '@/directives/index'
import { setupI18n } from '@/plugins/locale/index'
const app = createApp(App)
//注册全局store
app.use(store)
app.use(router)
app.use(ElementPlus)
//注册全局自定义指令
setGlobalDirectives(app)
//注册插件i18n国际化
setupI18n(app)
app.mount('#app')
