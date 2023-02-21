import Vue from 'vue'
import Vuex from 'vuex'
import vuexApi from './vuex-api'
Vue.use(Vuex)
const store = new Vuex.Store({
  state: {
    count: 0,
    person: {
      sex: false
    },
    list: [
      { value: 'big', label: '大' },
      { value: 'normal', label: '中' },
      { value: 'small', label: '小' }
    ],
    selectedValue: [''],
    displayList: []
  },
  mutations: {
    increment (state, data) {
      if (data && data.amount) {
        state.count = state.count + Number(data.amount)
      }
    },
    changeSex (state, data) {
      if (data && data.sex) {
        state.person.sex = data.sex === 'girl'
      }
    },
    changeList (state, data) {
      if (data && data.value) {
        state.selectedValue = []
        state.selectedValue.push(state.list.filter((e) => {
          return e.value === data.value
        })[0].label)
      }
    },
    changeListActions (state, data) {
      state.displayList = []
      if (data) {
        state.displayList = data
      }
    }
  },
  actions: {
    async changedisPlayList ({ commit }, val) {
      let res = await vuexApi.query(val).catch((error) => {
        console.log(error)
      })
      if (res.status === 200) {
        commit('changeListActions', res.data)
      }
    }
  }
})

export default store
