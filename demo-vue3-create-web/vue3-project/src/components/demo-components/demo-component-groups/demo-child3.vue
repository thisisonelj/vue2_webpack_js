<template>
  <div>
    <Table border :columns="columns" :data="tableData"></Table>
  </div>
</template>
<script setup>
import { ref, defineProps, defineEmits, computed,onMounted } from 'vue'
let props = defineProps({
    tableData: {
        type: Object,
        default: () => {
            return []
        }
    }
})
let columns = ref([
  {
    title: '输入框',
    key: 'input'
  },
  {
    title: '选择框',
    key: 'select'
  },
  {
    title: '单选框',
    key: 'radio'
},
{
    title: '复选框',
    key: 'checkbox'
  },
  {
    title: '开关',
    key: 'switch'
  },
  {
    title: '日期',
    key: 'date'
},
{
    title: '时间',
    key: 'time'
  },
  {
    title: '滑块',
    key: 'slider'
  },
  {
    title: '文本框',
    key: 'textarea'
  }
])
</script>
<style scoped></style>
