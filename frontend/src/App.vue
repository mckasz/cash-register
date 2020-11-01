<template>
  <div id="app">
    <img alt="E-Commerce logo" src="./assets/logo.png" width="300">
    <CashRegister/>
  </div>
</template>

<script>
import CashRegister from './components/CashRegister.vue'

export default {
  title: 'Cash Register',
  name: 'App',
  components: {
    CashRegister
  },
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
