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
            <store-tree :tree-list="treeList" />
          </div>
        </template>
        <template #right>
          <div class="demo-split-right-pane">
            <store-table :table-list="tableList" />
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
    <insertModal
      :modal-status="insertStatus"
      @confirm-opration="confirmOperation"
      @cancel-operation="cancelOperation"
      :formList="formList"
    />
  </div>
</template>
<script lang="ts" setup>
  import { ref, computed, watch, onMounted, provide, getCurrentInstance } from 'vue';
  import storeTree from '../../components/storeComponents/store-tree.vue';
  import storeTable from '../../components/storeComponents/store-table.vue';
  import insertModal from '../../components/storeComponents/modal/insert-modal.vue';
  import storeApi from '../../utils/storeApi';
  import { ElMessage } from 'element-plus';
  interface formtemplate {
    type: string;
    width: number;
    key: string;
    label: string;
    placeholder: string;
    [propName: string]: any;
  }
  interface treeTypeList {
    id: string;
    storeId: string;
    storeName: string;
    createTime: Date;
    parentId: string;
    [propName: string]: any;
  }
  interface tableTypeList {
    id: string;
    storeId: string;
    goodId: string;
    goodName: string;
    createTime: Date;
    [propName: string]: any;
  }
  let tableList = ref([]);
  let treeList = ref([]);
  let insertStatus = ref(false);
  let displayBtn = ref(['增加', '修改', '查询', '删除']);
  let contentSplit = ref(0.2);
  let currentPage = ref(1);
  let pageSize = ref(5);
  let tableTotal = ref(0);
  const small = ref(false);
  const background = ref(false);
  const disabled = ref(false);
  const Xeutils = getCurrentInstance().appContext.config.globalProperties.$Xeutils;
  let formList = ref<formtemplate[]>([
    {
      type: 'input',
      width: 140,
      key: 'storeId',
      prop: 'storeId',
      label: '店铺标识',
      placeholder: '请输入店铺标识',
      selectList: [],
    },
    {
      type: 'input',
      width: 140,
      key: 'storeName',
      prop: 'storeName',
      label: '店铺名称',
      placeholder: '请输入店铺名称',
    },
    {
      type: 'input',
      width: 140,
      key: 'goodId',
      prop: 'goodId',
      label: '货物标识',
      placeholder: '请输入货物标识',
      selectList: [],
    },
    {
      type: 'input',
      width: 140,
      key: 'goodName',
      prop: 'goodName',
      label: '货物名称',
      placeholder: '请输入货物名称',
    },
    {
      type: 'datetime',
      width: 140,
      key: 'createTime',
      prop: 'createTime',
      label: '创建日期',
      placeholder: '请输入日期时间',
    },
  ]);
  let storeListQuery = () => {
    storeApi
      .queryStores()
      .then((res) => {
        if (res.status === 200) {
          formList.value[0].selectList = res.data.map((item) => {
            return { value: item.storeId, label: item.storeName };
          });
        } else {
          ElMessage({
            message: '获取店铺列表失败',
            type: 'error',
          });
        }
      })
      .catch((error) => {
        ElMessage({
          message: `${error.toString()}`,
          type: 'error',
        });
      });
  };
  let goodsListQuery = () => {
    storeApi
      .queryGoods()
      .then((res) => {
        if (res.status === 200) {
          formList.value[2].selectList = res.data.map((item) => {
            return { value: item.goodId, label: item.goodName };
          });
        } else {
          ElMessage({
            message: '获取货物列表失败',
            type: 'error',
          });
        }
      })
      .catch((error) => {
        ElMessage({
          message: `${error.toString()}`,
          type: 'error',
        });
      });
  };
  storeListQuery();
  goodsListQuery();
  let storeAllQuery = () => {
    let treeTemplate: Array<treeTypeList> = [
      {
        id: 'root',
        storeId: '',
        storeName: '',
        parentId: '',
        createTime: Xeutils.toDateString(new Date(), 'yyyy-MM-dd HH:mm:ss'),
        label: '店铺',
      },
    ];
    let tableTemplate: Array<tableTypeList> = [];
    storeApi
      .queryall()
      .then((res) => {
        if (res.status === 200) {
          res.data.forEach((element) => {
            treeTemplate.push({
              id: element.id,
              storeId: element.storeId,
              storeName: element.storeName,
              parentId: element.parentId,
              createTime: element.createTime,
              label: element.storeName,
            });
            tableTemplate.push({
              id: element.aliaId,
              storeId: element.storeId,
              goodId: element.goodId,
              goodName: element.goodName,
              createTime: element.createTime,
            });
          });
          treeList.value = Xeutils.toArrayTree(treeTemplate);
          tableList.value = tableTemplate;
        } else {
          ElMessage({
            message: '获取数据失败',
            type: 'error',
          });
        }
      })
      .catch((error) => {
        ElMessage({
          message: `${error}`,
          type: 'error',
        });
      });
  };
  storeAllQuery();
  let insertStoreInfo = () => {
    insertStatus.value = true;
  };
  let confirmOperation = ($event) => {
    insertStatus.value = $event.modalStatus;
    let insertValue = Object.assign(
      {},
      {
        storeId: $event.formData.value.storeId,
        storeName: $event.formData.value.storeName,
        createTime: $event.formData.value.createTime,
      },
      {
        goodDTO: { goodId: $event.formData.value.goodId, goodName: $event.formData.value.goodName },
      },
    );
    if (!$event.modalStatus) {
      storeApi
        .insert(insertValue)
        .then((res) => {
          if (res.status === 200) {
            ElMessage({
              message: '注册添加成功',
              type: 'success',
            });
            storeAllQuery();
          } else {
            ElMessage({
              message: '注册添加失败',
              type: 'warning',
            });
          }
        })
        .catch((error) => {
          ElMessage({
            message: `${error}`,
            type: 'error',
          });
        });
    }
  };
  let cancelOperation = ($event) => {
    insertStatus.value = $event.modalStatus;
  };
  let updateStoreInfo = () => {};
  let selectStoreInfo = () => {};
  let deleteStoreInfo = () => {};
  const handleSizeChange = (val: number) => {
    console.log(`${val} items per page`);
  };
  const handleCurrentChange = (val: number) => {
    console.log(`current page: ${val}`);
  };
  onMounted(() => {});
</script>
<style lang="less" scoped>
  .ts-main {
    width: 100%;
    height: 100%;
    .ts-content {
      width: 100%;
      height: 80%;
      .demo-split-left-pane {
        height: 100%;
        width: 100%;
        padding: 10px;
      }
      .demo-split-right-pane {
        height: 100%;
        width: 100%;
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
