<template>
    <div>
      <Rate v-model="value" />
    </div>
</template>
<script>
export default {
  name: 'grandSon',
  data () {
    return {
      msg: '孙子页面',
      value: 1
    }
  },
  watch: {
    value: {
      handler: function (val) {
        this.$store.commit('increment', { amount: val })
      }
    }
  }
}
</script>
<style lang="less" scoped>

</style>
