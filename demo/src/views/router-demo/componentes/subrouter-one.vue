<template>
  <div>
    <h1>subrouter-one</h1>
    {{ $route.params.id }}
  </div>
</template>
<script>
export default {
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
