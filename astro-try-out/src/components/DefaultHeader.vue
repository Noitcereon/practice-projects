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
              <a href="/">Home</a>
            </li>
            <li
              class="inline-block px-3 border-r-2 border-opacity-30 border-black"
            >
              <a href="about">Who am I</a>
            </li>
            <li
              class="inline-block px-3 border-r-2 border-opacity-30 border-black"
            >
              <a href="prices">Prices</a>
            </li>
            <li
              class="inline-block px-3 border-r-2 border-opacity-30 border-black"
            >
              <a href="contact">Contact</a>
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
  