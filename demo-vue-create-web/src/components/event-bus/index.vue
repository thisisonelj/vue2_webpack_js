<template>
  <div class="flex-main">
    <child></child>
    <brother class="flex-brother"></brother>
  </div>
</template>
<script>
import child from './child.vue'
import brother from './brother.vue'
export default {
  data () {
    return {}
  },
  components: {
    child: child,
    brother: brother
  },
  mounted () {
    this.$bus.$emit('brother-emit', { attr: 'brother' })
    this.$bus.$emit('child-emit', { attr: 'child' })
  },
  created () {

  }
}
</script>
<style lang="less" scoped>
.flex-main {
    height: 30%;
    width: 30%;
    margin: auto;
    position: absolute;
    left: 30%;
    right: 20%;
    bottom: 20%;
    top: 40%;
  .flex-brother {
    margin-top:10%
  }
}
</style>
