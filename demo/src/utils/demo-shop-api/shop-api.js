import http from '../../cross-access'
const shopApi = {}
shopApi.add = (data) => {
  return http.post('/rest/demo/shop/add', data)
}
shopApi.query = (data) => {
  return http.post('/rest/demo/shop/query', data)
}
shopApi.valid = (data) => {
  return http.post('/rest/demo/shop/valid', data)
}
shopApi.delete = (data) => {
  return http.post('/rest/demo/shop/delete', data)
}
export default shopApi
