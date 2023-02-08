<template>
  <div>
    <button @click="routerPush" size="large">This is a demo1</button>
  </div>
</template>
<script>
export default {
  data () {
    return {
      name: 'liu'
    }
  },
  methods: {
    routerPush () {
      this.$router.push({ path: 'foo/three', query: { plan: 'private' } }).then((params) => {
        console.log(params)
      })
    }
  }
}
</script>
<style scoped></style>
