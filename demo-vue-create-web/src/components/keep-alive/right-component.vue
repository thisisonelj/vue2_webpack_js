<template>
    <div>
        <Button  @click="count++">+</Button>
        <InputNumber v-model="count"></InputNumber>
    </div>
</template>
<script>
export default {
  name: 'rightComponent',
  data () {
    return {
      count: 0
    }
  }

}
</script>
<style lang="less" scoped>
@deep:~ ">>>";
@{deep} .ivu-input-number{
    transform: translate(-40%, 300%);
    width:100%
}
</style>
