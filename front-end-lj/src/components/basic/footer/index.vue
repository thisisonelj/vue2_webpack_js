<template>
  <el-divider style="margin: 0" />
  <div class="footer"></div>
</template>
<script setup lang="ts">
import { ref } from 'vue'
let content = ref('这是footer底部内容')
</script>
<style lang="scss" scoped>
.footer {
  padding: 20px;
  height: 15vh;
}
</style>
