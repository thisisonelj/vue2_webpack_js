import http from '../src/utils/cross-access'
const vuexApi = {}
vuexApi.query = (data) => {
  return http.post('/rest/demo/vuex/actions', data)
}
export default vuexApi
