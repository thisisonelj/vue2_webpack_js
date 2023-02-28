<template>
  <div class="socket-main">
    <div class="socket-content">
      <Button type="primary" @click="contactWebSocket">{{contactValue}}</Button>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      contactValue: '连接websocket'
    }
  },
  methods: {
    contactWebSocket () {
      let ws = new WebSocket('ws://127.0.0.1:8188/websocket/id')

      ws.onopen = function (evt) {
        console.log('Connection open ...')
        let user = {}
        user.id = 'liu'
        user.age = 24
        ws.send(JSON.stringify(user))
      }

      ws.onmessage = function (evt) {
        console.log('Received Message: ' + evt.data)
        ws.close()
      }

      ws.onclose = function (evt) {
        console.log('Connection closed.')
      }
    }
  }
}
</script>
<style lang="less" scoped>
@deep:~ ">>>";
.socket-main {
  height: 100%;
  .socket-content {
    Button {
      position: absolute;
      top: 0;
      bottom: 0;
      left: 0;
      right: 0;
      margin: auto;
      width: 9%;
      height: 5%;
      text-align: center;
    }
  }
}
</style>
