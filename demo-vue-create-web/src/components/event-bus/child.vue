<template>
    <div>
        <Input v-model="childValue" placeholder="Enter something..." style="width: 300px" />
    </div>
</template>
<script>
export default {
  data () {
    return {
      childValue: ''
    }
  },
  mounted () {
    let _that = this
    this.$bus.$on('child-emit', function (data) {
      _that.childValue = data.attr
    })
  },
  created () {

  },
  beforeDestroy () {
    this.$bus.$off('child-emit')
  }
}
</script>
<style lang="less" scoped>

</style>
