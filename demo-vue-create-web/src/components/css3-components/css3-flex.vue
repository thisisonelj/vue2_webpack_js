<template>
  <div class="css3-flex">
    <Split v-model="split1">
      <div slot="left" class="left-pane">
        <Split v-model="split2" mode="vertical">
          <div slot="top" class="left-left-pane">
            <div class="first">1</div>
            <div class="second">2</div>
            <div class="third">3</div>
            <div class="flex-derict">
              <div class="fourth">4</div>
              <div class="fiveth">5</div>
              <div class="sixth">6</div>
            </div>
            <div class="flex-derict1">
              <div class="fourth">4</div>
              <div class="fiveth">5</div>
              <div class="sixth">6</div>
            </div>
            <div class="flex-derict2">
              <div class="fourth">4</div>
              <div class="fiveth">5</div>
              <div class="sixth">6</div>
            </div>
          </div>
          <div slot="bottom" class="left-right-pane">
            <div class="flex-justify-one">
              <div class="seven">11</div>
              <div class="eight">22</div>
              <div class="nine">33</div>
            </div>
            <div class="flex-justify-two">
              <div class="seven">11</div>
              <div class="eight">22</div>
              <div class="nine">33</div>
            </div>
            <div class="flex-justify-three">
              <div class="seven">11</div>
              <div class="eight">22</div>
              <div class="nine">33</div>
            </div>
            <div class="flex-justify-four">
              <div class="seven">11</div>
              <div class="eight">22</div>
              <div class="nine">33</div>
            </div>
            <div class="flex-justify-five">
              <div class="seven">11</div>
              <div class="eight">22</div>
              <div class="nine">33</div>
            </div>
            <div class="flex-justify-six">
              <div class="seven">11</div>
              <div class="eight">22</div>
              <div class="nine">33</div>
            </div>
          </div>
        </Split>
      </div>
      <div slot="right" class="right-pane">
        <Split v-model="split1" mode="vertical">
          <div slot="top" class="right-left-pane">
            <div class="first">111</div>
            <div class="second">222</div>
            <div class="third">333</div>

            <div class="four">111</div>
            <div class="five">222</div>
            <div class="six">333</div>
          </div>
          <div slot="bottom" class="right-right-pane">
            <div class="first">111</div>
            <div class="second">222</div>
            <div class="third">333</div>

            <div class="four">111</div>
            <div class="five">222</div>
            <div class="six">333</div>
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
      split2: 0.5
    }
  }
}
</script>
<style lang="less" scoped>
.css3-flex {
  height: 100%;
  width: 100%;
  .left-pane {
    height: 100%;
    width: 100%;
    .left-left-pane {
      height: 100%;
      width: 100%;
      display: inline-flex;
      flex-wrap: wrap-reverse;
      .first {
        width: 20%;
        height: 20%;
        border: 1px solid red;
        float: left;
      }
      .second {
        width: 50%;
        height: 20%;
        //margin: auto;
        margin-left: 5%;
        margin-right: 5%;
        border: 1px dashed blue;
        float: left;
        //margin-top: 0;
      }
      .third {
        width: 20%;
        height: 20%;
        border: 1px solid black;
        float: left;
        order: -1;
      }
      .flex-derict {
        height: 60%;
        width: 30%;
        display: inline-flex;
        flex-wrap: wrap;
        flex-direction: row-reverse;
        flex-direction: column;
        .fourth {
          width: 80%;
          height: 30%;
          border: 1px solid red;
          float: left;
        }
        .fiveth {
          width: 80%;
          height: 30%;
          border: 1px solid blue;
          float: left;
        }
        .sixth {
          width: 80%;
          height: 30%;
          border: 1px solid black;
          float: left;
        }
      }

      .flex-derict1 {
        height: 60%;
        width: 30%;
        display: inline-flex;
        flex-wrap: wrap;
        flex-direction: row-reverse;
        flex-direction: column;
        .fourth {
          width: 80%;
          height: 30%;
          border: 1px solid red;
          float: left;
        }
        .fiveth {
          width: 80%;
          height: 30%;
          border: 1px solid blue;
          float: left;
        }
        .sixth {
          width: 80%;
          height: 30%;
          border: 1px solid black;
          float: left;
        }
      }
      .flex-derict2 {
        height: 60%;
        width: 30%;
        display: inline-flex;
        flex-wrap: wrap;
        flex-direction: row-reverse;
        flex-direction: column;
        .fourth {
          width: 80%;
          height: 30%;
          border: 1px solid red;
          float: left;
        }
        .fiveth {
          width: 80%;
          height: 30%;
          border: 1px solid blue;
          float: left;
        }
        .sixth {
          width: 80%;
          height: 30%;
          border: 1px solid black;
          float: left;
        }
      }
    }
    #seven {
      width: 30%;
      height: 100%;
      border: 1px solid black;
      float: left;
    }

    .left-right-pane {
      height: 100%;
      width: 100%;
      .flex-justify-one {
        display: inline-flex;
        justify-content: flex-start;
        flex-flow: wrap row;
        height: 15%;
        width: 100%;
        .seven {
          #seven();
        }
        .eight {
          #seven();
        }
        .nine {
          #seven();
        }
      }
      .flex-justify-two {
        display: inline-flex;
        justify-content: flex-end;
        flex-flow: wrap row;
        height: 15%;
        width: 100%;
        margin-top: 1%;
        .seven {
          #seven();
        }
        .eight {
          #seven();
        }
        .nine {
          #seven();
        }
      }
      .flex-justify-three {
        display: inline-flex;
        justify-content: center;
        flex-flow: wrap row;
        height: 15%;
        width: 100%;
        margin-top: 1%;
        .seven {
          #seven();
        }
        .eight {
          #seven();
        }
        .nine {
          #seven();
        }
      }
      .flex-justify-four {
        display: inline-flex;
        justify-content: space-between;
        flex-flow: wrap row;
        height: 15%;
        width: 100%;
        margin-top: 1%;
        .seven {
          #seven();
        }
        .eight {
          #seven();
        }
        .nine {
          #seven();
        }
      }
      .flex-justify-five {
        display: inline-flex;
        justify-content: space-around;
        flex-flow: wrap row;
        height: 15%;
        width: 100%;
        margin-top: 1%;
        .seven {
          #seven();
        }
        .eight {
          #seven();
        }
        .nine {
          #seven();
        }
      }
      .flex-justify-six {
        display: inline-flex;
        justify-content: space-evenly;
        flex-flow: wrap row;
        height: 15%;
        width: 100%;
        margin-top: 1%;
        .seven {
          #seven();
        }
        .eight {
          #seven();
        }
        .nine {
          #seven();
        }
      }
    }
  }
  .right-pane {
    height: 100%;
    width: 100%;
    .right-left-pane {
      height: 100%;
      width: 100%;
      display: inline-flex;
      align-items: flex-start;
      align-items: flex-end;
      align-items: center;
      align-items: baseline;
      padding: 10px;
      flex-wrap: wrap;
      .first {
        height: 30%;
        width: 30%;
        border: 1px solid red;
        align-self: center;
      }
      .second {
        height: 20%;
        width: 20%;
        border: 1px solid blue;
      }
      .third {
        height: 40%;
        width: 40%;
        border: 1px solid black;
      }
      .four {
        height: 40%;
        width: 40%;
        border: 1px solid black;
      }
      .five {
        height: 30%;
        width: 30%;
        border: 1px solid black;
        align-self: center;
      }
      .six {
        width: 20%;
        border: 1px solid black;
        align-self: stretch;
      }
    }
    .right-right-pane {
      height: 100%;
      width: 100%;
      display: inline-flex;
      align-content: flex-start;
      align-content: flex-end;
      align-content: center;
      align-content: space-between;
      align-content: space-around;
      align-content: space-evenly;
      padding: 10px;
      flex-wrap: wrap;
      .first {
        height: 30%;
        width: 30%;
        border: 1px solid red;
        //align-self: center;
      }
      .second {
        height: 20%;
        width: 20%;
        border: 1px solid blue;
      }
      .third {
        height: 40%;
        width: 40%;
        border: 1px solid black;
      }
      .four {
        height: 40%;
        width: 40%;
        border: 1px solid black;
      }
      .five {
        height: 30%;
        width: 30%;
        border: 1px solid black;
        //align-self: center;
      }
      .six {
        width: 20%;
        border: 1px solid black;
        //align-self: stretch;
      }
    }
  }
}
</style>
