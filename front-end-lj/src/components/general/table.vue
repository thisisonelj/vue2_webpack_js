<template>
  <div class="table-container">
    <el-table
      :data="tableData"
      style="width: 100%"
      highlight-current-row
      :current-row-key="'goodId'"
      :row-key="'goodId'"
      :empty-text="'暂无数据'"
      border
      class="table"
    >
      <el-table-column
        :label="tableLabelData?.indexName"
        show-overflow-tooltip
        align="center"
        :type="'index'"
        :width="100"
      >
        <template #default="{ $index }">
          {{ $index }}
        </template>
      </el-table-column>
      <el-table-column :label="tableLabelData?.googIdName" show-overflow-tooltip align="center">
        <template #default="scope">
          {{ scope.row.goodId }}
        </template>
      </el-table-column>
      <el-table-column :label="tableLabelData?.goodName" show-overflow-tooltip align="center">
        <template #default="scope">
          {{ scope.row.goodName }}
        </template>
      </el-table-column>
      <el-table-column :label="tableLabelData?.priceName" show-overflow-tooltip align="center">
        <template #default="scope">
          {{ scope.row.price }}
        </template>
      </el-table-column>
      <el-table-column :label="tableLabelData?.createTimeName" show-overflow-tooltip align="center">
        <template #default="scope">
          {{ scope.row.createTime }}
        </template>
      </el-table-column>
      <el-table-column :label="tableLabelData?.btnGroupsName" show-overflow-tooltip align="center">
        <template #default="scope">
          <div class="hander-table-info">
            <el-button type="primary" size="small" @click="editInfo(scope.row)">编辑</el-button>
            <el-button type="danger" size="small" @click="deleteInfo(scope.row)">删除</el-button>
          </div>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>
<script setup lang="ts">
import { ref } from 'vue'
interface tableLabelData {
  indexName: String
  googIdName: String
  goodName: String
  priceName: String
  createTimeName: String
  btnGroupsName: String
  [props: string]: any
}
type tableTemplateData = {
  goodId: String //商品标识
  goodName: String //商品名称
  price: Number //商品价格
  createTime: String //商品创建时间
  [props: string]: any
}
const props = defineProps<{
  tableData: Array<tableTemplateData>
}>()
const tableLabelData = ref<tableLabelData>({
  indexName: '序号',
  googIdName: '商品标识',
  goodName: '商品名称',
  priceName: '商品价格',
  createTimeName: '商品创建时间',
  btnGroupsName: '操作',
})
function editInfo(row: tableTemplateData) {}
function deleteInfo(row: tableTemplateData) {}
</script>
<style lang="scss" scoped>
.table-container {
  padding: 10px;
  .table {
    height: 100%;
    overflow-y: auto;
    .hander-table-info {
      align-items: center;
      justify-content: space-around;
      padding: 5px;
      display: flex;
    }
  }
}
</style>
