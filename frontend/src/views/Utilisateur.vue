<template>
    <UtilisateurDetail :id="id" />
  </template>
  
  <script>
  import UtilisateurDetail from '../components/UtilisateurDetail.vue'
  
  export default {
    components: { UtilisateurDetail },
    props: ['id']
  }
  </script>
  