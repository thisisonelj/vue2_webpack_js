<template>
  <div>
    <Modal
      v-model="renderStatus"
      width="360"
      class="render-main"
      :show-close="false"
      :close-on-click-modal="false"
      :close-on-press-escape="false"
      :mask-closable="false"
    >
      <p slot="header" style="color: #f60; text-align: center">
        <Icon type="md-bulb" />
        <span>render展示</span>
      </p>
      <div style="text-align: center">
        <render-child>{{ msg }}</render-child>
        <render-second :form-render="formRender" style="margin-top:20px">{{ renderMsg}}</render-second>
      </div>
      <div slot="footer">
        <Button type="primary" size="large" @click="confirmRender">确定</Button>
        <Button type="text" size="large" @click="cancelRender">取消</Button>
      </div>
    </Modal>
  </div>
</template>
<script>
import renderChild from './render-child.vue'
import renderSecond from './render-child-second.vue'
export default {
  components: {
    'render-child': renderChild,
    'render-second': renderSecond
  },
  data () {
    return {
      msg: 'render语法',
      renderStatus: false,
      formRender: [
        {
          type: 'Input',
          attr: 'inputValue'
        },
        {
          type: 'Button',
          attr: 'buttonValue'
        }
      ],
      renderMsg: '展示render按钮 '
    }
  },
  methods: {
    confirmRender () {
      this.renderStatus = false
    },
    cancelRender () {
      this.renderStatus = false
    }
  },
  mounted () {
    this.$Spin.show({
      render: (h) => {
        return h('div', [
          h('Icon', {
            class: 'demo-spin-icon-load',
            props: {
              type: 'ios-loading',
              size: 18
            }
          }),
          h('div', '加载render中')
        ])
      }
    })
    setTimeout(() => {
      this.renderStatus = true
      this.$Spin.hide()
    }, 1000)
  }
}
</script>
<style lang="less" scoped>
@deep:~ ">>>";
@import url("@/style/render.less");
</style>
<style lang="less">
.demo-spin-icon-load {
  animation: ani-demo-spin 1s linear infinite;
}
</style>
