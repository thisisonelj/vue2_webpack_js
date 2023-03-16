<template>
  <div class="vue3-slot">
    <div class="content">
      <slot name="content" :slotList="List"></slot>
    </div>
  </div>
</template>
<script>
export default {}
</script>
<script setup>
import { ref, computed, watch, onMounted, defineProps, defineEmits } from 'vue'
let List = ref([{index:0, value: 'liu' }, { index:1,value: 'liu1' }, { index:2,value: 'liu2' }])
</script>
<style scoped>
.vue3-slot {
  padding: 20px;
  height: 20%;
}
.content {
  background-color: black;
  height: 100%;
  display: inline-flex;
  justify-content: space-evenly;
}
</style>
