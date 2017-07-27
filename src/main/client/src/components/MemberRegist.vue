<template>
  <div class="row">
    <form v-on:submit.prevent="onSubmit" class="col s12">
      <div class="row">
        <div class="input-field col s6">
          <input type="text" v-model="userName" id="userName" class="validate">
          <label for="userName">名前</label>
        </div>
        <div class="input-field col s6">
          <input type="number" v-model="number" id="number" class="validate">
          <label for="number">背番号</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <p>
            <input type="radio" v-model="gender" id="man" value="1" />
            <label for="man">男性</label>
          </p>
          <p>
            <input type="radio" v-model="gender" id="woman" value="2" />
            <label for="woman">女性</label>
          </p>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input id="email" type="email" class="validate">
          <label for="email" data-error="wrong" data-success="right">メールアドレス</label>
        </div>
      </div>
      <button class="btn waves-effect waves-light" type="submit" name="action">登録
        <i class="material-icons right">send</i>
      </button>
    </form>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  methods: {
    onSubmit: function () {
      axios.post('/users', {
        name: this.userName
      })
      .then(function (res) {
        console.log('登録完了')
      })
      .catch(function (error) {
        console.log(error)
      })
    }
  },
  data () {
    return {
      userName: '',
      number: '',
      gender: '',
      mailaddress: ''
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
