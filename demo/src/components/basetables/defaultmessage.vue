<template>
  <div style="padding-top:5%">
    <el-row type="flex" justify="space-around">
      <el-col :span="8"><div>{{messageInfo.id}}</div></el-col>
      <el-col :span="8"><div>{{messageInfo.name}}</div></el-col>
      <el-col :span="8"><div>{{messageInfo.time}}</div></el-col>
    </el-row>
  </div>
</template>
<script>
export default {
  props: {
    displayInfo: {
      type: {},
      default: function () {
        return {}
      }
    }
  },
  name: 'messageInfo',
  data () {
    return {

    }
  },
  computed: {
    messageInfo () {
      return {
        id: `用户：${this.displayInfo.name !== undefined ? this.displayInfo.name : '用户'}`,
        name: `商品：${this.displayInfo.goodName !== undefined ? this.displayInfo.goodName : '商品'}`,
        time: `商店：${this.displayInfo.storeName !== undefined ? this.displayInfo.storeName : '商店'}`
      }
    }
  }
}
</script>
<style scoped></style>
