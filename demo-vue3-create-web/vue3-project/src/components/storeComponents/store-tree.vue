<template>
  <div class="ts-tree-main">
    <el-tree
      ref="treeRef"
      :data="treeList"
      show-checkbox
      default-expand-all
      node-key="id"
      highlight-current
      :props="defaultProps"
    />
  </div>
</template>

<script lang="ts" setup>
  import { ref } from 'vue';
  import { ElTree } from 'element-plus';
  interface Tree {
    id: string;
    label: string;
    children?: Tree[];
    [propName: string]: any;
  }
  interface Props {
    treeList: Tree[];
  }
  const treeRef = ref<InstanceType<typeof ElTree>>();
  const defaultProps = {
    children: 'children',
    label: 'label',
  };
  const emit = defineEmits<{
    (e: 'confirm-opration', data: {}): void;
    (e: 'cancel-operation', data: {}): void;
  }>();
  const props = withDefaults(defineProps<Props>(), {
    treeList: () => [{ id: 'root', label: '店铺', children: [] }],
  });
</script>
<style lang="less" scoped>
  .ts-tree-main {
    width: 100%;
    height: 100%;
    overflow: auto;
  }
</style>
