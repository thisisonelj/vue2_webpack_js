<template>
    <div>
        <Button type="primary" @click="count++" >+</Button>
        <Input v-model="count"/>
    </div>
</template>
<script>
export default {
  props: {
    id: {
      type: Number,
      default: 0
    }
  },
  name: 'leftComponent',
  data () {
    return {
      count: 0
    }
  }
}
</script>
<style lang="less" scoped>
@deep:~ ">>>";
@{deep} .ivu-input-wrapper{
    transform: translate(-40%, 300%);
}
</style>
