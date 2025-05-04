<template>
  <div class="tree-container">
    <el-tree
      class="tree"
      :data="treeData"
      :props="defaultProps"
      @node-click="handleNodeClick"
      ref="treeRef"
      default-expand-all
      node-key="id"
      highlight-current
      empty-text="暂无数据"
      :show-checkbox="false"
    />
  </div>
</template>
<script setup lang="ts">
import { ref, reactive } from 'vue'
type Tree = {
  label: string
  children?: Tree[]
  [props: string]: any
}
const props = defineProps<{
  treeData: Array<Tree>
}>()
const emits = defineEmits<{
  (e: 'refresh-table', value: Tree): any
}>()
const defaultProps = ref({
  children: 'children',
  label: 'label',
})
function handleNodeClick(node: Tree) {
  emits('refresh-table', node)
}
</script>
<style lang="scss" scoped>
.tree-container {
  padding: 10px;
  .tree {
  }
}
</style>
