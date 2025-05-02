<template>
  <div class="container">
    {{ title }}
    <slot></slot>
  </div>
</template>
<script setup lang="ts">
import { ref } from 'vue'
const title = ref('这是主页容器')
</script>
<style lang="scss" scoped></style>
