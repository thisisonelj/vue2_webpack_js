<template>
  <div class="header-container">
    <div class="top">
      <div v-for="(item, index) in displayTypes" :key="index">
        <div v-if="item.id == SETTING.BUTTON">
          <button-info :origin-data-info="item"></button-info>
        </div>
      </div>
    </div>
    <el-divider style="margin: 0" />
  </div>
</template>
<script setup lang="ts">
import { SETTING } from '@/enums/display-setting'
import { ref, reactive } from 'vue'
import buttonInfo from '../button.vue'
const displayGroups = defineProps<{
  displayTypes: Array<any>
}>()
</script>
<style lang="scss" scoped>
.header-container {
  .top {
    padding: 20px;
    display: flex;
    justify-content: space-around;
  }
}
</style>
