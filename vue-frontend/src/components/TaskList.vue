<template>
  <div class="w-full mt-6 max-w-xl bg-slate-600 p-4">
    <h1 class="text-white text-center text-2xl font-semibold">Task List</h1>

    <div v-for="task in list" :key="task.id">
      <div class="flex rounded shadow m-4 p-2 bg-slate-100 justify-between">
        <p class="">{{ task.description }}</p>
        <input type="checkbox" name="status" @click="toggleTaskStatus(task.id)">
      </div>
    </div>

  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import axiosInstance from '@/plugins/axios.js'

const list = ref()

onMounted(async () => {
  try {
    const response = await axiosInstance.get('/tasks')
    console.log("Fetch: ", response)
    list.value = response.data
  } catch (error) {
    console.error("Error fetching tasks: ", error);
  }
})

const toggleTaskStatus = async (taskId) => {
  try {
    const response = await axiosInstance.post(`/tasks/toggle/${taskId}`)
    console.log(response.data)
  } catch (error) {
    console.error("An error happened toggling task status: ", error);
  }
};
</script>
