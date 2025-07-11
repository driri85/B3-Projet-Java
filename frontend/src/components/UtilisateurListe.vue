<template>
    <div>
      <h2>Utilisateurs & Listes</h2>
      <ul>
        <li v-for="l in liens" :key="l.utilisateur_id + '-' + l.liste_id">
          Utilisateur ID: {{ l.utilisateur_id }} - Liste ID: {{ l.liste_id }}
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  import axios from 'axios'
  export default {
    data() {
      return { liens: [] }
    },
    async mounted() {
      const res = await axios.get("http://localhost:8080/api/utilisateur-liste")
      this.liens = res.data
    }
  }
  </script>
  