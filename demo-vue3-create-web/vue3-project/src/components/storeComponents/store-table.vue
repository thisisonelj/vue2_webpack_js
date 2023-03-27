<template>
  <div class="ts-table-main">
    <el-table :data="tableList" style="width: 100%">
      <el-table-column label="id" width="180">
        <template #default="scope">
          <div style="display: flex; align-items: center">
            <el-icon><timer /></el-icon>
            <span style="margin-left: 10px">{{ scope.row.id }}</span>
          </div>
        </template>
      </el-table-column>
      <el-table-column label="店铺标识" width="180">
        <template #default="scope">
          <div style="display: flex; align-items: center">
            <el-icon><timer /></el-icon>
            <span style="margin-left: 10px">{{ scope.row.storeId }}</span>
          </div>
        </template>
      </el-table-column>
      <el-table-column label="货物标识" width="180">
        <template #default="scope">
          <div style="display: flex; align-items: center">
            <el-icon><timer /></el-icon>
            <span style="margin-left: 10px">{{ scope.row.goodId }}</span>
          </div>
        </template>
      </el-table-column>
      <el-table-column label="货物名称" width="180">
        <template #default="scope">
          <div style="display: flex; align-items: center">
            <el-icon><timer /></el-icon>
            <span style="margin-left: 10px">{{ scope.row.goodName }}</span>
          </div>
        </template>
      </el-table-column>
      <el-table-column label="日期时间" width="180">
        <template #default="scope">
          <div style="display: flex; align-items: center">
            <el-icon><timer /></el-icon>
            <span style="margin-left: 10px">{{ scope.row.createTime }}</span>
          </div>
        </template>
      </el-table-column>
      <el-table-column label="Operations">
        <template #default="scope">
          <el-button size="small" @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
          <el-button size="small" type="danger" @click="handleDelete(scope.$index, scope.row)"
            >Delete</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script lang="ts" setup>
  import { Timer } from '@element-plus/icons-vue';

  interface rowType {
    id: string;
    goodId: string;
    goodName: string;
    storeId: string;
    createTime: Date;
    [propName: string]: any;
  }
  interface Props {
    tableList: rowType[];
  }
  const emit = defineEmits<{
    (e: 'confirm-opration', data: {}): void;
    (e: 'cancel-operation', data: {}): void;
  }>();
  const props = withDefaults(defineProps<Props>(), {
    tableList: () => [],
  });

  const handleEdit = (index: number, row: rowType) => {
    console.log(index, row);
  };
  const handleDelete = (index: number, row: rowType) => {
    console.log(index, row);
  };
</script>
<style lang="less" scoped>
  .ts-table-main {
    width: 100%;
    height: 100%;
    overflow: auto;
  }
</style>
