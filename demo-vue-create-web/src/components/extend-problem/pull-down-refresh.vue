<template>
  <div class="pull-down-content">
    <div class="center-content">
      <span class="main"
        >下拉刷新<Icon
          type="ios-arrow-down"
          class="pull-down-button"
          @click="pullDownEvent"
          v-if="pullDownStatus"
      />
      <Icon
          type="ios-arrow-up"
          class="pull-down-button"
          @click="pullUpEvent"
          v-if="pullUpStatus"
      /></span>
      <div class="display-content"></div>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      displayElement: null,
      pullDownStatus: true,
      pullUpStatus: false
    }
  },
  methods: {
    initEvent () {
      let displayDom = document.getElementsByClassName('display-content')
      this.displayElement = displayDom
      displayDom[0].style.visibility = 'hidden'
      displayDom[0].style.opacity = 0
      displayDom[0].style.transition = '1s 0.5s ease-out'
    },
    pullDownEvent () {
      this.displayElement[0].style.visibility = 'visible'
      this.displayElement[0].style.opacity = 1
      this.pullDownStatus = false
      this.pullUpStatus = true
    },
    pullUpEvent () {
      this.displayElement[0].style.visibility = 'hidden'
      this.displayElement[0].style.opacity = 0
      this.pullDownStatus = true
      this.pullUpStatus = false
    }
  },
  mounted () {
    this.initEvent()
  }
}
</script>
<style lang="less" scoped>
.pull-down-content {
  height: 100%;
  width: 100%;
  display: inline-flex;
  justify-content: center;
  align-items: center;
  font-size: 20px;
  .center-content {
    height: 50%;
    width: 40%;
    background-color: black;
    position: relative;
    .main {
      position: absolute;
      top: 20%;
      left: 40%;
      z-index: 1;
      .pull-down-button {
        cursor: pointer;
      }
    }
    .display-content {
      width: 20%;
      height: 50%;
      background-color: aqua;
      position: absolute;
      top: 30%;
      left: 40%;
    }
    .hidden-content {
      width: 20%;
      height: 50%;
      background-color: aqua;
      position: absolute;
      top: 30%;
      left: 40%;
    }
  }
}
</style>
