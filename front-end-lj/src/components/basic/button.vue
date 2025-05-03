<template>
  <div class="button-container">
    <el-button
      :size="originDataInfo.size"
      :type="originDataInfo.type"
      :plain="originDataInfo.plain"
      class="default-info"
    ></el-button>
  </div>
</template>
<script setup lang="ts">
import { buttonSize, buttonType } from '@/enums/button'
import { ref, reactive } from 'vue'
interface buttonTemplate {
  size: buttonSize
  type: buttonType
  plain: Boolean
  text?: Boolean
  bg?: Boolean
  link?: buttonSize
  round?: buttonType
  circle?: Boolean
  loading?: Boolean
  disable?: Boolean
  color?: String
  [prop: string]: any
}
const originDataInfo = defineProps<buttonTemplate>()
</script>
<style lang="scss" scoped>
.button-container {
  .default-info {
  }
}
</style>
