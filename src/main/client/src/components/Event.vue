<template>
  <div>
    <div v-for="event in events">
      <div class="card-panel teal lighten-2">
      <h5 class="white-text text-darken-2">
      {{event.year}}
      </h5>
      </div>
      <table class="bordered">
        <tbody>
          <tr v-for="item in event.list" @click="attend">
            <td><h4>{{item.date}}</h4></td>
            <td>
                <h6 class="card-panel teal lighten-2"><span class="white-text">{{item.name}}<br>{{item.time}}</span></h6>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
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
