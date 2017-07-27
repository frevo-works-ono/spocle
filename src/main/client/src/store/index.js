import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const state = {
  members: [],
  events: []
}

const actions = {
  done ({ state, commit }) {
    // state.routeでアクセス可能
    console.log('actions:', state.route.params.id)
    commit('done')
  }
}

const mutations = {
  done (state) {
    // state.routeでアクセス可能
    console.log('mutations:', state.route.params.id)
  }
}

const getters = {
  list: state => state.list,
  detail: state => {
    // state.routeでアクセス可能
    return state.list.find(l => l.id.toString() === state.route.params.id.toString()) || {}
  }
}

export default new Vuex.Store({
  state,
  actions,
  mutations,
  getters
})
