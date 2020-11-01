import '@babel/polyfill'
import './plugins/bootstrap-vue';

import Vue from 'vue'
import axios from 'axios'
import VueAxios from 'vue-axios'
import VueRouter from 'vue-router'
import titleMixin from './mixins/titleMixin'

import App from './App.vue'

Vue.use(VueRouter);
Vue.use(VueAxios, axios);

Vue.config.productionTip = false
Vue.mixin(titleMixin)

const router = new VueRouter({
    routes: [
        {
            path: '/',
            component: App,
            meta: {
                title: 'Cash Register'
            }
        },
    ]
});

new Vue({
    router,
    render: h => h(App),
}).$mount('#app')
