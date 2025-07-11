<template>
    <div>
      <UtilisateurList />
      <hr />
      <ArticleList />
      <hr />
    </div>
  </template>
  
  <script>
  import UtilisateurList from '../components/UtilisateurList.vue'
  import ArticleList from '../components/ArticleList.vue'
  import HistoriqueList from '../components/HistoriqueList.vue'
  import UtilisateurListe from '../components/UtilisateurListe.vue'
  
  export default {
    components: {
      UtilisateurList,
      ArticleList,
      HistoriqueList,
      UtilisateurListe
    }
  }
  </script>
  