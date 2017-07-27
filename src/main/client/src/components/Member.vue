<template>
  <div>
    <table>
      <tbody>
        <profile v-for="member in members" v-bind:member="member" v-bind:key="member.id"></profile>
      </tbody>
    </table>
    <div class="fixed-action-btn">
      <a class="btn-floating btn-large red">
        <router-link tag="span" to="/member/regist"><i class="large material-icons">add</i></router-link>
      </a>
    </div>
  </div>
</template>

<script>
import profile from './Profile'
import axios from 'axios'

export default {
  components: {
    profile
  },
  created: function () {
    axios.get('/users')
      .then(res => {
        console.log(res.status, res.statusText, res.data)
        // => 200, "OK", { message: "You just sent the data!" }
      })
      .catch(error => {
        throw error
      })
  },
  methods: {
    addMember: function () {
      this.members.push({
        name: 'hoge',
        number: 10,
        gender: '1'
      })
    }
  },
  name: 'Member',
  data () {
    return {
      members: [
        {
          id: '1234',
          name: 'しんじ',
          number: 10,
          gender: '1'
        },
        {
          id: '1234',
          name: 'さっちゃん',
          number: 10,
          gender: '2'
        },
        {
          id: '1234',
          name: 'やっちゃん',
          number: 10,
          gender: '1'
        },
        {
          id: '1234',
          name: 'はっち',
          number: 10,
          gender: '1'
        },
        {
          id: '1234',
          name: 'なっちゃん',
          number: 10,
          gender: '2'
        }
      ]
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
