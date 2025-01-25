import axios from 'axios'
import { useRouter } from 'vue-router'
import { useAuthStore } from '../stores/auth.store.js'

const axiosInstance = axios.create({
  baseURL: 'http://localhost:8080',
  timeout: 1000,
})

export default axiosInstance
