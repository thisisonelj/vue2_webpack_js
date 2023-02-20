<template>
  <div>
    <Input v-model="value" placeholder="Enter something..."  style="width:50%"/>
    <vuex-brother-son class="form-space"></vuex-brother-son>
  </div>
</template>
<script>
import brotherSon from './brother-son.vue'
export default {
  name: 'parentBrother',
  data () {
    return {
      msg: '父亲兄弟页面',
      value: ''
    }
  },
  components: {
    vuexBrotherSon: brotherSon
  }
}
</script>
<style lang="less" scoped>
.form-space{
  margin-top:20px;
}
</style>
