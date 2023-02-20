<template>
    <div>
      <Radio v-model="single">Radio</Radio>
    </div>
</template>
<script>
export default {
  name: 'brotherSon',
  data () {
    return {
      msg: '兄弟孩子页面',
      single: false
    }
  }
}
</script>
<style lang="less" scoped>

</style>
