<template>
  <tr class="collection-item" v-bind:class="{ 'blue lighten-4': member.gender=='1', 'pink lighten-4': member.gender=='2' }">
    <td width="100px"><img src="../assets/noimage.png" alt="" class="circle" width="50px" height="50px"></td>
    <td>{{ member.name }} #{{ member.number }}</td>
  </tr>
</template>

<script>
export default {
  name: 'Profile',
  props: {
    member: Object
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
