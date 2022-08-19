<script setup lang="ts">

const props = defineProps({
  text: {
    type: String,
    required: true,
  },
  href: {
    type: String,
    required: true,
  },
  liClasses: {
    type: String,
    required: false,
  },
  linkClasses: {
    type: String,
    required: false,
  },
});
</script>

<template>
  <li :class="props.liClasses" class="text-center py-1">
    <a :href="props.href" :class="props.linkClasses" class="inline-block w-full">{{ props.text }}</a>
  </li>
</template>
