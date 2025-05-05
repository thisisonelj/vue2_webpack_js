import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import { setGlobalDirectives } from '@/directives/index'
const app = createApp(App)
app.use(createPinia())
app.use(router)
app.use(ElementPlus)
//注册全局自定义指令
setGlobalDirectives(app)
app.mount('#app')
