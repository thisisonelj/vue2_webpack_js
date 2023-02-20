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
      msg: '兄弟孩子页面'
    }
  },
  computed: {
    single: function () {
      return this.$store.state.person.sex
    }
  }

}
</script>
<style lang="less" scoped>

</style>
