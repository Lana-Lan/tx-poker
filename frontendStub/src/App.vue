<template>
  <div id="app">
    <WebSocketChat/>
  </div>
</template>

<script>
import WebSocketChat from "./components/WebSocketChat";
export default {
  name: 'App',
  components:{
    WebSocketChat
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
