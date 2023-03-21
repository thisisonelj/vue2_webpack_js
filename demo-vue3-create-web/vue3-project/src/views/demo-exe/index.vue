<template>
  <div class="ts-main">
    <div class="ts-content">
      <el-button type="success">{{ msg }}</el-button>
    </div>
  </div>
</template>
<script lang="ts" setup>
  import { ref, computed, watch, onMounted, provide } from 'vue';
  let msg = ref('ts按钮');
</script>
<style lang="less" scoped>
  .ts-main {
    width: 100%;
    height: 100%;
    .ts-content {
      border: 1px solid red;
      background-color: black;
      position: absolute;
      left: 0;
      bottom: 0;
      top: 0;
      right: 0;
      margin: auto;
      width: 40%;
      height: 50%;
      display: flex;
      justify-content: center;
      align-items: center;
    }
  }
</style>
