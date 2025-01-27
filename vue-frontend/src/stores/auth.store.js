import { defineStore } from 'pinia'
import { useRouter } from 'vue-router'
import axiosInstance from '@/plugins/axios'

export const useAuthStore = defineStore('auth', {
  state: () => ({
    userJwt: null,
  }),
  getters: {
    token: (state) => {
      return state.userJwt
    },
    tokenPayload: (state) => {
      if (!state.userJwt) {
        return null
      }
      try {
        const payload = state.userJwt.split('.')[1]
        return JSON.parse(atob(payload))
      } catch (error) {
        console.error('Error decoding token: ', error)
        return null
      }
    },
    isTokenExpired: (state) => {
      const payload = state.tokenPayload
      if (!payload) {
        return null
      }
      const expireTime = payload.exp * 1000
      const currentTime = Date.now()

      return currentTime >= expireTime
    },
  },
  actions: {
    async login(username, password) {
      const res = await fetch('http://localhost:8080/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ username, password }),
      })
      const jwt = await res.json()
      this.userJwt = jwt
    },
    async register(username, password) {
      try {
        const response = await axiosInstance.post('/auth/register', {
          username: username,
          password: password,
        })
        const jwt = response.data
        console.log(response)
        console.log(jwt)
        this.userJwt = jwt
        return true
      } catch (error) {
        console.error('Error during registration: ', error)
        return false
      }
    },
  },
})
