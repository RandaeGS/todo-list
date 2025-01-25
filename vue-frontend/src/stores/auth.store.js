import { defineStore } from 'pinia'

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
        const payload = state.userJwt.split(.)[1];
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
    }
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
      const res = await fetch('https://localhost:8080/register', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ username, password }),
      })
    },
  },
})
