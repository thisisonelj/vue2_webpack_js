<template>
  <div>
    <Select v-model="selectValue" style="width:100%">
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
      selectValue: 'big',
      list: [
        { value: 'big', label: '大' },
        { value: 'normal', label: '中' },
        { value: 'small', label: '小' }
      ]
    }
  },
  components: {
    vuexGrandSon: grandSon
  }
}
</script>
<style lang="less" scoped>
.form-space{
  margin-top:20px;
}
</style>
