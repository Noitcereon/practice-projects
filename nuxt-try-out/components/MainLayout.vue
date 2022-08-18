<script setup lang="ts">
const props = defineProps({
  currentPage: {
    type: String,
    required: true,
  },
});
</script>

<template>
    <slot name="header">
      <!-- Defaults to this, if header slot is not given -->
      <DefaultHeader :current-page="props.currentPage" />
    </slot>

  <main
    class="flex flex-col items-center px-4 mx-auto lg:max-w-6xl min-h-screen"
  >
    <slot>
      <!-- Defaults to this, if main slot is not given -->
      <p>
        <!-- The below escaped characters (&#139 and &#155) are '<' and '>' respectively. -->
        This is the fallback &#139;main&#155; content of primaryLayout.vue. It
        should not be displayed.
      </p>
    </slot>
  </main>

  <footer>
    <slot name="footer">
      <!-- Defaults to this, if footer slot is not given -->
      <DefaultFooter />
    </slot>
  </footer>
</template>
