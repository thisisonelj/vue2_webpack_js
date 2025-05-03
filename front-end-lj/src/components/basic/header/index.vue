<template>
  <div class="header-container">
    <div v-for="(item, index) in displayTypes" :key="index">
      {{ item.content }}
    </div>
  </div>
</template>
<script setup lang="ts">
import { SETTING } from '@/enums/display-setting'
import { ref, reactive } from 'vue'
import buttonInfo from '../button.vue'
type displayTypes = {
  type: SETTING
  id?: String
  content?: String
  [props: string]: any
}

const displayGroups = defineProps<{
  displayTypes: Array<displayTypes>
}>()
</script>
<style lang="scss" scoped>
.header-container {
  padding: 20px;
  max-height: 10vh;
  display: flex;
  gap: 10px;
}
</style>
