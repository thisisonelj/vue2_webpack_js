<template>
  <div> {{ webWorkerTitle }} </div>
  <el-button @click="testWorkerInfo" type="primary"></el-button>
</template>
<script lang="ts" setup>
  import { ref } from 'vue';
  const webWorkerTitle = ref<string>('这是测试webWorker页面');
  const testWorkerInfo = () => {
    const worker = new Worker('/src/views/webworker/worker.js');
    worker.addEventListener('message', (message) => {
      const { type, data } = message.data;
      console.log(`输入数为:${data.input}`);
      console.log(`最终计算结果:${data.result}`);
    });
    worker.postMessage({ type: 'CALCULATE_FIBONACCI', data: { number: 4 } });
  };
</script>
<style lang="sass" scoped></style>
