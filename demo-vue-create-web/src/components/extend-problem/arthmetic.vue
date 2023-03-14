<template>
    <div>这是判断算法内容</div>
</template>
<script>
export default {
  data () {
    return {

    }
  },
  methods: {
    fib (n) {
      if (n <= 0) { return 0 }
      if (n === 1) { return 1 }
      return this.fib(n - 1) + this.fib(n - 2)
    }
  },
  created () {
    console.log(this.fib(6))
  }
}
</script>
<style lang="less" scoped>

</style>
