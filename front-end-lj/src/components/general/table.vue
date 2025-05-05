<template>
  <div class="table-container">
    <el-table
      :data="tableData"
      style="width: 100%"
      highlight-current-row
      :current-row-key="'index'"
      :row-key="'index'"
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
            <el-button type="primary" size="small" @click="editInfo(scope.row)">{{
              $t('editText')
            }}</el-button>
            <el-button type="danger" size="small" @click="deleteInfo(scope.row)">{{
              $t('deleteText')
            }}</el-button>
          </div>
        </template>
      </el-table-column>
    </el-table>
    <modal-info
      :form-config-list="formConfigList"
      @cancel-modal="cancelModal"
      @confirm-modal="confirmModal"
      ref="modalFormRef"
    ></modal-info>
  </div>
</template>
<script setup lang="ts">
import { ref, useTemplateRef, onMounted } from 'vue'
import modalInfo from '@/components/basic/modal.vue'
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
const formConfigList = ref({
  modalStatus: false,
  modalTitle: '编辑信息',
  modalForm: [
    {
      key: 'goodId',
      label: '商品标识',
      width: 80,
    },
    {
      key: 'goodName',
      label: '商品名称',
      width: 80,
    },
    {
      key: 'price',
      label: '商品价格',
      width: 80,
    },
    {
      key: 'createTime',
      label: '创建时间',
      width: 80,
    },
  ],
})
const modalFormInfo: any = useTemplateRef('modalFormRef')
const emits = defineEmits<{
  (e: 'edit-change', value: tableTemplateData): any
  (e: 'delete-change', value: tableTemplateData): any
}>()
function cancelModal() {
  formConfigList.value.modalStatus = false
}

function confirmModal() {
  emits('edit-change', modalFormInfo.value.formData)
  formConfigList.value.modalStatus = false
}
function editInfo(row: tableTemplateData) {
  console.log(row)
  modalFormInfo.value.formData.goodId = row.goodId
  modalFormInfo.value.formData.goodName = row.goodName
  modalFormInfo.value.formData.price = row.price
  modalFormInfo.value.formData.createTime = row.createTime
  formConfigList.value.modalStatus = true
}
function deleteInfo(row: tableTemplateData) {
  console.log(row)
  emits('delete-change', row)
}
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
