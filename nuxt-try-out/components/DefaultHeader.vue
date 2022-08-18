<script lang="ts" setup>
const props = defineProps({
  currentPage: {
    type: String,
    required: true,
  },
});
</script>

<template>
  <header class="lg:max-w-6xl lg:mx-auto mb-5">
    <div class="container flex p-4 mx-auto">
      <div class="container flex justify-start items-center lg:hidden">
        <h1 class="text-2xl">{{ props.currentPage }}</h1>
      </div>
      <nav>
        <ul>
          <li
            class="inline-block px-3 border-r-2 border-opacity-30 border-black"
          >
            <router-link to="/">Home</router-link>
          </li>
          <li
            class="inline-block px-3 border-r-2 border-opacity-30 border-black"
          >
            <router-link to="about">Who am I</router-link>
          </li>
          <li
            class="inline-block px-3 border-r-2 border-opacity-30 border-black"
          >
            <router-link to="prices">Prices</router-link>
          </li>
          <li
            class="inline-block px-3 border-r-2 border-opacity-30 border-black"
          >
            <router-link to="contact">Contact</router-link>
          </li>
        </ul>
      </nav>
      <div class="container flex justify-end flex-1">
        <span>Menu button or something</span>
      </div>
    </div>
  </header>
</template>

<style scoped></style>
