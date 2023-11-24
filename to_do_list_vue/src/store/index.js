import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    newItem: {
      id: null,
      item: ""
    },
    updatedItem: {
      itemId: null,
      item: ""
    },
    checkedItemIds: []
  },
  getters: {
  },
  mutations: {
  },
  actions: {
  },
  modules: {
  }
})
