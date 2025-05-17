import { createRouter, createWebHistory } from 'vue-router'
import pageContainer from '@/views/index.vue'
import newTest from '@/views/new-test.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'pageContainer',
      component: pageContainer,
    },
    {
      path: '/env',
      name: 'testEnv',
      component: newTest,
    },
  ],
})

export default router
