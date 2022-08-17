import { defineNuxtConfig } from "nuxt";
import { loadEnv } from "vite";

const mode = ""
process.env = { ...process.env, ...loadEnv(mode, process.cwd()) };

// https://v3.nuxtjs.org/api/configuration/nuxt.config
export default defineNuxtConfig({
  modules: ["@nuxtjs/tailwindcss"],
  baseUrl: process.env.NUXT_APP_BASE_URL,
});
