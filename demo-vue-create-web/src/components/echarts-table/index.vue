<template>
  <div class="main">
    <body>
      <!-- 为 ECharts 准备一个定义了宽高的 DOM -->
      <div id="main" class="echart-main" v-if="echartStatus"></div>
      <div class="echart-button">
        <Button type="primary" @click="controldisPlay"
          >图表显示</Button
        >
        <Button type="primary" @click="controlHidden" style="margin-left:20px"
          >图表隐藏</Button
        >
      </div>
    </body>
  </div>
</template>
<script>
export default {
  data () {
    return {
      displayStatus: true,
      echartsInstance: {}
    }
  },
  created () {},
  mounted () {
    this.initEcharts()
  },
  computed: {
    echartStatus: function () {
      if (!this.displayStatus) {
        this.echartsInstance.dispose()
      }
      // console.log(this.echartsInstance)
      return this.displayStatus
    }
  },
  methods: {
    controldisPlay () {
      this.displayStatus = true
      this.$nextTick(() => {
        this.initEcharts()
      })
    },
    controlHidden () {
      this.displayStatus = false
    },
    initEcharts () {
      // 基于准备好的dom，初始化echarts实例
      let myChart = this.$echarts.init(document.getElementById('main'), 'dark', {
        width: 600,
        height: 400
      })

      // 指定图表的配置项和数据
      let option = {
        title: {
          text: 'ECharts 入门示例'
        },
        tooltip: {},
        legend: {
          data: ['销量']
        },
        xAxis: {
          data: ['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子']
        },
        yAxis: {},
        series: [
          {
            name: '销量',
            type: 'bar',
            data: [5, 20, 36, 10, 10, 20],
            color: [
              '#dd6b66',
              '#759aa0',
              '#e69d87',
              '#8dc1a9',
              '#ea7e53',
              '#eedd78'
            ],
            symbolSize: function (data) {
              return Math.sqrt(data[2]) / 5e2
            },
            emphasis: {
              itemStyle: {
                // 高亮时点的颜色。
                color: 'blue'
              },
              focus: 'series',
              label: {
                show: true,
                formatter: function (param) {
                  return param.data[3]
                },
                position: 'top'
              }
            },
            itemStyle: {
              shadowBlur: 10,
              shadowColor: 'rgba(120, 36, 50, 0.5)',
              shadowOffsetY: 5,
              color: {
                type: 'radial',
                x: 0.4,
                y: 0.3,
                r: 1,
                colorStops: [
                  {
                    offset: 0,
                    color: 'rgb(251, 118, 123)'
                  },
                  {
                    offset: 1,
                    color: 'rgb(204, 46, 72)'
                  }
                ]
              }
            }
          }
        ]
      }

      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option)
      window.addEventListener('resize', function () {
        myChart.resize()
      })
      this.echartsInstance = myChart
    }
  },
  beforeDestroy () {
    this.echartsInstance.dispose()
  }
}
</script>
<style lang="less" scoped>
@deep: ~">>>";
.main {
  height: 100%;
  .echart-main {
    position: absolute;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    margin: auto;
    height: 50%;
    width: 50%;
  }
  .echart-button {
    display: inline-block;
    white-space: nowrap;
    position: absolute;
    top: -80%;
    bottom: 0;
    left: -10%;
    right: 0;
    margin: auto;
    height: 10%;
    width: 20%;
    text-align: center;
  }
}
</style>
