<template>
  <el-dialog
    v-model="dialogFormVisible"
    :title="formConfigList.modalTitle"
    width="420"
    class="dialog-container"
    :show-close="false"
  >
    <el-form :model="formData" class="dialog-form">
      <el-form-item
        v-for="(item, index) in formConfigList.modalForm"
        :label="item.label"
        :label-width="item.width"
        :key="index"
      >
        <el-input v-model="formData[item.key]" />
      </el-form-item>
    </el-form>
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="cancleInfo">取消</el-button>
        <el-button type="primary" @click="confirmInfo"> 确认 </el-button>
      </div>
    </template>
  </el-dialog>
</template>
<script setup lang="ts">
import { reactive, ref, watch } from 'vue'
import xeUtils from 'xe-utils'
interface formTemplate {
  goodId: String //商品标识
  goodName: String //商品名称
  price: Number //商品价格
  createTime: String //商品创建时间
  [props: string]: any
}
type formSettingTemplate = {
  key: String
  label: String
  width: Number
  [props: string]: any
}
type formOriginData = {
  modalStatus: Boolean
  modalTitle: String
  modalForm: Array<formSettingTemplate>
}
const props = defineProps<{
  formConfigList: formOriginData
}>()
const emits = defineEmits<{
  (e: 'cancel-modal'): any
  (e: 'confirm-modal'): any
}>()
let formData = reactive<formTemplate>({
  goodId: '',
  goodName: '',
  price: 0,
  createTime: xeUtils.toDateString(new Date(), 'yyyy-MM-dd'),
})
let dialogFormVisible = ref(false)
function cancleInfo() {
  dialogFormVisible.value = false
  emits('cancel-modal')
}
function confirmInfo() {
  dialogFormVisible.value = false
  emits('confirm-modal')
}
watch(
  () => props.formConfigList.modalStatus,
  (val: boolean) => {
    dialogFormVisible.value = val
  },
)
defineExpose({
  formData,
})
</script>
<style lang="scss" scoped>
.dialog-container {
  .dialog-form {
  }
  .dialog-footer {
  }
}
</style>
