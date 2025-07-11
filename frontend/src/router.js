import { createRouter, createWebHistory } from 'vue-router'
import Home from './views/Home.vue'
import Utilisateur from './views/Utilisateur.vue'

export default createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/', component: Home },
    { path: '/utilisateurs/:id', component: Utilisateur, props: true }
  ]
})
