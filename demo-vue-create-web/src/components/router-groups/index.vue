<template>
    <div>
      {{msg}}
      <parent></parent>
      <parent-son></parent-son>
      <grand-son></grand-son>
      <parent-brother></parent-brother>
      <brother-son></brother-son>
    </div>
</template>
<script>
import Parent from './parent.vue'
import Son from './son.vue'
import grandSon from './grand-son.vue'
import parentBrother from './parent-brother.vue'
import brotherSon from './brother-son.vue'
export default {
  name: 'index',
  components: {
    parent: Parent,
    parentSon: Son,
    grandSon: grandSon,
    parentBrother: parentBrother,
    brotherSon: brotherSon
  },
  data () {
    return {
      msg: '这是vuex主页面'
    }
  }
}
</script>
<style lang="less" scoped>

</style>
