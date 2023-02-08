<template>
    <div>
        <button @click="queryId" size="large">This is a demo2</button>
    </div>
</template>
<script>
export default {
  data () {
    return {
      id: 'one'

    }
  },
  methods: {
    queryId () {
      alert(this.id)
      return this.id
    }
  }
}
</script>
<style scoped>

</style>
