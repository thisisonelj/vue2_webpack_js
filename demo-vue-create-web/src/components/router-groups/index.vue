<template>
  <div class="vuex-main">
    <div class="vuex-split">
      <Split v-model="splitIndex">
        <div slot="left" class="vuex-left-split">
          <parent></parent>
        </div>
        <div slot="right" class="vuex-right-split">
          <parent-brother></parent-brother>
        </div>
      </Split>
    </div>
  </div>
</template>
<script>
import Parent from './parent.vue'
import parentBrother from './parent-brother.vue'
export default {
  name: 'index',
  components: {
    parent: Parent,
    parentBrother: parentBrother
  },
  data () {
    return {
      msg: '这是vuex主页面',
      splitIndex: 0.5
    }
  }
}
</script>
<style lang="less" scoped>
@border-attr:1px solid blue;
.layout-base {
  height: 100%;
  padding: 10px;
}
.layout-base-child {
  height: 100%;
}
.vuex-main {
  height: 100%;
  .vuex-split {
    .layout-base();
    .vuex-left-split {
      .layout-base-child();

    }
    .vuex-right-split {
      .layout-base-child();
      padding-left:20px;
    }
  }
}
</style>
