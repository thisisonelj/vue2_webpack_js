<template>
  <el-button
    :size="originDataInfo.size"
    :type="originDataInfo.type"
    :plain="originDataInfo.plain"
    class="button-info"
    :color="originDataInfo.color"
    @click="displayInfo"
    :loading="originDataInfo.loading"
    v-btnauth="originDataInfo.code"
  >
    {{ $t('btnText') }}
  </el-button>
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
const props = defineProps<{
  originDataInfo: buttonTemplate
}>()
function displayInfo() {
  console.log('这是按钮组件')
}
</script>
<style lang="scss" scoped>
.button-info {
  padding: 20px;
  font-weight: 700;
  font-size: 24px;
}
</style>
