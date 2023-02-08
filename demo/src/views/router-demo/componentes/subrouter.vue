<template>
  <div>
    <h1>subrouter</h1>
    {{ $route.params.id }}
    <router-view></router-view>
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
