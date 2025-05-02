import { createRouter, createWebHistory } from 'vue-router'
import pageContainer from '@/views/index.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'pageContainer',
      component: pageContainer,
    },
  ],
})

export default router
