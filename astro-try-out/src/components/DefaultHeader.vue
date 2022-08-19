<script lang="ts" setup>
import { ref } from 'vue';
import MenuLink from './MenuLink.vue';

const props = defineProps({
  currentPage: {
    type: String,
    required: true,
  },
});
let mobileNavIsHidden = ref(true);
function toggleMobileNav(){
  console.log("toggle triggered")
  mobileNavIsHidden.value = !mobileNavIsHidden.value;
}
</script>

<template>
  <header class="lg:max-w-6xl lg:mx-auto mb-5 bg-yellow-100">
    <div class="container flex p-4 mx-auto">
      <div class="container flex justify-start items-center lg:hidden">
        <h1 class="text-2xl">{{ props.currentPage }}</h1>
      </div>
      <nav class="hidden md:block">
        <ul>
          <li
            class="inline-block px-3 border-r-2 border-opacity-30 border-black"
          >
            <a href="/">Home</a>
          </li>
          <li
            class="inline-block px-3 border-r-2 border-opacity-30 border-black"
          >
            <a href="/about">Who am I</a>
          </li>
          <li
            class="inline-block px-3 border-r-2 border-opacity-30 border-black"
          >
            <a href="/prices">Prices</a>
          </li>
          <li
            class="inline-block px-3 border-r-2 border-opacity-30 border-black"
          >
            <a href="/contact">Contact</a>
          </li>
        </ul>
      </nav>
      <nav :class="{ hidden: mobileNavIsHidden }" class="bg-yellow-600 absolute top-20 right-0 w-52" @click="toggleMobileNav">
        <ul>
          <MenuLink text="Home" href="/"></MenuLink>
          <MenuLink text="About" href="/about"></MenuLink>
          <MenuLink text="Prices" href="/prices"></MenuLink>
          <MenuLink text="Contact" href="/contact"></MenuLink>
        </ul>
      </nav>
      <div
        class="container flex justify-end flex-1"
        @click="toggleMobileNav"
      >
        <span class="text-orange-400 font-bold">Menu Button</span>
      </div>
    </div>
  </header>
</template>

<style scoped></style>
