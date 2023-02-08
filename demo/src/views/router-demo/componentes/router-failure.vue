<template>
  <div>
    <h1>routerfailure</h1>
    <el-button @click="gotoRouter"></el-button>
  </div>
</template>
<script>
export default {
  props: {
    info: {
      type: String,
      default: ''
    }
  },
  data () {
    return {}
  },
  watch: {
    $route (to, from) {
      console.log(to)
      console.log(from)
    }
  },
  methods: {
    /**
     路由导航故障判断
     */
    gotoRouter () {
      this.$router
        .push('/failure')
        .then(result => {
          console.log('路由导航正确')
        })
        .catch(err => {
          if (
            (this.$isNavigationFailure(err),
            this.$NavigationFailureType.redirected)
          ) {
            // 向用户显示一个小通知
            console.log('路由导航发生了故障')
          }
        })
    }
  }
}
</script>
<style scoped></style>
