<template>
  <div>
    <headers></headers>
    <div class="container">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
import headers from './components/Header'

export default {
  name: 'app',
  components: {
    headers
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
body {
  min-height: 2000px;
}
</style>
