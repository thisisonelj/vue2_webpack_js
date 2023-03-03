<template>
  <div class="css3-transition">
    <div class="transition-main">
      <div class="one"></div>
      <div class="two-three">
        <div class="two"></div>
        <div class="three"></div>
      </div>
      <div class="four"></div>
      <div class="five"></div>
    </div>
    <div class="transition-btn">
      <Button type="primary" style="width: 70%">显示浮沉</Button>
    </div>
    <div class="transition-dialog"></div>
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
.css3-transition {
  height: 100%;
  width: 100%;
  display: inline-flex;
  justify-content: center;
  align-items: stretch;
  .transition-btn {
    width: 10%;
    height: 10%;
    border: 1px solid transparent;
    transform: translate(50px, 50px);
    text-align: center;
  }
  .transition-main {
    width: 50%;
    height: 70%;
    border: 1px solid red;
    transform: translateY(15%);
    display: inline-flex;
    justify-content: space-around;
    align-items: flex-start;
    flex-wrap: wrap;
    .one {
      width: 20%;
      height: 20%;
      border: 1px solid blue;
      transition-duration: 1s;
      transition-delay: -0.5s;
      transform: rotate(0);
      &:hover {
        transform: rotate(180deg);
      }
    }
    .two-three {
      width: 50%;
      height: 20%;
      border: 1px dashed black;
    }
    .two {
      display: inline-block;
      width: 50%;
      height: 100%;
      border: 1px dashed green;
      border-radius: 100%;
    }
    .two + .three {
      display: inline-block;
      width: 50%;
      height: 100%;
      border: 1px solid red;
      transition-delay: 0.2s;
      visibility: hidden;
    }

    .two:hover + .three {
      visibility: visible;
    }
    .four {
      width: 32%;
      height: 32%;
      border: 1px dashed orange;
      transition-property: height border;
      transition-duration: 1s, 2s;
    }
    .four:hover {
      height: 35%;
      border: 2px solid red;
    }
    .five {
      width: 25%;
      height: 30%;
      border: 2px dashed purple;
      transform: translateY(0);
      transition: 1s 0.5s ease-out;
    }
    .five:hover {
      transform: translateY(200px);
    }
  }
  .transition-btn + .transition-dialog {
    width: 15%;
    height: 20%;
    border: 2px dashed sandybrown;
    transform: translate(100px,50px);
    opacity: 0;
    visibility: hidden;
    transition: 1s 1s ease-in-out;
  }
  .transition-btn:hover + .transition-dialog{
    opacity: 1;
    visibility: visible;
  }
}
</style>
