<template>
  <div class="login-form">
    <el-form ref="loginForm" :model="accountForm" label-width="80px">
      <el-form-item :label="userLablel">
        <el-input v-model="accountForm.userName"></el-input>
      </el-form-item>
      <el-form-item :label="passWordLablel">
        <el-input v-model="accountForm.passWord"></el-input>
      </el-form-item>
      <el-form-item style="text-align: center" v-if="!errorInfoStatus">
        <span :class="loginStyle">{{ errorInfo }}</span>
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
  props: {
    errorInfoStatus: {
      type: Boolean,
      default: true
    }
  },
  data () {
    return {
      accountForm: {
        userName: '',
        passWord: ''
      },
      userLablel: '用户名',
      passWordLablel: '密码',
      errorInfo: '用户名或密码错误'
    }
  },
  computed: {
    loginStyle () {
      return this.errorInfoStatus
        ? { 'right-style': true }
        : { 'error-style': true }
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

@keyframes animationerror-rule {
  0% {
    visibility: hidden;
    opacity: 0;
  }
  100% {
    visibility: visible;
    opacity: 1;
  }
}
.login-form {
  width: 30%;
  //animation: animationscale-rule 1s linear  both;
}

.error-style {
  color: red;
  animation: animationerror-rule 1s linear both;
}

.right-style {
  display: none;
}
</style>
