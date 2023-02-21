import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)
const store = new Vuex.Store({
  state: {
    tableData: [
      {
        name: 'liusir',
        age: 24
      },
      {
        name: 'liusir',
        age: 24
      }
    ]
  },
  mutations: {
    queryTableData (state, data) {},
    insertTable (state, data) {
      if (data) {
        state.tableData.push({
          name: 'liusir',
          age: 24
        })
      }
    },
    deleteTable (state, data) {
      if (data) {
        state.tableData.splice(data._index, 1)
      }
    }
  },
  modules: {
    insert: {
      namespaced: true,
      state: () => ({
        id: 0
      }),
      actions: {
        insertTable ({ commit }, data) {
          if (data) {
            commit('insertTable', data, { root: true })
          }
        }
      }
    },
    delete: {
      namespaced: true,
      state: () => ({
        id: 0
      }),
      actions: {
        deleteTable ({ commit }, data) {
          if (data) {
            commit('deleteTable', data, { root: true })
          }
        }
      }
    }
  }
})

export default store
