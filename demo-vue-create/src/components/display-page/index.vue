<template>
  <div>
    {{ msg }}
  </div>
</template>

<script>
export default {
  name: 'displayPage',
  props: {
    msg: {
      type: String,
      default: '这是主页'
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
