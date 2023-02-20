<template>
  <div>
    <Select v-model="selectValue" style="width:100%" @on-change="changeData">
        <Option v-for="item in list" :value="item.value" :key="item.value">{{ item.label }}</Option>
    </Select>
    <vuex-grand-son class="form-space"></vuex-grand-son>
  </div>
</template>
<script>
import grandSon from './grand-son.vue'
export default {
  name: 'son',
  data () {
    return {
      msg: '儿子页面',
      selectValue: 'big'
    }
  },
  components: {
    vuexGrandSon: grandSon
  },
  computed: {
    list: function () {
      return this.$store.state.list
    }
  },
  methods: {
    changeData (val) {
      this.$store.commit('changeList', { value: val })
    }
  }
}
</script>
<style lang="less" scoped>
.form-space{
  margin-top:20px;
}
</style>
