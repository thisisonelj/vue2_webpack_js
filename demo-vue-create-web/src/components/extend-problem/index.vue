<template>
  <div class="lazy-loading">
    <div class="lazy-table" @scroll="scollRefresh">
      <div v-for="item in List" :key="item.id" class="lazy-item">
          <span>{{ item.name }}</span><span style="margin-left:10%">{{ item.age }}</span>
      </div>
      <div class="lazy-blank"></div>
    </div>
  </div>
</template>
<script>
import lazyData from './lazy-data'
export default {
  data () {
    return {
      size: 10, // 每次滚动监听渲染数据
      pageMax: 0, // 滚动加载总共渲染多少页
      signDom: '判断滚动监听的每页数据的刷新标识',
      currentPage: 1
    }
  },
  created () {

  },
  mounted () {
    this.$nextTick(() => {
      let containHeight = document.querySelector('.lazy-table').clientHeight
      this.size = containHeight / 37.5
      this.pageMax = Math.ceil(lazyData / this.size)
    })
  },
  methods: {
    scollRefresh () {
      if (this.currentPage > this.pageMax) return
      let containBoundTop = document.querySelector('.lazy-blank').getBoundingClientRect().top
      let blankBoundTop = document.querySelector('.lazy-table').getBoundingClientRect().bottom
      // let containBoundTop = document.querySelector('.lazy-table').clientHeight
      // let blankBoundTop = document.querySelector('.lazy-blank').getBoundingClientRect().top
      if (containBoundTop === blankBoundTop) {
        this.currentPage++
      }
    }
  },
  computed: {
    List () {
      return lazyData.slice(0, this.currentPage * this.size)
    }
  }
}
</script>
<style lang="less" scoped>
.lazy-loading {
  height: 100%;
  width: 100%;
  display: inline-flex;
  justify-content: center;
  align-items: center;
  .lazy-table {
    width: 40%;
    height: 375px;
    background-color: black;
    overflow: auto;
    .lazy-item {
      width: 50%;
      height: 37.5px;
      border: 1px dashed blue;
      text-align: center;
      line-height: 37.5px;
    }
    .lazy-blank{
      // width: 50%;
      // height: 37.5px;
      // border: 1px dashed red;
      // text-align: center;
      // line-height: 37.5px;
      // visibility: hidden;
    }
  }
}
</style>
