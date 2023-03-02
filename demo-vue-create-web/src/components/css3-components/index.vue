<template>
  <div class="css3-main">
    <div class="echarts-border">
      <div class="css3-round"></div>
      <div class="css3-round-half"></div>
      <div class="css3-round-half-half"></div>
      <div class="css3-round-oval"></div>
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
.css3-main {
  height: 100%;
  width: 100%;
  display: inline-flex;
  justify-content: center;
  align-items: center;
  .echarts-border {
    border: 1px solid blue;
    width: 50%;
    height: 50%;
    display: inline-flex;
    justify-content: space-between;
    flex-wrap: wrap;
    .css3-round {
      border: 1px solid black;
      width: 150px;
      height: 150px;
      border-radius: 100%;
    }
    .css3-round-half {
      border: 1px solid black;
      width: 300px;
      height: 150px;
      border-top-left-radius: 50% 100%;
      border-top-right-radius: 50% 100%;
    }
    .css3-round-half-half {
      border: 1px solid black;
      width: 150px;
      height: 150px;
      border-top-left-radius: 100% 100%;
    }
    .css3-round-oval {
      border: 1px solid black;
      width: 200px;
      height: 100px;
      border-radius: 100%;
    }
  }
}
</style>
