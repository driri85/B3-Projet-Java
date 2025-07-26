<template>
  <div>
    <h2>Liste des utilisateurs</h2>
    <ul>
      <li v-for="u in utilisateurs" :key="u.id">
        <router-link :to="'/utilisateurs/' + u.id">{{ u.nom }}</router-link>
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      utilisateurs: []
    }
  },
  async mounted() {
    const res = await axios.get('https://java-backend.arsdv.site/api/utilisateurs')
    this.utilisateurs = res.data
  }
}
</script>
