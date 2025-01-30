<script setup>
import axiosInstance from '../plugins/axios.js'
import { ref } from 'vue'
import TaskList from "@/components/TaskList.vue";
import { useAuthStore } from '../stores/auth.store.js'
import { useRouter } from 'vue-router'

const taskContent = ref()
const router = useRouter()

async function createTask() {
  try {
    const response = await axiosInstance.post('/tasks', {
      description: taskContent.value
    })
    console.log("success task created")
    taskContent.value = ''
  } catch (error) {
    console.error('Hubo un error: ', error);
  }
};

const logout = () => {
  const store = useAuthStore()
  store.logout()
  router.push("/auth")
};
</script>

<template>
  <div class="">
    <nav class="bg-slate-600 shadow p-4 flex justify-between items-center">
      <h1 class="text-white font-bold text-center text-2xl">Todo List</h1>
      <button @click="logout" class="rounded shadow text-end text-white bg-slate-700 px-4 ml-auto">Logout</button>
    </nav>

    <main class="flex flex-col items-center justify-center">
      <div class="w-full max-w-xl bg-slate-600 mt-4 p-4">
        <form @submit.prevent="createTask">
          <h1 class="text-white text-center text-2xl font-semibold">Create Task</h1>
          <div class="mt-4 flex">
            <input v-model="taskContent" type="text" name="inputTask" id="inputTask"
              class="border rounded shadow p-1 grow">
            <button class="bg-blue-400 hover:bg-blue-500 rounded transition-colors p-2 text-white mx-2">Create</button>
          </div>
        </form>
      </div>

      <TaskList />

    </main>
  </div>
</template>
