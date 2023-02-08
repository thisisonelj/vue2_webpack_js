<template>
    <div>
        <button @click="queryName" size="large">This is a demo1</button>
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
    queryName () {
      alert(this.name)
      return this.name
    }
  }
}
</script>
<style scoped>

</style>
