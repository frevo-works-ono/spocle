<template>
  <div>
    ssss
  </div>
</template>

<script>
export default {
  name: 'Event',
  data () {
    return {
      events: [
        {
          year: '2017',
          list: [
            {
              date: '1/1',
              time: '10:00〜12:00',
              name: 'どへたかっぷ'
            },
            {
              date: '1/1',
              time: '10:00〜12:00',
              name: 'どへたかっぷ'
            }
          ]
        }
      ]
    }
  },
  methods: {
    attend: function (event) {
      alert('hoge')
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
