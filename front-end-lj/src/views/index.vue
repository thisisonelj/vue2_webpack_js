<template>
  <div class="container">
    <common-header :display-types="displayGroups"></common-header>
    <div class="center">
      <left-tree class="left-tree"></left-tree>
      <el-divider direction="vertical" class="divider-info" />
      <right-table class="right-table"></right-table>
    </div>
    <common-footer></common-footer>
  </div>
</template>
<script setup lang="ts">
import { ref, reactive } from 'vue'
import commonHeader from '@/components/basic/header/index.vue'
import { SETTING } from '@/enums/display-setting'
import { buttonSize, buttonType } from '@/enums/button'
import commonFooter from '@/components/basic/footer/index.vue'
import leftTree from '@/components/general/tree.vue'
import rightTable from '@/components/general/table.vue'
let displayGroups = reactive([
  {
    id: SETTING.BUTTON,
    size: buttonSize.DEFAULT,
    type: buttonType.PRIMARY,
    plain: false,
    // color: '#626aef',
    text: false,
    content: '按钮',
  },
  {
    id: SETTING.BUTTON,
    size: buttonSize.DEFAULT,
    type: buttonType.INFO,
    plain: true,
    // color: '#626aef',
    text: true,
    content: '按钮1',
    disable: true,
  },
  {
    id: SETTING.BUTTON,
    size: buttonSize.DEFAULT,
    type: buttonType.SUCCESS,
    plain: false,
    // color: '#626aef',
    text: false,
    content: '按钮2',
  },
  {
    id: SETTING.BUTTON,
    size: buttonSize.DEFAULT,
    type: buttonType.WARNING,
    plain: false,
    // color: '#626aef',
    text: true,
    content: '按钮3',
  },
  {
    id: SETTING.BUTTON,
    size: buttonSize.DEFAULT,
    type: buttonType.DANGER,
    plain: true,
    // color: '#626aef',
    text: true,
    content: '按钮4',
    disable: true,
  },
])
</script>
<style lang="scss" scoped>
.container {
  height: 100vh;
  overflow: hidden;
  .center {
    display: flex;
    .left-tree {
      flex: 1;
    }
    .divider-info {
      height: calc(75vh - 10px);
      margin: 0;
    }
    .right-table {
      flex: 3;
    }
  }
}
</style>
