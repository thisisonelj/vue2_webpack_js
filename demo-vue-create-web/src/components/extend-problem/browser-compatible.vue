<template>
  <div class="browser-container">
    <Split v-model="split">
      <div slot="left" class="left-pane">
        <Split v-model="split" mode="vertical">
          <div slot="top" class="left-left-pane">
            <Input style="flex: 1 1 40%; height: 20%" />
            <div class="overflow-contain">
              <span>{{ msg }}</span>
            </div>
            <div class="img-contain">
              <img src="../../assets/sea.jpg" class="img" />
            </div>
          </div>
          <div slot="bottom" class="left-right-pane">

          </div>
        </Split>
      </div>
      <div slot="right" class="right-pane">
        <Split v-model="split" mode="vertical">
          <div slot="top" class="right-left-pane"></div>
          <div slot="bottom" class="right-right-pane"></div>
        </Split>
      </div>
    </Split>
  </div>
</template>
<script>
export default {
  data () {
    return {
      split: 0.5,
      msg: '这是验证浏览器兼容性的不同对于overflow|这是验证浏览器兼容性的不同对于overflow|这是验证浏览器兼容性的不同对于overflow'
    }
  }
}
</script>
<style lang="less" scoped>
@img-url: "@/assets/sea.jpg";
.browser-container {
  height: 100%;
  width: 100%;
  .left-pane {
    height: 100%;
    width: 100%;
    .left-left-pane {
      height: 100%;
      width: 100%;
      padding: 10px;
      display: inline-flex;
      justify-content: flex-start;
      flex-wrap: wrap;
      align-content: flex-start;
      .overflow-contain {
        height: 40px;
        overflow: auto;
        flex: 2 1 40%;
        margin-left: 10px;
        background-color: black;
        border: 3px dashed blue;
        &::-webkit-scrollbar {
          /* 血槽宽度 */
          width: 8px;
          height: 8px;
        }
        &::-webkit-scrollbar-thumb {
          /* 拖动条 */
          background-color: rgba(0, 0, 0, 0.3);
          border-radius: 6px;
        }
        &::-webkit-scrollbar-track {
          /* 背景槽 */
          background-color: #ddd;
          border-radius: 6px;
        }
        & {
          scrollbar-width: 10px;
          scrollbar-color: blue;
        }

        //-moz- firefox火狐浏览器不支持滚动条样式设置
      }
      .img-contain {
        overflow: auto;
        height: 45%;
        flex: 0 1 30%;
        border: 2px solid yellow;
        scrollbar-width: thin;
        scrollbar-color: red green;   //火狐浏览器只支持这种
        .img {
          width: 150%;
          height: 150%;
        }
      }
    }
    .left-right-pane {
    }
  }
  .right-pane {
    height: 100%;
    width: 100%;
    .right-left-pane {
    }
    .right-right-pane {
    }
  }
}
</style>
