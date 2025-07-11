<template>
    <div>
      <h2>Articles</h2>
      <ul>
        <li v-for="article in articles" :key="article.id">
          <strong>{{ article.nom }}</strong> - {{ article.quantite }} ({{ article.categorie }})
          <span v-if="article.est_achete">✅</span>
          <span v-else>🛒</span>
          <p><em>{{ article.notes }}</em></p>
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  import axios from 'axios'
  export default {
    data() {
      return { articles: [] }
    },
    async mounted() {
      const res = await axios.get("http://localhost:8080/api/articles")
      this.articles = res.data
    }
  }
  </script>
  