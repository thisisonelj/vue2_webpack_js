<template>
  <div>
    <Input
      :value="modelValue"
      placeholder="Enter something..."
      style="width: 30%"
      @input="inputEvent"
    />
    <Input
      v-model="injectValue"
      placeholder="Enter something..."
      style="width: 30%;margin-left:10%"
    />
    <Table border :columns="columns" :data="tableData" style="margin-top: 5%;height:40%"></Table>
  </div>
</template>
<script setup>
import { ref, defineProps, defineEmits, computed, onMounted, provide, inject } from 'vue'
let { injectValue, modifyData } =inject('message')
let emit = defineEmits({
  'update:modelValue': (param) => {
    return true
  }
})
let inputEvent = (event) => {
  if (props.modelModifiers.capitalize) {
    //如果v-model有修饰符
    let value = event.target.value.toUpperCase()
    emit('update:modelValue', value)
  } else {
    emit('update:modelValue', event.target.value)
  }
}
let props = defineProps({
  tableData: {
    type: Object,
    default: () => {
      return []
    }
  },
  modelValue: {
    type: String,
    default: ''
  },
  modelModifiers: { default: () => ({}) },
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
