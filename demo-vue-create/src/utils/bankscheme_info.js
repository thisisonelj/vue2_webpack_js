/** 有关银行查询方案相关api */
import http from './cross-access'
const bankSchemeApi = {}
bankSchemeApi.add = (data) => {
  return http.post('/rest/demo/bankscheme/add', data)
}
bankSchemeApi.query_all = (data) => {
  return http.post('/rest/demo/bankscheme/query-all', data)
}
bankSchemeApi.queryBySchemeId = (data) => {
  return http.post('/rest/demo/bankscheme/querybyschemeid', data)
}
bankSchemeApi.updateBySchemeId = (data) => {
  return http.post('/rest/demo/bankscheme/updatebyschemeid', data)
}
bankSchemeApi.deleteBySchemeId = (data) => {
  return http.post('/rest/demo/bankscheme/deletebyschemeid', data)
}
export default bankSchemeApi
