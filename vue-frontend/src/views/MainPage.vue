<script setup>

</script>

<template>
  <div class="">
    <nav class="bg-slate-600 shadow p-4">
      <h1 class="text-white font-bold text-center text-2xl">Todo List</h1>
    </nav>

    <main class="flex flex-col items-center justify-center">
      <div class="w-full max-w-xl bg-slate-600 mt-4 p-4">
        <form>
          <h1 class="text-white text-center text-2xl font-semibold">Create Task</h1>
          <div class="mt-4 flex">
            <input type="text" name="inputTask" id="inputTask" class="border rounded shadow p-1 grow">
            <button class="bg-blue-400 hover:bg-blue-500 rounded transition-colors p-2 text-white mx-2">Create</button>
          </div>
        </form>
      </div>

      <div class="w-full mt-6 max-w-xl bg-slate-600 p-4">
        <h1 class="text-white text-center text-2xl font-semibold">Task List</h1>
      </div>

    </main>
  </div>
</template>
