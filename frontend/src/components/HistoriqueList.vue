<template>
    <div>
      <h2>Historique des achats</h2>
      <ul>
        <li v-for="h in historique" :key="h.id">
          Article ID: {{ h.article_id }} | Utilisateur ID: {{ h.utilisateur_id }} | Date: {{ h.date_achat || 'Non précisée' }}
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  import axios from 'axios'
  export default {
    data() {
      return { historique: [] }
    },
    async mounted() {
      const res = await axios.get("https://java-backend.arsdv.site/api/historique")
      this.historique = res.data
    }
  }
  </script>
  