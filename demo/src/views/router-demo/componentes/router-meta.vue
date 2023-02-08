<template>
  <div>
    <h1>routermeta</h1>
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
