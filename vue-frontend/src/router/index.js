import { createRouter, createWebHistory } from 'vue-router'
import { useAuthStore } from '../stores/auth.store.js'
import AuthPage from '../views/AuthPage.vue'
import MainPage from '../views/MainPage.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'main',
      component: MainPage,
      requireAuth: true,
    },
    {
      path: '/auth',
      name: 'auth',
      component: AuthPage,
    },
  ],
})

router.beforeEach(async (to, from) => {
  const store = useAuthStore()

  if (store.isTokenExpired && to.name !== 'auth') {
    return { name: 'auth' }
  }
})

export default router
