/** 有关核算信息相关api */
import http from './cross-access'
const accountApi = {}
accountApi.login = (data) => {
  return http.post('/rest/account/user/login', data)
}
accountApi.regist = (data) => {
  return http.post('/rest/account/user/regist', data)
}
export default accountApi
