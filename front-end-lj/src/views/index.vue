<template>
  <div class="container">
    <common-header :display-types="displayGroups"></common-header>
    <div class="center">
      <left-tree class="left-tree" :tree-data="treeData"></left-tree>
      <el-divider direction="vertical" class="divider-info" />
      <right-table class="right-table" :table-data="tableData"></right-table>
    </div>
    <common-footer></common-footer>
  </div>
</template>
<script setup lang="ts">
import { ref, reactive } from 'vue'
import commonHeader from '@/components/basic/header/index.vue'
import { SETTING } from '@/enums/display-setting'
import { buttonSize, buttonType } from '@/enums/button'
import commonFooter from '@/components/basic/footer/index.vue'
import leftTree from '@/components/general/tree.vue'
import rightTable from '@/components/general/table.vue'
import { queryTreeData, queryTableData } from '@/utils/http'
import { storageHanderClass } from '@/utils/storage'
let displayGroups = reactive([
  {
    id: SETTING.BUTTON,
    size: buttonSize.DEFAULT,
    type: buttonType.PRIMARY,
    plain: false,
    text: false,
    content: '按钮',
  },
  {
    id: SETTING.BUTTON,
    size: buttonSize.DEFAULT,
    type: buttonType.INFO,
    plain: true,
    text: true,
    content: '按钮1',
    disable: true,
  },
  {
    id: SETTING.BUTTON,
    size: buttonSize.DEFAULT,
    type: buttonType.SUCCESS,
    plain: false,
    text: false,
    content: '按钮2',
  },
  {
    id: SETTING.BUTTON,
    size: buttonSize.DEFAULT,
    type: buttonType.WARNING,
    plain: false,
    text: true,
    content: '按钮3',
  },
  {
    id: SETTING.BUTTON,
    size: buttonSize.DEFAULT,
    type: buttonType.DANGER,
    plain: true,
    text: true,
    content: '按钮4',
    disable: true,
  },
])
let treeData = ref<any[]>([])
let tableData = ref<any[]>([])
//获取树形数据
function queryTreeDataInfo() {
  let treeDataStorage = new storageHanderClass().getStorageInfo('treedata')
  if (treeDataStorage) {
    treeData.value = treeDataStorage
    return
  }
  return new Promise((resolve, reject) => {
    queryTreeData({ data: {}, name: 'queryTreeData' })
      .then((res: any) => {
        treeData.value = res.data
        if (treeData.value) {
          new storageHanderClass().setStorageInfo('treedata', JSON.stringify(treeData.value))
        }
      })
      .catch((error: any) => {
        console.log(error)
      })
  })
}
//获取表格数据
function queryTableDataInfo() {
  let tableDataStorage = new storageHanderClass().getStorageInfo('tabledata')
  if (tableDataStorage) {
    tableData.value = tableDataStorage
    return
  }
  return new Promise((resolve, reject) => {
    queryTableData({ data: {}, name: 'queryTableData' })
      .then((res: any) => {
        tableData.value = res.data
        if (tableData.value) {
          new storageHanderClass().setStorageInfo('tabledata', JSON.stringify(tableData.value))
        }
      })
      .catch((error: any) => {
        console.log(error)
      })
  })
}
function initCurrentPage() {
  Promise.all([queryTreeDataInfo(), queryTableDataInfo()])
}
initCurrentPage()
</script>
<style lang="scss" scoped>
.container {
  height: 100vh;
  display: flex;
  flex-direction: column;
  .center {
    flex: 1;
    overflow: hidden;
    display: flex;
    .left-tree {
      flex: 1;
    }
    .divider-info {
      height: 100%;
      margin: 0;
    }
    .right-table {
      flex: 3;
    }
  }
}
</style>
