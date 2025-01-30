<template>
  <div class="w-full mt-6 max-w-xl bg-slate-600 p-4">
    <h1 class="text-white text-center text-2xl font-semibold">Task List</h1>

    <div v-for="task in list" :key="task.id">
      <div class="rounded shadow my-3 p-2">
        <p>{{ task.description }}</p>
        <input type="checkbox" name="status">
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
</script>
