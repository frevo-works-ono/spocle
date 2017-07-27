<template>
  <div>
    <form v-on:submit.prevent="onSubmit">
      <input type="text" v-model="teamName" placeholder="チーム名">
      <select v-model="category">
        <option value="01">ミックス</option>
      </select>
      <input type="text" v-model="category" placeholder="チーム名">
      <button type="submit">保存</button>
    </form>
  </div>
</template>

<script>
import $ from 'jquery'

export default {
  methods: {
    onSubmit: function (data) {
      $.ajax({
        method: 'POST',
        url: 'http://localhost:8081/teams',
        crossDomain: true,
        contentType: 'application/json',
        data: data
      }).done(function (res) {
      }).fail(function (res) {

      })
    }
  },
  data () {
    return {
      teamName: '',
      category: '',
      detail: '',
      establishDate: '',
      activityPlace: '',
      activityDate: '',
      level: ''
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
