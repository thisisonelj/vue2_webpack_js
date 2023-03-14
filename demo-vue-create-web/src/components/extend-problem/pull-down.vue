<template>
  <div class="down-refresh-main">
    <p class="refreshText"></p>
    <ul class="refreshContainer">
      <li>111</li>
      <li>222</li>
      <li>333</li>
      <li>444</li>
      <li>555</li>
    </ul>
  </div>
</template>
<script>
export default {
  data () {
    return {}
  },
  methods: {
    touchListener () {
      let _element = document.querySelector('.refreshContainer')
      let _refreshText = document.querySelector('.refreshText')
      let _startPos = 0 // 初始的值
      let _transitionHeight = 0 // 移动的距离

      _element.addEventListener(
        'touchstart',
        function (e) {
          _startPos = e.touches[0].pageY // 记录初始位置
          _element.style.position = 'relative'
          _element.style.transition = 'transform 0s'
          console.log('下拉初始')
        },
        false
      )
      _element.addEventListener(
        'touchmove',
        function (e) {
          // e.touches[0].pageY 当前位置
          _transitionHeight = e.touches[0].pageY - _startPos // 记录差值

          if (_transitionHeight > 0 && _transitionHeight < 60) {
            _refreshText.innerText = '下拉刷新'
            _element.style.transform =
              'translateY(' + _transitionHeight + 'px)'

            if (_transitionHeight > 55) {
              _refreshText.innerText = '释放更新'
            }
          }
          console.log('下拉过程')
        },
        false
      )
      _element.addEventListener(
        'touchend',
        function (e) {
          _element.style.transition = 'transform 0.5s ease 1s'
          _element.style.transform = 'translateY(0px)'
          _refreshText.innerText = '更新中...'
          // todo...
          console.log('下拉结束')
        },
        false
      )
    }
  },
  mounted () {
    this.touchListener()
  }
}
</script>
<style lang="less" scoped>
.down-refresh-main {
  height: 100%;
  width: 100%;
  display: inline-flex;
  justify-content: center;
  align-items: center;
  flex-flow: column wrap;
  .refreshText {
    width: 20%;
    height: 20%;
    background-color: blanchedalmond
  }
  .refreshContainer {
    width: 20%;
    height: 20%;
    background-color: green;
  }
}
</style>
