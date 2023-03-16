import { createRouter, createWebHistory } from 'vue-router'
import demoComponent from '../components/demo-components/demo-component.vue';
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/index',
      name: 'demoComponent',
      component: demoComponent
    },
  ]
})

export default router
