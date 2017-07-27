<template>
  <div>
    <table>
      <tbody>
        <profile v-for="member in members" v-bind:member="member" v-bind:key="member.id" v-on:click="select"></profile>
      </tbody>
    </table>
  </div>
</template>

<script>
import profile from './Profile'

export default {
  components: {
    profile
  },
  methods: {
    select: function (event) {
      alert(event)
    }
  },
  name: 'Identification',
  data () {
    return {
      members: [
        {
          id: '1234',
          name: 'hoge',
          number: 10,
          gender: '1'
        },
        {
          id: '1234',
          name: 'hoge',
          number: 10,
          gender: '1'
        },
        {
          id: '1234',
          name: 'hoge',
          number: 10,
          gender: '2'
        },
        {
          id: '1234',
          name: 'hoge',
          number: 10,
          gender: '1'
        },
        {
          id: '1234',
          name: 'hoge',
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
