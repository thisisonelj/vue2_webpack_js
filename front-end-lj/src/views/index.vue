<template>
  <div class="container">
    <common-header :display-types="displayGroups"></common-header>
  </div>
</template>
<script setup lang="ts">
import { ref, reactive } from 'vue'
import commonHeader from '@/components/basic/header/index.vue'
import { SETTING } from '@/enums/display-setting'
let displayGroups = reactive([
  {
    type: SETTING.BUTTON,
    id: 'button',
    content: '这是按钮展示内容',
  },
  {
    type: SETTING.FORM,
    id: 'form',
    content: '这是表单展示内容',
  },
  {
    type: SETTING.ICON,
    id: 'icon',
    content: '这是图标展示内容',
  },
])
</script>
<style lang="scss" scoped>
.container {
}
</style>
