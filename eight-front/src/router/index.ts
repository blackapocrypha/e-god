import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/yearEight',
      name: 'yearEight',
      component: () => import('../views/EightGodView.vue')
    },
    {
      path: '/timeEight',
      name: 'timeEight',
      component: () => import('../views/EightTimeView.vue')
    }
  ]
})

export default router
