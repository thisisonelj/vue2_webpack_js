<template>
  <div class="table-container">{{ content }}</div>
</template>
<script setup lang="ts">
import { ref } from 'vue'
let content = ref('表格区域')
</script>
<style lang="scss" scoped>
.table-container {
  padding: 10px;
}
</style>
