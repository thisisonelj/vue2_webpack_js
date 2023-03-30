<template>
  <div class="ts-main">
    <div class="ts-top">
      <el-button type="primary" @click="insertStoreInfo">{{ displayBtn.INSERT }}</el-button>
      <el-button type="info" @click="selectStoreInfo">{{ displayBtn.SELECT }}</el-button>
      <el-button type="default" @click="saveGoodInfo">{{ displayBtn.SAVE }}</el-button>
    </div>
    <div class="ts-content">
      <Split v-model="contentSplit">
        <template #left>
          <div class="demo-split-left-pane">
            <store-tree
              :tree-list="treeList"
              @node-display="nodeClick"
              ref="storeTreeData"
              @check-operation="getCheckedNodes"
              @edit-operation="editOperation"
              @delete-operation="deletOperation"
            />
          </div>
        </template>
        <template #right>
          <div class="demo-split-right-pane">
            <store-table
              :table-list="tableList"
              @delete-row="deleteClick"
              @update-row="updateClick"
              ref="storeTableData"
            />
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
    <selectDrawer
      :modal-status="selectStatus"
      @confirm-select-opration="confirmSelectOperation"
      @cancel-select-operation="cancelSelectOperation"
      :drawerList="drawList"
    />
  </div>
</template>
<script lang="ts" setup>
  import { ref, computed, watch, onMounted, provide, getCurrentInstance, nextTick } from 'vue';
  import storeTree from '../../components/storeComponents/store-tree.vue';
  import storeTable from '../../components/storeComponents/store-table.vue';
  import insertModal from '../../components/storeComponents/modal/insert-modal.vue';
  import selectDrawer from '../../components/storeComponents/modal/select-drawer.vue';
  import storeApi from '../../utils/storeApi';
  import { ElMessage, ElTree, ElMessageBox } from 'element-plus';
  import commonObject from '../../utils/utils';
  import { pagation } from '../../utils/pagation';
  import { btnGroups } from '../../utils/enum';
  interface formtemplate {
    type: string;
    width: number;
    key?: string;
    label?: string;
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
  let displayBtn = ref(btnGroups);
  let contentSplit = ref(0.2);
  let currentPage = ref(1);
  let pageSize = ref(5);
  let tableTotal = ref(0);
  const small = ref(false);
  const background = ref(false);
  const disabled = ref(false);
  const Xeutils = getCurrentInstance().appContext.config.globalProperties.$Xeutils;
  let checkedTreeNodes = ref([]);
  const storeTreeData = ref(null);
  let handleTotalRows = ref(null);
  let selectStatus = ref(false);
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
  let drawList = ref<formtemplate[]>([
    {
      type: 'select',
      width: 140,
      key: 'storeId',
      prop: 'storeId',
      label: '店铺信息',
      placeholder: '请输入店铺信息',
      selectList: [],
    },
    {
      type: 'datetime',
      width: 140,
      content: {
        startTime: {
          key: 'startTime',
          prop: 'startTime',
          label: '开始日期',
        },
        endTime: {
          key: 'endTime',
          prop: 'endTime',
          label: '结束日期',
        },
      },
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
          drawList.value[0].selectList = res.data.map((item) => {
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
          let resultArray = res.data.map((item) => {
            return { value: item.goodId, label: item.goodName };
          });
          formList.value[2].selectList = commonObject.arrayDeduplication(resultArray, []);
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
  let commonPagetion = (tableTemplate) => {
    const pagationParam = { currentPage: 1, pageSize: 5, total: tableTemplate.length };
    let pageResult = pagation(pagationParam, tableTemplate);
    currentPage.value = 1;
    pageSize.value = 5;
    tableTotal.value = pageResult.total;
    tableList.value = pageResult.data;
    handleTotalRows.value = tableTemplate;
  };
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
          res.data.store.forEach((element) => {
            treeTemplate.push({
              id: element.id,
              storeId: element.storeId,
              storeName: element.storeName,
              parentId: element.parentId,
              createTime: element.createTime,
              label: element.storeName,
            });
          });
          tableTemplate = res.data.good;
          treeList.value = Xeutils.toArrayTree(treeTemplate);
          tableTemplate.forEach((element) => {
            let storeNameList = formList.value[0].selectList;
            let resultArray = storeNameList.filter((e) => {
              return e.value === element.storeId;
            });
            element.storeName = resultArray[0].label;
            element.editStatus = true;
            element.editInputStatus = false;
          });
          commonPagetion(tableTemplate);
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
            storeListQuery();
            goodsListQuery();
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
  let nodeClick = ($event: { id?: string; [propName: string]: any }) => {
    if ($event.data.id === 'root') {
      storeApi
        .queryByStoreIdList($event.data.children)
        .then((res) => {
          if (res.status === 200) {
            let result = res.data;
            let resultArray = formList.value[0].selectList;
            result.forEach((element) => {
              let filterResult = resultArray.filter((e) => {
                return e.value === element.storeId;
              });
              element.storeName = filterResult[0].label;
              element.editStatus = true;
              element.editInputStatus = false;
            });
            commonPagetion(result);
          } else {
            ElMessage({
              message: '获取货物失败',
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
    } else {
      storeApi
        .queryByStoreId($event.data)
        .then((res) => {
          if (res.status === 200) {
            let result = res.data;
            let resultArray = formList.value[0].selectList;
            result.forEach((element) => {
              let filterResult = resultArray.filter((e) => {
                return e.value === element.storeId;
              });
              element.storeName = filterResult[0].label;
              element.editStatus = true;
              element.editInputStatus = false;
            });
            commonPagetion(result);
          } else {
            ElMessage({
              message: '获取数据失败',
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
  let deleteClick = ($event) => {
    storeApi
      .deleteByGoodid($event.data)
      .then((res) => {
        if (res.status === 200) {
          handleTotalRows.value = handleTotalRows.value.filter((e) => {
            return e.id !== $event.data.id;
          });
          commonPagetion(handleTotalRows.value);
          storeListQuery();
          goodsListQuery();
          ElMessage({
            message: '删除货物成功',
            type: 'success',
          });
        } else {
          ElMessage({
            message: '删除货物失败',
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
  };
  let updateClick = ($event) => {
    tableList.value.forEach((element) => {
      if (element.id === $event.data.id) {
        element.editStatus = false;
        element.editInputStatus = true;
      }
    });
  };
  let saveGoodInfo = () => {
    if (checkedTreeNodes.value.length === 0) {
      ElMessage({
        message: '请先选择店铺节点',
        type: 'warning',
      });
      return;
    }
    ElMessageBox.confirm('确定保存吗', '保存货物信息弹窗', {
      confirmButtonText: '确定',
      cancelButtonText: '取消',
      type: 'warning',
      customClass: 'el-message-confirm',
    }).then(() => {
      storeApi
        .updateByGoodid(tableList.value)
        .then((res) => {
          if (res.status === 200) {
            tableList.value.forEach((element) => {
              element.editStatus = true;
              element.editInputStatus = false;
            });
            storeListQuery();
            goodsListQuery();
            ElMessage({
              type: 'success',
              message: '保存成功',
            });
          } else {
            ElMessage({
              message: '保存货物失败',
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
    });
  };

  let selectStoreInfo = () => {
    selectStatus.value = true;
  };
  const handleSizeChange = (val: number) => {
    const pagationParam = {
      currentPage: 1,
      pageSize: val,
      total: handleTotalRows.value.length,
    };
    let pageResult = pagation(pagationParam, handleTotalRows.value);
    currentPage.value = 1;
    pageSize.value = val;
    tableTotal.value = pageResult.total;
    tableList.value = pageResult.data;
  };
  const handleCurrentChange = (val: number) => {
    const pagationParam = {
      currentPage: val,
      pageSize: pageSize.value,
      total: handleTotalRows.value.length,
    };
    let pageResult = pagation(pagationParam, handleTotalRows.value);
    currentPage.value = val;
    tableTotal.value = pageResult.total;
    tableList.value = pageResult.data;
  };
  let treeOperation = ($event, operationType: { msg: string; type: number }) => {
    storeListQuery();
    goodsListQuery();
    let goodsList = storeApi.queryByStoreId($event.data);
    if (operationType.type === 0) {
      goodsList = storeApi.queryByStoreId({ id: 'root' });
    }
    let storeList = storeApi.queryStores();
    Promise.all([goodsList, storeList])
      .then(([res1, res2]) => {
        if (res1.status === 200 && res2.status === 200) {
          let result = res1.data;
          let resultArray = formList.value[0].selectList;
          result.forEach((element) => {
            let filterResult = resultArray.filter((e) => {
              return e.value === element.storeId;
            });
            element.storeName = filterResult[0].label;
            element.editStatus = true;
            element.editInputStatus = false;
          });
          commonPagetion(result);
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
          res2.data.forEach((element) => {
            treeTemplate.push({
              id: element.id,
              storeId: element.storeId,
              storeName: element.storeName,
              parentId: element.parentId,
              createTime: element.createTime,
              label: element.storeName,
            });
          });
          treeList.value = Xeutils.toArrayTree(treeTemplate);
          nextTick(() => {
            if (operationType.type === 1)
              storeTreeData.value.treeData.setCurrentKey($event.data.id);
            else storeTreeData.value.treeData.setCurrentKey('root');
          });
        } else {
          ElMessage({
            message: `${operationType.msg}`,
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
  };

  let editOperation = ($event) => {
    storeApi
      .updateByStoreid($event.data)
      .then((res) => {
        if (res.status === 200) {
          const operationType = { msg: '更新店铺失败', type: 1 };
          treeOperation($event, operationType);
          ElMessage({
            type: 'success',
            message: '更新店铺成功',
          });
        } else {
          ElMessage({
            message: '更新店铺失败',
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
  };
  let deletOperation = ($event) => {
    ElMessageBox.confirm('确定删除吗', '删除店铺信息弹窗', {
      confirmButtonText: '确定',
      cancelButtonText: '取消',
      type: 'warning',
      customClass: 'el-message-confirm',
    })
      .then(() => {
        storeApi.deleteByStoreid($event.data).then((res) => {
          if (res.status === 200) {
            const operationType = { msg: '删除店铺失败', type: 0 };
            treeOperation($event, operationType);
            ElMessage({
              type: 'success',
              message: '删除店铺成功',
            });
          } else {
            ElMessage({
              message: '删除店铺失败',
              type: 'warning',
            });
          }
        });
      })
      .catch((error) => {
        ElMessage({
          message: '取消成功',
          type: 'info',
        });
      });
  };
  const getCheckedNodes = ($event) => {
    checkedTreeNodes.value = $event.data;
  };
  const confirmSelectOperation = ($event) => {
    let selectData = [];
    for (let i = 0; i < $event.formData.storeId.length; i++) {
      selectData.push({
        storeId: $event.formData.storeId[i],
        startTime: Xeutils.toDateString($event.formData.startTime, 'yyyy-MM-dd HH:mm:ss'),
        endTime: Xeutils.toDateString($event.formData.endTime, 'yyyy-MM-dd HH:mm:ss'),
      });
    }
    selectStatus.value = $event.modalStatus;
    storeApi
      .selectScheme(selectData)
      .then((res) => {
        if (res.status === 200) {
          let resList = res.data;
          resList.forEach((item) => {
            item.value = item.id;
            item.label = item.storeName;
            item.editStatus = true;
            item.editInputStatus = false;
          });
          let deDuplicationArray = commonObject.arrayDeduplication(resList, []);
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
          deDuplicationArray.forEach((element) => {
            treeTemplate.push({
              id: element.id,
              storeId: element.storeId,
              storeName: element.storeName,
              parentId: element.parentId,
              createTime: element.createTime,
              label: element.storeName,
            });
          });
          treeList.value = Xeutils.toArrayTree(treeTemplate);
          let tableTemplate = [...resList];
          tableTemplate.forEach((element) => {
            element.id = element.aliaId;
          });
          commonPagetion(tableTemplate);
          nextTick(() => {
            storeTreeData.value.treeData.setChecked('root', true, true);
          });
          ElMessage({
            message: '查询成功',
            type: 'success',
          });
        } else {
          ElMessage({
            message: '查询失败',
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
  };
  const cancelSelectOperation = ($event) => {
    selectStatus.value = false;
  };
  onMounted(() => {
    setTimeout(() => {
      storeTreeData.value.treeData.setCurrentKey('root');
    }, 200);
    checkedTreeNodes.value = storeTreeData.value.treeData.getCheckedNodes();
  });
  watch(checkedTreeNodes, (value: any[]) => {
    let checkedNodes = value.filter((e) => {
      return e.id !== 'root';
    });

    storeApi
      .queryByStoreIdList(checkedNodes)
      .then((res) => {
        if (res.status === 200) {
          let result = res.data;
          let resultArray = formList.value[0].selectList;
          result.forEach((element) => {
            let filterResult = resultArray.filter((e) => {
              return e.value === element.storeId;
            });
            element.storeName = filterResult[0].label;
            element.editStatus = true;
            element.editInputStatus = false;
          });
          commonPagetion(result);
        } else {
          ElMessage({
            message: '获取货物失败',
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
  });
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
<style>
  .el-message-confirm {
    margin-top: -20%;
  }
</style>
