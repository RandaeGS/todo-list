import axios from 'axios'
import { useRouter } from 'vue-router'
import { useAuthStore } from '../stores/auth.store.js'

const axiosInstance = axios.create({
  baseURL: 'http://localhost:8080',
  timeout: 1000,
})

axiosInstance.interceptors.request.use(
  function (config) {
    const store = useAuthStore()
    if (!store.isTokenExpired()) {
      config.headers.Authorization = `Bearer ${store.userJwt}`
    }
    return config
  },
  function (error) {
    return Promise.reject(error)
  },
)

export default axiosInstance
