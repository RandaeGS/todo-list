<script setup>

</script>

<template>
  <div class="min-h-screen bg-gradient-to-b from-gray-100 to-gray-200 flex items-center justify-center">
    <div class="shadow rounded bg-white">
      <form @submit.prevent="">
        <div>
          <label for="username">Username</label>
          <input type="text" id="username" name="username" class="rounded p-1">
        </div>

        <div>
          <label for="password">Password</label>
          <input type="password" id="password" name="password" class="rounded p-1">
        </div>

      </form>
    </div>
  </div>
</template>
