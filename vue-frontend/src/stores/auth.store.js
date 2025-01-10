import { defineStore } from 'pinia'

export const useAuthStore = defineStore("auth", {
  state: () => ({
    userJwt= null,
  }),
  actions: {
    async login(username, password) {


      },
    async register(username, password) {
        const res = await fetch("https://localhost:3000/register", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify({ username, password }),
        });
        const jwt = await res.json()
        this.jwt = jwt;
      },
  }
})
