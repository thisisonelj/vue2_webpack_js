import { fileURLToPath, URL } from 'node:url';
import path from 'node:path';
import { defineConfig, loadEnv } from 'vite';
import vue from '@vitejs/plugin-vue';
import vueJsx from '@vitejs/plugin-vue-jsx';
import vueDevTools from 'vite-plugin-vue-devtools';

export default ({ command, mode }) => {
  console.log('环境变量 =>', command, mode);
  const env = loadEnv(mode, path.resolve(process.cwd(), 'env'));
  console.log(env);
  debugger;
  return defineConfig({
    envDir: './env', // 自定义env目录
    plugins: [vue(), vueJsx(), vueDevTools()],
    resolve: {
      alias: {
        '@': fileURLToPath(new URL('./src', import.meta.url)),
      },
    },
    define: {
      __VITE_APP_PROXY__: true || false,
    },
    server: {
      proxy: {
        // '/api': {
        //   target: 'http://localhost:9000/api', //目标域名
        //   changeOrigin: true, //需要代理跨域
        //   rewrite: (path) => path.replace(/^\/api/, ''), //路径重写，把'/api'替换为''
        // },
      },
    },
    publicDir: '/src',
  });
};
