<template>
  <div class="container">
    <common-header :display-types="displayGroups"></common-header>
    <div class="center">
      <left-tree class="left-tree" :tree-data="treeData" @refresh-table="refreshTable"></left-tree>
      <el-divider direction="vertical" class="divider-info" />
      <right-table class="right-table" :table-data="tableData" @edit-change="editChange" @delete-change="deleteChange"></right-table>
    </div>
    <common-footer @pagesize-change="pageSizeChange" @currentpage-change="currentpageChange" ref="pagation"></common-footer>
  </div>
</template>
<script setup lang="ts">
  import { ref, reactive, useTemplateRef, onMounted } from 'vue';
  import commonHeader from '@/components/basic/header/index.vue';
  import { SETTING } from '@/enums/display-setting';
  import { buttonSize, buttonType } from '@/enums/button';
  import commonFooter from '@/components/basic/footer/index.vue';
  import leftTree from '@/components/general/tree.vue';
  import rightTable from '@/components/general/table.vue';
  import { queryTreeData, queryTableData } from '@/utils/http';
  import { storageHanderClass } from '@/utils/storage';
  import { pagationFunClass } from '@/utils/pagation';
  import { btnToLoading } from '@/hooks/test';
  import {
    querySingleRecord,
    queryAllRecords,
    testHttpGetCache,
    testSse,
    testPipeValid,
    testPipeValidCustom,
    testExceptionFilterValid,
    testGuardPowerValid,
    testInterceptorValid,
    testEmitterListenerInfo,
    testDeepSeekApiInfo,
    testMicroServiceInfo,
  } from '@/api/goodsApi';
  interface btnPowerTemplate {
    code: String;
    label: String;
    [props: string]: any;
  }
  let displayGroups = reactive([
    {
      id: SETTING.BUTTON,
      size: buttonSize.DEFAULT,
      type: buttonType.PRIMARY,
      plain: false,
      text: false,
      content: '按钮',
      code: '001',
    },
    {
      id: SETTING.BUTTON,
      size: buttonSize.DEFAULT,
      type: buttonType.INFO,
      plain: true,
      text: true,
      content: '按钮1',
      disable: true,
      code: '002',
    },
    {
      id: SETTING.BUTTON,
      size: buttonSize.DEFAULT,
      type: buttonType.SUCCESS,
      plain: false,
      text: false,
      content: '按钮2',
      code: '003',
    },
    {
      id: SETTING.BUTTON,
      size: buttonSize.DEFAULT,
      type: buttonType.WARNING,
      plain: false,
      text: true,
      content: '按钮3',
      code: '004',
    },
    {
      id: SETTING.BUTTON,
      size: buttonSize.DEFAULT,
      type: buttonType.DANGER,
      plain: true,
      text: true,
      content: '按钮4',
      disable: true,
      code: '006',
    },
  ]);
  const btnPowerGroups = reactive<Array<btnPowerTemplate>>([
    {
      code: '001',
      label: '第一个',
    },
    {
      code: '002',
      label: '第二个',
    },
    {
      code: '003',
      label: '第三个',
    },
    {
      code: '004',
      label: '第四个',
    },
    {
      code: '005',
      label: '第五个',
    },
  ]);
  let treeData = ref<any[]>([]);
  let tableData = ref<any[]>([]);
  let tableDataCache = ref<any[]>([]);
  const pagationReF: any = useTemplateRef('pagation');
  const { loading, changeLoad } = btnToLoading(tableData);
  changeLoad();
  displayGroups.forEach((e: any) => {
    e.loading = loading.value;
  });
  //获取树形数据
  function queryTreeDataInfo() {
    let treeDataStorage = new storageHanderClass().getStorageInfo('treedata');
    if (treeDataStorage) {
      treeData.value = treeDataStorage;
      return;
    }
    return new Promise((resolve, reject) => {
      queryTreeData({ data: {}, name: 'queryTreeData' })
        .then((res: any) => {
          treeData.value = res.data;
          if (treeData.value) {
            new storageHanderClass().setStorageInfo('treedata', JSON.stringify(treeData.value));
          }
        })
        .catch((error: any) => {
          console.log(error);
        });
    });
  }
  //获取表格数据
  function queryTableDataInfo() {
    let tableDataStorage = new storageHanderClass().getStorageInfo('tabledata');
    tableDataCache.value = tableDataStorage;
    if (tableDataStorage) {
      let pagationInstance = new pagationFunClass(tableDataCache.value).initPage();
      tableData.value = pagationInstance.data;
      pagationReF.value.pagetionData.total = pagationInstance.total;
      return;
    }
    return new Promise((resolve, reject) => {
      queryTableData({ data: {}, name: 'queryTableData' })
        .then((res: any) => {
          tableData.value = res.data;
          if (tableData.value) {
            new storageHanderClass().setStorageInfo('tabledata', JSON.stringify(tableData.value));
            let pagationInstance = new pagationFunClass(tableDataCache.value).initPage();
            tableData.value = pagationInstance.data;
            pagationReF.value.pagetionData.total = pagationInstance.total;
          }
        })
        .catch((error: any) => {
          console.log(error);
        });
    });
  }
  function initCurrentPage() {
    Promise.all([queryTreeDataInfo(), queryTableDataInfo()]);
  }
  function queryCurrentTableData(id: String) {
    tableData.value = tableDataCache.value.filter((e) => {
      return e.goodId == id;
    });
  }
  function refreshTable(data: any) {
    queryCurrentTableData(data.id);
  }
  function pageSizeChange(data: any) {
    let pagationInstance = new pagationFunClass(tableDataCache.value).sizeChange(data.pageSize, data.current);
    tableData.value = pagationInstance.data;
    pagationReF.value.pagetionData.total = pagationInstance.total;
  }
  function currentpageChange(data: any) {
    let pagationInstance = new pagationFunClass(tableDataCache.value).currentChange(data.current, data.pageSize);
    tableData.value = pagationInstance.data;
    pagationReF.value.pagetionData.total = pagationInstance.total;
  }
  function editChange(data: any) {
    tableData.value.forEach((item: any) => {
      if (item.goodId == data.goodId) {
        item.goodId = data.goodId;
        item.goodName = data.goodName;
        item.price = data.price;
        item.createTime = data.createTime;
      }
    });
  }
  function deleteChange(data: any) {
    tableData.value.splice(data.index, 1);
  }
  //存储按钮权限
  function initBtnPower() {
    const storageHander = new storageHanderClass();
    storageHander.setStorageInfo('btn-permission', JSON.stringify(btnPowerGroups));
  }
  // 测试nest服务api接口
  const testNestApiInfo = async () => {
    const res = await testMicroServiceInfo({ data: { num: '123,456,789' } });
    console.log(res);
  };
  onMounted(() => {
    // 测试jenkins Pr合并通知
    // initCurrentPage();
    // initBtnPower();
    testNestApiInfo();
  });
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
