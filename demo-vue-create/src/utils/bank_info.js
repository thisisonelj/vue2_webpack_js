import http from './cross-access'
const bankApi = {}
bankApi.add = (data) => {
  return http.post('/rest/demo/bank/add', data)
}
bankApi.query_all = (data) => {
  return http.post('/rest/demo/bank/query-all', data)
}
bankApi.delete = (data) => {
  return http.post('/rest/demo/bank/delete', data)
}
bankApi.selectPagation = (data) => {
  return http.post('/rest/demo/bank/pagation', data)
}
bankApi.selectById = (data) => {
  return http.post('/rest/demo/bank/query-id', data)
}
bankApi.update = (data) => {
  return http.post('/rest/demo/bank/update', data)
}
export default bankApi
