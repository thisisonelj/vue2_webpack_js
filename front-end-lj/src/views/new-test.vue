<template>
  <div>{{ variableEnv }}</div>
  <div>{{ viteProxy.name }}</div>
</template>
<script setup lang="ts">
import { ref, onMounted } from 'vue'
const variableEnv = ref(0)
const viteProxy = ref<userInfo>({
  id: 'hasldhashdhklashld',
  name: 'lj',
})
onMounted(() => {
  variableEnv.value = import.meta.env.VITE_SERVER_PORT
  console.log(typeof __VITE_APP_PROXY__)
})
</script>
<style lang="scss" scoped></style>
