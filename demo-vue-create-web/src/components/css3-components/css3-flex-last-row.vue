<template>
  <div class="flex-last-row">
    <div class="row-main">
      <div class="one"></div>
      <div class="one"></div>
      <div class="one"></div>
      <div class="one"></div>
      <div class="one"></div>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {}
  }
}
</script>
<style lang="less" scoped>
.flex-last-row {
  height: 100%;
  width: 100%;
  display: inline-flex;
  justify-content: center;
  align-items: center;
  .row-main {
    width: 40%;
    height: 50%;
    background-color: black;
    display: inline-flex;
    justify-content: space-between;
    flex-wrap: wrap;
    .one{
      width: 33%;
      height: 33%;
      border: 2px dashed blue;
    }
    & :last-child{
      margin-right: calc(33% + 4px);
    }
  }
}
</style>
