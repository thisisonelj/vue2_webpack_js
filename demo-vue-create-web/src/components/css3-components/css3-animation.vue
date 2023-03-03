<template>
  <div class="css3-animation">
    <Split v-model="split1">
      <div slot="left" class="left-pane">
        <Split v-model="split2" mode="vertical">
          <div slot="top" class="left-left-pane">
            <div class="one"></div>
            <div class="two"></div>
          </div>
          <div slot="bottom" class="left-right-pane">
            <div class="three"></div>
            <div class="four"></div>
            <div class="five"></div>
            <div class="six"></div>
          </div>
        </Split>
      </div>
      <div slot="right" class="right-pane">
        <Split v-model="split1" mode="vertical">
          <div slot="top" class="right-left-pane">
            <div :class="[defaultStyle, stopStyle]"></div>
            <div class="eight">
              <Button
                type="primary"
                style="width: 100%"
                @click="pauseAnimation()"
                >暂停动画</Button
              >
              <Button
                style="width: 100%; margin-top: 50px"
                @click="runAnimation()"
                >播放动画</Button
              >
            </div>
          </div>
          <div slot="bottom" class="right-right-pane">
            <div  id="outer"
              class="nine"
              style="width: 50px; height: 50px;"
            >
              <div  id="inner"
                style="width: 100%; height: 100%; border: 1px solid black"
              ></div>
            </div>
            <Button
              type="primary"
              style="width: 20%; transform: translateX(500px)"
              @click="parabolaRun()"
            >抛物线运动</Button>
          </div>
        </Split>
      </div>
    </Split>
  </div>
</template>
<script>
export default {
  data () {
    return {
      split1: 0.5,
      split2: 0.5,
      defaultStyle: 'seven',
      stopStatus: false
    }
  },
  methods: {
    pauseAnimation () {
      this.stopStatus = true
    },
    runAnimation () {
      this.stopStatus = false
    },
    parabolaRun () {
      let obj = document.getElementById('outer')
      obj.style.transition = 'all 0.5s cubic-bezier(0,0,0,0)'
      obj.style.transform = 'translateX(100px)'
      let inner = document.getElementById('inner')
      inner.style.transform = 'translateY(100px)'
      inner.style.transition = '0.5s all cubic-bezier(0.14,-1.33,1,0.18);'
    }
  },
  computed: {
    stopStyle () {
      if (!this.stopStatus) {
        return ''
      } else {
        return 'stop-animation'
      }
    }
  }
}
</script>
<style lang="less" scoped>
@keyframes vertical-run-rule {
  from {
     transform: translateX(0);
  }
  to {
    transform: translateX(200px);
  }
}
@keyframes hotical-run-rule {
  from {
     transform: translateY(0);
  }
  to {
    transform: translateY(200px);
  }
}

@keyframes opacity-rule {
  from {
    opacity: 0;
  }
  to {
    opacity: 1;
  }
}
@keyframes translate-rule {
  0% {
    transform: translateY(0);
  }
  100% {
    transform: translateY(200px);
  }
}
@keyframes absolute-rule {
  25% {
    top: 100px;
  }
  50% {
    left: 200px;
  }
  75% {
    left: 100px;
  }
  100% {
    top: 0px;
  }
}
@keyframes animationdelay-rule {
  0% {
    transform: scale(1);
  }
  100% {
    transform: scale(5);
  }
}
@keyframes animationdelay1-rule {
  0% {
    transform: translateY(0);
  }
  100% {
    transform: translateY(200px);
  }
}
@keyframes animationalternate-rule {
  0% {
    transform: rotate(20deg);
  }
  100% {
    transform: rotate(-20deg);
  }
}
@keyframes animationvisiblity-rule {
  0% {
    opacity: 0;
  }
  100% {
    opacity: 1;
  }
}
@keyframes animationbackground-rule {
  0% {
    background-color: wheat;
  }
  100% {
    background-color: black;
  }
}
.css3-animation {
  width: 100%;
  height: 100%;
  .left-pane {
    width: 100%;
    height: 100%;
    .left-left-pane {
      display: inline-flex;
      justify-content: space-around;
      align-items: flex-start;
      width: 100%;
      height: 100%;
      .one {
        width: 20%;
        height: 20%;
        border: 1px solid red;
      }
      .two {
        width: 20%;
        height: 20%;
        border: 1px solid blue;
        position: absolute;
        left: 50px;
        animation: absolute-rule 5s;
      }
      .one:hover {
        animation: opacity-rule 5s, translate-rule 5s;
      }
    }
    .left-right-pane {
      display: inline-flex;
      justify-content: space-between;
      align-items: flex-start;
      width: 100%;
      height: 100%;
      padding: 20px;
      .three {
        width: 1%;
        height: 10%;
        border: 1px solid purple;
        animation: animationdelay-rule 5s linear infinite alternate;
      }
      .four {
        width: 100px;
        height: 100px;
        border: 1px dashed orangered;
        animation: animationdelay1-rule 5s linear infinite;
        animation-delay: -2.5s;
      }
      .five {
        transform-origin: top;
        width: 25px;
        height: 50px;
        border: 1px dashed black;
        border-radius: 100%;
        animation: animationalternate-rule 1s linear infinite alternate;
      }
      .six {
        width: 100px;
        height: 100px;
        border: 1px dashed maroon;
        animation: animationvisiblity-rule 5s linear 1.5 reverse;
        animation-iteration-count: 1.5;
      }
    }
  }
  .right-pane {
    width: 100%;
    height: 100%;
    .right-left-pane {
      display: inline-flex;
      justify-content: space-around;
      align-items: flex-start;
      width: 100%;
      height: 100%;
      padding: 10px;
      .seven {
        width: 200px;
        height: 200px;
        border: 1px solid black;
        background-color: red;
        animation: animationbackground-rule 3s infinite both;
      }
      .eight {
        width: 100px;
        height: 100px;
        border: 1px solid transparent;
      }
      .stop-animation {
        animation-play-state: paused;
      }
    }
    .right-right-pane {
      display: inline-flex;
      justify-content: flex-start;
      align-items: flex-start;
      width: 100%;
      height: 100%;
      padding: 10px;
      .nine,
      .nine > div {
        // transition: transform 0.5s;
      }
      .nine {
        animation: vertical-run-rule 3s infinite alternate;
        animation-timing-function: linear;
      }
    //   .nine:active{
    //     transform: translateX(100px);
    //   }
      .nine > div {
        animation: hotical-run-rule 3s infinite alternate;
        animation-timing-function: cubic-bezier(0.55, 0, 0.85, 0.36);
      }
    //   .nine > div:active{
    //     transform: translateY(100px);
    //   }
    }
  }
}
</style>
