<template>
  <div class="css3-flex-auto">
    <Split v-model="split1" mode="vertical">
      <div slot="top" class="left-pane">
        <div class="one"></div>
        <div class="two"></div>
        <div class="three"></div>
        <div class="four"></div>
        <div class="five"></div>
      </div>
      <div slot="bottom" class="right-pane">
        <div class="flex-number">
          <div class="one">12345</div>
          <div class="two">12345</div>
          <div class="three">12345</div>
          <input type="submit" class="flex-button" :value="inputValue" />
        </div>
        <div class="flex-basis">
          <div class="one">{{ inputValue }}</div>
          <div class="two"></div>
          <div class="three"></div>
        </div>
        <div class="flex-min-width">
          <div class="one">{{ inputValue1 }}</div>
          <div class="two"></div>
          <div class="three"></div>
        </div>
      </div>
    </Split>
  </div>
</template>
<script>
export default {
  data () {
    return {
      split1: 0.5,
      inputValue: 'flex单值含义ssssssssssssssssssssss',
      inputValue1: 'flex单值含义sssssssssssssssssssssssssssssssssss'
    }
  }
}
</script>
<style lang="less" scoped>
.css3-flex-auto {
  height: 100%;
  width: 100%;
  .left-pane {
    height: 100%;
    width: 100%;
    display: inline-flex;
    width: 350px; //当flex容器总宽度足够时   flex-shirnk是不起作用的    shirnk属性占比是该子项的压缩比例  比如原来总宽度100  现在总宽度110>100  溢出了  该子项原来是40 flex-shirnk属性占比30%  那么最终该子项宽度是40-（（110-100）*30%）
    width: 340px; //容器恰恰相等
    width: 300px; //当flex容器总宽度不够时   flex-grow是不起作用的      grow属性占比是最终该子项分配的实际比例   比如总共100 flex-grow属性占比30%  结果就是100*30%=30
    .one {
      flex: 0 2 100px;
      background-color: blue;
    }
    .two {
      flex: 0 1 100px;
      background-color: orange;
    }
    .three {
      flex: 0 1 100px;
      background-color: black;
    }
    .four {
      flex: 3 0 20px;
      background-color: purple;
    }
    .five {
      flex: 2 0 20px;
      background-color: green;
    }
  }
  .right-pane {
    height: 100%;
    width: 100%;
    .flex-number {
      height: 100%;
      width: 40%;
      display: inline-flex;
      .one {
        height: 100%;
        flex: initial;
        flex: 0;
        flex: none;
        flex:1;
        flex: auto;
        background-color: red;
      }
      .two {
        height: 100%;
        flex: initial;
        flex: 0;
        flex: none;
        flex:1;
        flex: auto;
        background-color: blue;
      }
      .three {
        height: 100%;
        flex: initial;
        flex: 0;
        flex: none;
        flex:1;
        flex: auto;
        background-color: green;
      }
      .flex-button{
          white-space: normal;
          flex:none;
      }
    }
    .flex-basis{
      height: 100%;
      width: 10%;
      display: inline-flex;
      margin-left: 10%;
      .one{
        height: 100%;
        background-color: green;
        flex: 0 1 150px;
        width: 150px;
        min-width: 0;    //flex布局当中  min-width、width、flex子项内容宽度决定了当前子项的最终尺寸大小  与flex-basis没有直接关系   优先级min-width>(width和content内容宽度中取最小)    默认情况下只有flex-basis时  flex渲染最小尺寸是content内容宽度
      }
      .two{
        height: 100%;
        background-color: red;
      }
      .three{
        height: 100%;
        background-color: blue;
      }

    }
    .flex-min-width{
      height: 100%;
      width: 10%;
      display: inline-flex;
      margin-left: 10%;
      .one{
        height: 100%;
        background-color: red;
        flex: 0 1 150px;
        width: 150px;
        overflow: hidden;
        text-overflow: ellipsis;//利用上述讲到的最小尺寸特性  可以实现内联文字打点效果
      }
    }
  }
}
</style>
