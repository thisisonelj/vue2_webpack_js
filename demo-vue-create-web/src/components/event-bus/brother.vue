<template>
  <div>
    <Input
      v-model="brotherValue"
      placeholder="Enter something..."
      style="width: 300px"
    />
  </div>
</template>
<script>
export default {
  data () {
    return {
      brotherValue: ''
    }
  },
  mounted () {
    this.$bus.$on('brother-emit', (data) => {
      this.brotherValue = data.attr
    }
    )
  },
  beforeDestroy () {
    this.$bus.$off('brother-emit')
  }
}
</script>
<style lang="less" scoped></style>
