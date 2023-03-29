<template>
  <div class="ts-table-main">
    <el-table :data="tableList" style="width: 100%">
      <el-table-column label="id" width="150">
        <template #default="scope">
          <div style="display: flex; align-items: center; width: 100%; height: 100%">
            <span v-if="scope.row.editStatus">{{ scope.row.id }}</span>
            <el-input v-if="scope.row.editInputStatus" v-model="scope.row.id" />
          </div>
        </template>
      </el-table-column>
      <el-table-column label="店铺标识" width="150">
        <template #default="scope">
          <div style="display: flex; align-items: center; width: 100%; height: 100%">
            <span>{{ scope.row.storeId }}</span>
            <!-- <el-input v-if="scope.row.editInputStatus" v-model="scope.row.storeId" /> -->
          </div>
        </template>
      </el-table-column>
      <el-table-column label="店铺名称" width="150">
        <template #default="scope">
          <div style="display: flex; align-items: center; width: 100%; height: 100%">
            <span>{{ scope.row.storeName }}</span>
            <!-- <el-input v-if="scope.row.editInputStatus" v-model="scope.row.storeName" /> -->
          </div>
        </template>
      </el-table-column>
      <el-table-column label="货物标识" width="150">
        <template #default="scope">
          <div style="display: flex; align-items: center; width: 100%; height: 100%">
            <span v-if="scope.row.editStatus">{{ scope.row.goodId }}</span>
            <el-input v-if="scope.row.editInputStatus" v-model="scope.row.goodId" />
          </div>
        </template>
      </el-table-column>
      <el-table-column label="货物名称" width="150">
        <template #default="scope">
          <div style="display: flex; align-items: center; width: 100%; height: 100%">
            <span v-if="scope.row.editStatus">{{ scope.row.goodName }}</span>
            <el-input v-if="scope.row.editInputStatus" v-model="scope.row.goodName" />
          </div>
        </template>
      </el-table-column>
      <el-table-column label="日期时间" width="150">
        <template #default="scope">
          <div style="display: flex; align-items: center; width: 100%; height: 100%">
            <span v-if="scope.row.editStatus">{{ scope.row.createTime }}</span>
            <el-input v-if="scope.row.editInputStatus" v-model="scope.row.createTime" />
          </div>
        </template>
      </el-table-column>
      <el-table-column label="Operations">
        <template #default="scope">
          <el-button size="small" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button size="small" type="danger" @click="handleDelete(scope.$index, scope.row)"
            >删除</el-button
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
    (e: 'delete-row', data: {}): void;
    (e: 'update-row', data: {}): void;
  }>();
  const props = withDefaults(defineProps<Props>(), {
    tableList: () => [],
  });

  const handleEdit = (index: number, row: rowType) => {
    emit('update-row', { data: row });
  };
  const handleDelete = (index: number, row: rowType) => {
    emit('delete-row', { data: row });
  };
</script>
<style lang="less" scoped>
  .ts-table-main {
    width: 100%;
    height: 100%;
    overflow: auto;
    :deep(.el-input__wrapper) {
      box-shadow: 0 0 0 0px var(--el-input-border-color, var(--el-border-color)) inset;
      cursor: default;
      background-color: initial;
      .el-input__inner {
        cursor: default !important;
      }
    }
    span {
      overflow: hidden;
      white-space: nowrap;
      text-overflow: ellipsis;
    }
  }
</style>
