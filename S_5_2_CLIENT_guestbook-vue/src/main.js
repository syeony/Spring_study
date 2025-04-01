// import './assets/main.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import mitt from 'mitt'

const emitter = mitt();

const app = createApp(App)

app.provide('emitter', emitter);          // Provide as `emitter` usee in composition api
app.use(router)

app.mount('#app')
