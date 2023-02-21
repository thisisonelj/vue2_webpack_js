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
    <Card class="vuex-card">
      <div class="vuex-card-flex">
        <InputNumber
          v-model="validValue"
          style="width: 20%"
          @on-change="change"
        ></InputNumber>
        <List
          header="Header"
          footer="Footer"
          border
          size="large"
          style="width: 30%"
        >
          <ListItem v-for="item in displayList" :key="item.index">
            {{ item.name }} : {{ item.age }}
          </ListItem>
        </List>
      </div>
    </Card>
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
      splitIndex: 0.5,
      validValue: 0
    }
  },
  computed: {
    displayList: function () {
      return this.$store.state.displayList
    }
  },
  created () {},
  methods: {
    async change (val) {
      this.$store.dispatch('changedisPlayList', { size: val })
    }
  }
}
</script>
<style lang="less" scoped>
@border-attr:1px solid blue;
.layout-base {
  height: 50%;
  padding: 10px;
}
.layout-base-child {
  height: 100%;
}
#middle-layout {
  display: flex;
  justify-content: center;
  align-items: center;
}
#left-layout {
  display: flex;
  justify-content: space-around;
}
.vuex-main {
  height: 100%;
  .vuex-split {
    .layout-base();
    .vuex-left-split {
      .layout-base-child();
      #middle-layout();
    }
    .vuex-right-split {
      .layout-base-child();
      //padding-left: 20px;
      #middle-layout();
    }
  }
  .vuex-card {
    .layout-base();
    .vuex-card-flex {
      #left-layout();
    }
  }
}
</style>
