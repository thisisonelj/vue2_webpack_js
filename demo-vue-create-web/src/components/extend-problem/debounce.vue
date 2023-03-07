<template>
  <div class="debounce-main">
    <div class="debounce-content">
      <Input
        class="debounce-input"
        v-model="inputValue"
        style="width: 30%"
      ></Input>
      <Input
        class="debounce-input1"
        v-model="inputValue1"
        style="width: 30%"
      ></Input>
      <div class="debounce-info">
        <span>{{ msg }}</span>
      </div>
      <div class="debounce-info1">
        <span>{{ msg1 }}</span>
      </div>
    </div>
  </div>
</template>
<script>
import extendApi from '@/utils/extend-info'
export default {
  data () {
    return {
      msg: '',
      inputValue: '',
      inputValue1: '',
      msg1: ''
    }
  },
  mounted () {
    let inputDom = document.querySelector('.debounce-input')
    inputDom.onkeyup = this._debounce(this.confirmContent, 1000)
    let inputDom1 = document.querySelector('.debounce-input1')
    inputDom1.onkeyup = this._throttle(this.confirmContent1, 1000)
  },
  methods: {
    _throttle (fn, delay) {
      let timer // 节流
      let that = this
      return function () {
        if (!timer) {
          fn.apply(that, arguments)
          timer = setTimeout(() => {
            clearTimeout(timer)
            timer = null
          }, delay)
        }
      }
    },

    _debounce (fn, delay) {
      let timer // 声明计时器  防抖
      let that = this
      return function () {
        if (!that.inputValue) {
          that.msg = ''
        } else {
          clearTimeout(timer)
          timer = setTimeout(() => {
            fn.apply(this, arguments)
          }, delay)
        }
      }
    },
    confirmContent () {
      extendApi.debounce({}).then((res) => {
        this.msg = res
      })
    },
    confirmContent1 () {
      extendApi.debounce({}).then((res) => {
        this.msg1 = res
      })
    }
  }
}
</script>
<style lang="less" scoped>
.debounce-main {
  height: 100%;
  width: 100%;
  .debounce-content {
    background-color: black;
    width: 40%;
    height: 50%;
    position: absolute;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    margin: auto;
    display: inline-flex;
    justify-content: space-evenly;
    align-items: center;
    flex-direction: column;
    .debounce-info {
      background-color: green;
      width: 15%;
      height: 20%;
      display: inline-flex;
      justify-content: center;
      align-items: center;
    }
    .debounce-info1 {
      background-color: blue;
      width: 15%;
      height: 20%;
      display: inline-flex;
      justify-content: center;
      align-items: center;
    }
  }
}
</style>
