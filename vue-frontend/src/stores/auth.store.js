import { defineStore } from 'pinia'
import { useRouter } from 'vue-router'
import axiosInstance from '@/plugins/axios'

export const useAuthStore = defineStore('auth', {
  state: () => ({
    userJwt: null,
  }),
  getters: {
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
        return true
      }
      const expireTime = payload.exp * 1000
      const currentTime = Date.now()

      return currentTime >= expireTime
    },
  },
  actions: {
    async login(username, password) {
      try {
        const response = await axiosInstance.post('/auth/login', {
          username: username,
          password: password,
        })
        const jwt = response.data
        console.log(jwt)
        this.userJwt = jwt
        return true
      } catch (error) {
        console.error('Error during login: ', error)
        return false
      }
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
