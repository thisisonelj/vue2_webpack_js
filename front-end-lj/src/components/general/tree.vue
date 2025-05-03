<template>
  <div class="tree-container">{{ content }}</div>
</template>
<script setup lang="ts">
import { ref } from 'vue'
let content = ref('树形区域')
</script>
<style lang="scss" scoped>
.tree-container {
  padding: 10px;
}
</style>
