<template>
  <div id="app">
    <list-view />
  </div>
</template>

<script>
import ListView from './views/ListView.vue'

export default {
  name: 'App',
  components: {
    ListView
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
