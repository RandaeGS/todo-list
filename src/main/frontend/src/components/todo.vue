<script setup>

</script>

<template>
  <div class="flex flex-col items-center justify-center h-screen">
    <div id="add" class="p-4 shadow w-9/12 bg-white mb-4 rounded">
      <h1 class="text-center font-semibold mb-2 text-lg">Add task</h1>
      <form @submit.prevent="" class="flex">
        <input type="text" name="task" id="task" placeholder="Enter new task here" class="border rounded p-1 flex-grow">
        <button type="submit" class="bg-blue-400 rounded p-2 mx-2 hover:bg-blue-500 transition-colors">Add</button>
      </form>
    </div>

    <div id="list" class="p-4 shadow w-9/12 bg-white rounded">
      <h1>List</h1>
    </div>

  </div>
</template>
