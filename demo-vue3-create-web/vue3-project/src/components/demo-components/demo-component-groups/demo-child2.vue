<template>
  <div class="vue3-top">
    <Button type="primary" @click="displayModal">显示</Button>
    <Input v-model="inputValue" placeholder="Enter something..." style="width:30%"/>
    <demo-child1 :modal-status="modalStatus" @cancel-operate="cancelListener" @confirm-operate="confirmListener"></demo-child1>
    <demo-child3 class="vue3-table" :table-data="formData"></demo-child3>
  </div>
</template>
<script setup>
import { ref, defineProps, defineEmits } from 'vue'
import demoChild1 from './demo-child1.vue'
import demoChild3 from './demo-child3.vue';
let displayModal = () => {modalStatus.value=true}
let inputValue = ref('')
let modalStatus = ref(false)
let formData=ref([])
let cancelListener=((event) => {
    modalStatus.value=event.status
})
let confirmListener = ((event) => {
    formData.value=[event.formItem.value]
    modalStatus.value = event.status
})
</script>
<style scoped>
.vue3-top {
  width: 100%;
  display: inline-flex;
  justify-content: space-around;
  align-items: flex-start;
  flex-flow: row wrap;
  padding: 20px;
}
.vue3-table{
    width: 100%;
    margin-top:10%;
}
</style>
