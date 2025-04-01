<script setup>
import { RouterLink, RouterView } from 'vue-router'
import NavHeader from './layout/Header.vue';
</script>

<template>

  <div id="app" class="container">
    <nav-header></nav-header>

    <RouterView></RouterView>
  </div>


</template>

<style scoped>
</style>
