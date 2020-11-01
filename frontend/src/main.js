import '@babel/polyfill'
import './plugins/bootstrap-vue';

import Vue from 'vue'
import axios from 'axios'
import VueAxios from 'vue-axios'
import VueRouter from 'vue-router'

import App from './App.vue'

Vue.use(VueRouter);
Vue.use(VueAxios, axios);

Vue.config.productionTip = false

const router = new VueRouter({
  routes: [
    {path: '/', component: App},
  ]
});

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
