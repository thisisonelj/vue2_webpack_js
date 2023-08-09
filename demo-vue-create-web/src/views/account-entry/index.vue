<template>
  <div class="account-main">
    <account-login
      @login-info="loginAccount"
      @regist-info="registAccount"
    ></account-login>
  </div>
</template>
<script>
import accountLogin from '../../components/account-components'
import accountApi from '../../utils/account-api.js'
export default {
  data () {
    return {}
  },
  components: {
    accountLogin: accountLogin
  },
  methods: {
    loginAccount (formData) {
      accountApi.login(formData).then((res) => {

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
