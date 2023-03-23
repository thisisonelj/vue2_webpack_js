<template>
  <div>{{ msg }}</div>
</template>
<script lang="ts" setup>
  import { ref, computed, watch, onMounted, provide } from 'vue';
  let msg = ref('添加modal');
</script>
<style lang="less" scoped></style>
