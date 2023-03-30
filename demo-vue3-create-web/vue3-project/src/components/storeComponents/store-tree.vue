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
      @check="check"
      :check-strictly="true"
      @check-change="checkChange"
    >
      <template #default="{ node, data }">
        <span class="tree-node-btns">
          <span>{{ node.label }}</span>
          <span v-if="data.id !== 'root'" class="two-svg">
            <Edit style="width: 1em; height: 1em; margin-right: 8px" @click="editEvent(data)" />
            <Delete style="width: 1em; height: 1em; margin-right: 8px" @click="deleteEvent(data)" />
          </span>
        </span>
      </template>
    </el-tree>
    <el-dialog
      v-model="dialogEditStatus"
      :title="editTitle"
      :show-close="false"
      :close-on-click-modal="false"
      :close-on-press-escape="false"
      width="320"
      style="height: 200px"
    >
      <el-input v-model="storeEditName" placeholder="请输入店铺名称" />
      <template #footer>
        <span class="edit-dialog-footer">
          <el-button @click="dialogEditStatus = false">取消</el-button>
          <el-button type="primary" @click="editConfirm">确定</el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script lang="ts" setup>
  import { ElTree, ElMessageBox } from 'element-plus';
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
  let editCacheData = ref(null);
  let dialogEditStatus = ref(false);
  let editTitle = ref('修改店铺弹窗');
  let storeEditName = ref('');
  const treeRef = ref<InstanceType<typeof ElTree>>();
  let checkedNodes = ref([]);
  const defaultProps = {
    children: 'children',
    label: 'label',
  };
  const emit = defineEmits<{
    (e: 'node-display', data: {}): void;
    (e: 'cancel-operation', data: {}): void;
    (e: 'check-operation', data: {}): void;
    (e: 'edit-operation', data: {}): void;
    (e: 'delete-operation', data: {}): void;
  }>();
  const props = withDefaults(defineProps<Props>(), {
    treeList: () => [{ id: 'root', label: '店铺', children: [] }],
  });
  defineExpose({
    treeData: treeRef,
  });
  const nodeClick = (data, node, treeNode, event) => {
    emit('node-display', { data: data });
  };
  const checkOpration = () => {
    nextTick(() => {
      checkedNodes.value = treeRef.value.getCheckedNodes();
      emit('check-operation', { data: checkedNodes.value });
    });
  };
  const check = () => {
    checkOpration();
  };
  const checkChange = (data, status: boolean) => {
    if (data.id === 'root') {
      if (status) {
        nextTick(() => {
          props.treeList[0].children.forEach((element) => {
            treeRef.value.setChecked(element.id, true, false);
          });
        });
      } else {
        props.treeList[0].children.forEach((element) => {
          treeRef.value.setChecked(element.id, false, false);
        });
      }
    }
  };
  const editConfirm = () => {
    editCacheData.value.storeName = storeEditName.value;
    emit('edit-operation', { data: editCacheData.value });
    dialogEditStatus.value = false;
  };
  const editEvent = (data) => {
    editCacheData.value = data;
    dialogEditStatus.value = true;
  };
  const deleteEvent = (data) => {
    emit('delete-operation', { data: data });
  };
  onMounted(() => {
    checkOpration();
  });
</script>
<style lang="less" scoped>
  .ts-tree-main {
    width: 100%;
    height: 100%;
    overflow: auto;
    .tree-node-btns {
      font-size: 16px;
      display: inline-block;
      .two-svg {
        display: inline-block;
        vertical-align: -7%;
        margin-left: 60%;
      }
    }
  }
</style>
