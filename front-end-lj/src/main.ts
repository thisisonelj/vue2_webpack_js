import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import xeUtils from 'xe-utils'
const app = createApp(App)
app.config.globalProperties.$xeUtils = xeUtils
app.use(createPinia())
app.use(router)
app.use(ElementPlus)

app.mount('#app')
