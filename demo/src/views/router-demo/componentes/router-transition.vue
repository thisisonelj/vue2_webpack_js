<template>
  <div>
    <transition name="fade">
      <h1>routertransition</h1>
    </transition>
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
  }
}
</script>
<style scoped></style>
