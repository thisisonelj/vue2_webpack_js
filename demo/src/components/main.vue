<template>
  <div>
    <button
      @click="queryInfo"
      size="large"
      style="margin-bottom: 15px; color: rebeccapurple"
    >
      This is a demo3
    </button>
    <demo-one style="margin-bottom: 15px; color: blue"></demo-one>
    <demo-two style="margin-bottom: 15px; color: yellowgreen"></demo-two>
    <button @click="queryEs6Info" size="large" style="color: red">
      This is a demo4
    </button>
  </div>
</template>
<script>
import demoOne from './demo1.vue'
import demoTwo from './demo2.vue'
export default {
  components: {
    demoOne: demoOne,
    demoTwo: demoTwo
  },
  data () {
    return {
      info: 'this is a person'
    }
  },
  methods: {
    queryInfo () {
      this.$router.push('/demotrain')
    },
    queryEs6Info () {
      Array.from(this.info).forEach(element => {
        console.log(element)
      })
    }
  }
}
</script>
<style scoped></style>
