<template>
  <div class="ts-main">
    <div class="ts-top">
      <el-button type="primary" @click="insertStoreInfo">{{ displayBtn[0] }}</el-button>
      <el-button type="success" @click="updateStoreInfo">{{ displayBtn[1] }}</el-button>
      <el-button type="info" @click="selectStoreInfo">{{ displayBtn[2] }}</el-button>
      <el-button type="warning" @click="deleteStoreInfo">{{ displayBtn[3] }}</el-button>
    </div>
    <div class="ts-content">
      <Split v-model="contentSplit">
        <template #left>
          <div class="demo-split-left-pane">
            <store-tree />
          </div>
        </template>
        <template #right>
          <div class="demo-split-right-pane">
            <store-table />
          </div>
        </template>
      </Split>
    </div>
    <div class="ts-footer">
      <el-pagination
        v-model:current-page="currentPage"
        v-model:page-size="pageSize"
        :page-sizes="[5, 10, 15, 20]"
        :small="small"
        :disabled="disabled"
        :background="background"
        layout="total, sizes, prev, pager, next, jumper"
        :total="tableTotal"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
      />
    </div>
  </div>
</template>
<script lang="ts" setup>
  import { ref, computed, watch, onMounted, provide } from 'vue';
  import storeTree from '../../components/storeComponents/store-tree.vue';
  import storeTable from '../../components/storeComponents/store-table.vue';
  let displayBtn = ref(['增加', '修改', '查询', '删除']);
  let contentSplit = ref(0.2);
  let insertStoreInfo = () => {};
  let updateStoreInfo = () => {};
  let selectStoreInfo = () => {};
  let deleteStoreInfo = () => {};
  let currentPage = ref(1);
  let pageSize = ref(5);
  let tableTotal = ref(0);
  const small = ref(false);
  const background = ref(false);
  const disabled = ref(false);
  const handleSizeChange = (val: number) => {
    console.log(`${val} items per page`);
  };
  const handleCurrentChange = (val: number) => {
    console.log(`current page: ${val}`);
  };
</script>
<style lang="less" scoped>
  .ts-main {
    width: 100%;
    height: 100%;
    .ts-content {
      width: 100%;
      height: 80%;
      .demo-split-left-pane {
        padding: 10px;
      }
      .demo-split-right-pane {
        padding: 10px;
      }
    }
    .ts-top {
      height: 6%;
      line-height: 6%;
      display: flex;
      align-items: center;
      flex-flow: row wrap;
      border-bottom: 2px solid #dcdfe6;
      .ts-divider {
        margin-top: 0;
      }
    }
    .ts-footer {
      height: 14%;
      border-top: 2px solid #dcdfe6;
      display: flex;
      justify-content: flex-end;
      padding: 10px;
    }
  }
</style>
