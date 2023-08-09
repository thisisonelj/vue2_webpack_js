<template>
  <div class="login-form">
    <el-form ref="loginForm" :model="accountForm" label-width="80px">
      <el-form-item :label="userLablel">
        <el-input v-model="accountForm.userName"></el-input>
      </el-form-item>
      <el-form-item :label="passWordLablel">
        <el-input v-model="accountForm.passWord"></el-input>
      </el-form-item>
    </el-form>
    <div>
      <Row type="flex" justify="center" class="code-row-bg">
        <Col span="4">
          <el-button type="primary" @click="loginAccount">登录</el-button></Col
        >
        <Col span="2" offset="4">
          <el-button type="warning" @click="registAccount">注册</el-button></Col
        >
      </Row>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      accountForm: {
        userName: '',
        passWord: ''
      },
      userLablel: '用户名',
      passWordLablel: '密码'
    }
  },
  components: {},
  methods: {
    loginAccount () {
      this.$emit('login-info', this.accountForm)
    },
    registAccount () {
      this.$emit('regist-info', this.accountForm)
    }
  }
}
</script>
<style scoped lang="less">
@keyframes animationscale-rule {
  0% {
    transform: scale(0.5);
  }
  100% {
    transform: scale(1);
  }
}
.login-form {
  width: 30%;
  //animation: animationscale-rule 1s linear  both;
}
</style>
