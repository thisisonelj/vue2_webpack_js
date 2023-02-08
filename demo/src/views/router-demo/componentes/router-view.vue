<template>
  <div>
    <h1>routerview</h1>
    {{ $route.params.id }}
    <router-view name="one"></router-view>
    <router-view name="two"></router-view>
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
