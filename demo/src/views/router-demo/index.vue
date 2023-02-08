<template>
  <div>
    <div>
      <h1>hello Router</h1>
      <router-view></router-view>
    </div>
    <p>
      <router-link to="/foo/foo">Go to Foo</router-link>
      <router-link to="/bar/bar">Go to Bar</router-link>
    </p>

  </div>
</template>
<script>
export default {
  data () {
    return {}
  }
}
</script>
<style scoped></style>
