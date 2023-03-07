import http from './cross-access'
const extendApi = {}
extendApi.debounce = (data) => {
  return http.post('/rest/demo/extend/debounce', data)
}
export default extendApi
