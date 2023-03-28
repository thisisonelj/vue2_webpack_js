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
      @node-click="nodeClick"
      :expand-on-click-node="false"
    />
  </div>
</template>

<script lang="ts" setup>
  import { ElTree } from 'element-plus';
  import { ref, computed, watch, onMounted, provide, getCurrentInstance, nextTick } from 'vue';
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
    (e: 'node-display', data: {}): void;
    (e: 'cancel-operation', data: {}): void;
  }>();
  const props = withDefaults(defineProps<Props>(), {
    treeList: () => [{ id: 'root', label: '店铺', children: [] }],
  });
  const nodeClick = (data, node, treeNode, event) => {
    emit('node-display', { data: data });
  };
  onMounted(() => {
    nextTick(() => {
      setTimeout(() => {
        treeRef.value.setCurrentKey('root');
      }, 100);
    });
  });
</script>
<style lang="less" scoped>
  .ts-tree-main {
    width: 100%;
    height: 100%;
    overflow: auto;
  }
</style>
