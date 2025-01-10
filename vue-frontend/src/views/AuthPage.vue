<script setup>
import { useRouter } from 'vue-router'
import { useAuthStore } from "../stores/auth.store.js";
import { ref } from "vue";

const router = useRouter()
const isLoginModeActive = ref(true)

const formInfo = {
  mode: () => {
    return isLoginModeActive.value ? "Register" : "Login"
  },
  submitButton: () => {
    return !isLoginModeActive.value ? "Register" : "Login"
  },
  footer: () => {
    return isLoginModeActive.value ? "Don't have a user?" : "Alredy registered?"
  }
}

function switchFormMode() {
  isLoginModeActive.value = !isLoginModeActive.value
}

function login() {
  router.push("/main");
}

function onLoginSubmit() {

}
</script>

<template>
  <div class="min-h-screen items-center justify-center flex flex-col bg-gradient-to-b from-gray-50 to-gray-100">

    <div class="shadow-lg bg-white p-4 rounded w-full max-w-md">
      <h1 class="font-bold text-2xl text-center">Welcome</h1>
      <p class="text-center my-2 font-semibold text-gray-900">Todo List Frontend - Vue</p>
      <form @submit.prevent="login">
        <div class="my-4">
          <label for="username" class="block font-semibold text-sm mb-2 text-gray-900">Username</label>
          <input type="text" name="username" id="username" class="w-full rounded border shadow p-2"
            placeholder="Username">
        </div>

        <div class="my-4 w-full">
          <label for="password" class="block font-semibold text-sm mb-2 text-gray-900">Password</label>
          <input type="password" name="password" id="password" class="w-full rounded border shadow p-2"
            placeholder="Enter your password">
        </div>

        <button type="submit"
          class="w-full bg-blue-400 hover:bg-blue-500 transition-colors rounded px-2 py-2 text-white"> {{
            formInfo.submitButton() }} </button>

        <div class="flex justify-center mt-3">
          <p>{{ formInfo.footer() }}</p>
          <p class="text-blue-400 mx-2" @click="switchFormMode"> {{ formInfo.mode() }}</p>

        </div>
      </form>
    </div>

  </div>
</template>
