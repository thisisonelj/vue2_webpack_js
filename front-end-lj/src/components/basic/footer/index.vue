<template>
  <el-divider style="margin: 0" />
  <div class="footer">
    <el-pagination
      v-model:current-page="pagetionData.current"
      v-model:page-size="pagetionData.pageSize"
      :page-sizes="[1, 3, 5]"
      :size="size"
      :disabled="disabled"
      :background="background"
      layout="total, sizes, prev, pager, next, jumper"
      :total="pagetionData.total"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
    />
  </div>
</template>
<script setup lang="ts">
import { ref, reactive } from 'vue'
import type { ComponentSize } from 'element-plus'
let size = ref<ComponentSize>('default')
let background = ref(false)
let disabled = ref(false)
type pageInstance = {
  current?: Number
  pageSize?: Number
  total?: Number
  [props: string]: any
}
let pagetionData = reactive<pageInstance>({
  current: 1,
  pageSize: 3,
  total: 0,
})
const emits = defineEmits<{
  (e: 'pagesize-change', value: pageInstance): any
  (e: 'currentpage-change', value: pageInstance): any
}>()
const handleSizeChange = (val: number) => {
  console.log(`${val} items per page`)
  emits('pagesize-change', { pageSize: val, current: pagetionData.current })
}
const handleCurrentChange = (val: number) => {
  console.log(`current page: ${val}`)
  emits('currentpage-change', { current: val, pageSize: pagetionData.pageSize })
}
defineExpose({
  pagetionData,
})
</script>
<style lang="scss" scoped>
.footer {
  padding: 20px;
  height: 15vh;
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
