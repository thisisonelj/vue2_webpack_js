import { createRouter, createWebHistory } from 'vue-router';
import pageContainer from '@/views/index.vue';
import newTest from '@/views/new-test.vue';
import uploadInfo from '@/components/common/upload/index.vue';

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
    {
      path: '/upload',
      name: 'upload',
      component: uploadInfo,
    },
  ],
});

export default router;
