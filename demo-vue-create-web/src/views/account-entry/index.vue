<template>
  <div class="account-main">
    <account-login
      @login-info="loginAccount"
      @regist-info="registAccount"
      :error-info-status="errorInfoStatus"
      ref="accoutLogin"
    ></account-login>
  </div>
</template>
<script>
import accountLogin from '../../components/account-components'
import accountApi from '../../utils/account-api.js'
export default {
  data () {
    return {
      errorInfoStatus: true // 登录错误信息状态展示
    }
  },
  components: {
    accountLogin: accountLogin
  },
  methods: {
    loginAccount (formData) {
      accountApi
        .login(formData)
        .then((res) => {
          this.errorInfoStatus = !!res.data
          if (this.errorInfoStatus) {
            this.$router.push('/main')
          } else {
            this.$refs.accoutLogin.accountForm = {
              userName: '',
              passWord: ''
            }
          }
        })
        .catch((error) => {
          console.log(error)
        })
    },
    registAccount (formData) {}
  }
}
</script>
<style scoped lang="less">
.account-main {
  background-color: blanchedalmond;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
