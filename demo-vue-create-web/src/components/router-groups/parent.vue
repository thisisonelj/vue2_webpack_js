<template>
    <div>
      <i-switch v-model="switchStatus" @on-change="change" />
      <vuex-son class="form-space"></vuex-son>
    </div>
</template>
<script>
import Son from './son.vue'
export default {
  name: 'parent',
  data () {
    return {
      msg: '这是父页面',
      switchStatus: false
    }
  },
  components: {
    vuexSon: Son
  },
  methods: {
    change () {
      if (this.switchStatus) {
        this.$store.commit('changeSex', { sex: 'girl' })
      } else {
        this.$store.commit('changeSex', { sex: 'boy' })
      }
    }
  }
}
</script>
<style lang="less" scoped>
.form-space{
  margin-top:20px;
}
</style>
