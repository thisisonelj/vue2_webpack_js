import { createApp } from 'vue';
import { createPinia } from 'pinia';

import App from './App.vue';
import router from './router';
import 'view-ui-plus/dist/styles/viewuiplus.css';
import ViewUIPlus from 'view-ui-plus';
import ElementPlus from 'element-plus';
//import './assets/main.css'
import 'element-plus/dist/index.css';
import zhCn from 'element-plus/es/locale/lang/zh-cn';
const app = createApp(App);

app.use(createPinia());
app.use(router);
app.use(ViewUIPlus);
app.use(ElementPlus, { size: '', zIndex: 3000 });
app.mount('#app');
