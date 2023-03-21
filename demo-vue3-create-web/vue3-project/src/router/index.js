import { createRouter, createWebHistory } from 'vue-router'
import demoComponent from '../components/demo-components/demo-component.vue';
import demoHome from '@views/demo-exe';
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/index',
      name: 'demoComponent',
      component: demoComponent
    },
    {
      path: '/',
      name: 'Home',
      component: demoHome
    },
  ]
})

export default router
