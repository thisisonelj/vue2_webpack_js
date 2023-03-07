<template>
  <div class="carousel-main">
    <div class="carousel-content">
      <div class="transform-box">
        <div class="carousel-item1"></div>
        <div class="carousel-item2"></div>
        <div class="carousel-item3"></div>
        <div class="carousel-item4"></div>
        <div class="carousel-item5"></div>
      </div>
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
@img1-url: "@/assets/sea.jpg";
@img2-url: "@/assets/sea1.jfif";
@img3-url: "@/assets/sea2.jfif";
@img4-url: "@/assets/sea3.jfif";
@img5-url: "@/assets/sea4.jfif";
@keyframes left-rule {
  0% {
    left: 0;
  }
  25% {
    left: -100%;
  }
  50% {
    left: -200%;
  }
  75% {
    left: -300%;
  }
  100% {
    left: -400%;
  }
}
@keyframes visibility-rule {
  0% {
    opacity: 0;
  }
  100% {
    opacity: 1;
  }
}
.carousel-main {
  height: 100%;
  width: 100%;
  display: inline-flex;
  justify-content: center;
  align-items: center;
  .carousel-content {
    width: 40%;
    height: 50%;
    background-color: black;
    overflow: hidden;
    position: relative;
    .carousel-item() {
      width: 100%;
      height: 100%;
    }
    .transform-box {
      position: absolute;
      width: 500%;
      height: 100%;
      display: inline-flex;
      left: 0;
      animation: left-rule 7s both infinite;
      animation-timing-function: linear;
      animation-delay: 1s;
      animation-fill-mode: both;
    }
    .carousel-item1 {
      .carousel-item();
      background-size: 100% 100%;
      background-image: url(@img1-url);
      animation-delay: 3s;
    }
    .carousel-item2 {
      .carousel-item();
      background-image: url(@img2-url);
      background-size: 100% 100%;
      animation-delay: 3s;
    }
    .carousel-item3 {
      .carousel-item();
      background-image: url(@img3-url);
      background-size: 100% 100%;
      animation-delay: 3s;
    }
    .carousel-item4 {
      .carousel-item();
      background-image: url(@img4-url);
      background-size: 100% 100%;
      animation-delay: 3s;
    }
    .carousel-item5 {
      .carousel-item();
      background-image: url(@img5-url);
      background-size: 100% 100%;
      animation-delay: 3s;
    }
  }
}
</style>
