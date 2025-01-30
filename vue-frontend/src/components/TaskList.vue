<template>
  <div class="w-full mt-6 max-w-xl bg-slate-600 p-4">
    <div class="flex justify-between items-center mb-4">
      <div class="flex-1"></div>
      <h1 class="text-white text-center text-2xl font-semibold flex-1">Task List</h1>
      <div class="text-white flex items-center gap-1 flex-1 justify-end">
        <div class="bg-slate-700 p-1 rounded-lg flex gap-1"> <!-- Contenedor para los botones -->
          <button @click="filter = 'all'" :class="[
            'px-3 py-1.5 rounded-md text-sm font-medium transition-all duration-200',
            filter === 'all'
              ? 'bg-blue-500 text-white shadow-sm'
              : 'text-gray-300 hover:bg-slate-600'
          ]">
            All
          </button>
          <button @click="filter = 'complete'" :class="[
            'px-3 py-1.5 rounded-md text-sm font-medium transition-all duration-200',
            filter === 'complete'
              ? 'bg-blue-500 text-white shadow-sm'
              : 'text-gray-300 hover:bg-slate-600'
          ]">
            Complete
          </button>
          <button @click="filter = 'incomplete'" :class="[
            'px-3 py-1.5 rounded-md text-sm font-medium transition-all duration-200',
            filter === 'incomplete'
              ? 'bg-blue-500 text-white shadow-sm'
              : 'text-gray-300 hover:bg-slate-600'
          ]">
            Incomplete
          </button>
        </div>
      </div>
    </div>

    <div v-for="task in list" :key="task.id">
      <div class="flex rounded shadow m-4 p-2 bg-slate-100 justify-between hover:shadow-2xl">
        <p class="text-lg flex-1">{{ task.description }}</p>
        <input type="checkbox" name="status" class="accent-indigo-600 transition-colors duration-200 scale-125 mr-3"
          @click="toggleTaskStatus(task.id)">
        <button class="bg-red-500 hover:bg-red-600 p-2 rounded shadow-md hover:scale-105 text-white"
          @click="deleteTask(task.id)">Delete</button>
      </div>
    </div>

  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import axiosInstance from '@/plugins/axios.js'

const list = ref()
const filter = ref('all')

onMounted(async () => {
  fetchTasks()
})

const fetchTasks = async () => {
  try {
    const response = await axiosInstance.get('/tasks', {
      params: {
        filter: filter.value
      }
    })
    list.value = response.data
  } catch (error) {
    console.error("Error fetching tasks: ", error);
  }

};

const toggleTaskStatus = async (taskId) => {
  try {
    const response = await axiosInstance.post(`/tasks/toggle/${taskId}`)
    console.log(response.data)
  } catch (error) {
    console.error("An error happened toggling task status: ", error);
  }
};

const deleteTask = async (taskId) => {
  try {
    const response = await axiosInstance.post(`/tasks/delete/${taskId}`)
    console.log(response.data)
    const updatedList = await axiosInstance.get('/tasks')
    list.value = updatedList.data
  } catch (error) {
    console.error("An error happened during task deletion: ", error);
  }
};
</script>
