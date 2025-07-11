<template>
    <div v-if="utilisateur">
      <h2>Détail utilisateur : {{ utilisateur.nom }}</h2>
      <p>Email: {{ utilisateur.email }}</p>
      <p>Date création: {{ utilisateur.dateCreation }}</p>
  
      <button class="modal-btn" @click="showModal = true">
        ➕ Ajouter un article à l’historique
      </button>
  
      <div v-for="element in liste_achat" :key="element.id" class="achat-card">
        <div class="achat-card-header">
    <h3>{{ element.article.nom }}</h3>
    <button class="delete-btn" @click="supprimerArticle(element.id)" title="Supprimer">
      🗑️
    </button>
  </div>
        <ul>
          <li><strong>Quantité :</strong> {{ element.article.quantite }}</li>
          <li><strong>Note :</strong> {{ element.article.notes }}</li>
        </ul>
      </div>
  
      <!-- MODALE -->
      <div v-if="showModal" class="modal-overlay">
        <div class="modal-box">
          <h3 class="text-lg font-bold mb-4">Ajouter un article</h3>
  
          <label for="article" class="block mb-2">Choisir un article :</label>
          <select v-model="selectedArticleId" id="article" class="w-full mb-4 p-2 border rounded">
            <option v-for="a in articles" :key="a.id" :value="a.id">
              {{ a.nom }} - {{ a.quantite }}
            </option>
          </select>
  
          <div class="flex justify-end space-x-2">
            <button class="bg-gray-300 px-4 py-2 rounded" @click="showModal = false">Annuler</button>
            <button class="bg-green-600 text-white px-4 py-2 rounded" @click="ajouterArticle">
              Ajouter
            </button>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios'
  
  export default {
    props: ['id'],
    data() {
      return {
        utilisateur: null,
        liste_achat: null,
        articles: [],
        selectedArticleId: null,
        showModal: false
      }
    },
    async mounted() {
      try {
        const [utilisateurRes, listeAchatRes, articlesRes] = await Promise.all([
          axios.get(`http://localhost:8080/api/utilisateurs/${this.id}`),
          axios.get(`http://localhost:8080/api/historique/utilisateur/${this.id}`),
          axios.get(`http://localhost:8080/api/articles`)
        ])
  
        this.utilisateur = utilisateurRes.data
        this.liste_achat = listeAchatRes.data
        this.articles = articlesRes.data
      } catch (error) {
        console.error('Erreur lors du chargement des données :', error)
      }
    },
    methods: {
      async ajouterArticle() {
        if (!this.selectedArticleId) return alert("Veuillez sélectionner un article.")
  
        try {
          await axios.post('http://localhost:8080/api/historique', {
            utilisateur: { id: this.utilisateur.id },
            article: { id: this.selectedArticleId }
          })
  
          alert("✅ Article ajouté à l'historique !")
          this.showModal = false
          this.selectedArticleId = null
          // Optionnel : recharger la liste après ajout
          const res = await axios.get(`http://localhost:8080/api/historique/utilisateur/${this.id}`)
          this.liste_achat = res.data
        } catch (err) {
          alert("❌ Erreur lors de l'ajout.")
          console.error(err)
        }
      },
      async supprimerArticle(id) {
    const confirmDelete = confirm("Voulez-vous vraiment supprimer cet article de l'historique ?")
    if (!confirmDelete) return

    try {
      await axios.delete(`http://localhost:8080/api/historique/${id}`)
      this.liste_achat = this.liste_achat.filter(item => item.id !== id)
    } catch (err) {
      alert("❌ Erreur lors de la suppression.")
      console.error(err)
    }
    
  }
    }
  }


  </script>
  
  <style scoped>
  .achat-card {
    border: 1px solid #ccc;
    border-radius: 8px;
    padding: 1rem;
    margin-bottom: 1rem;
    background-color: #f9f9f9;
    box-shadow: 0 2px 5px rgba(0,0,0,0.1);
    transition: transform 0.2s;
  }
  .achat-card:hover {
    transform: scale(1.02);
  }
  .achat-card h3 {
    margin: 0 0 0.5rem 0;
    color: #333;
  }
  .achat-card ul {
    list-style: none;
    padding: 0;
    margin: 0;
  }
  .achat-card li {
    margin: 0.3rem 0;
  }
  
  /* Pour modale */
  .fixed {
    position: fixed;
  }
  .inset-0 {
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
  }
  .z-50 {
    z-index: 50;
  }

  .modal-btn {
  margin-top: 1rem;
  padding: 0.5rem 1rem;
  background-color: #2a72f8;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 9999;
}

.modal-box {
  background-color: white;
  padding: 2rem;
  border-radius: 8px;
  width: 90%;
  max-width: 400px;
  box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3);
}

.modal-box h3 {
  margin-top: 0;
  margin-bottom: 1rem;
}

.modal-box select {
  width: 100%;
  padding: 0.5rem;
  margin-bottom: 1rem;
}

.modal-buttons {
  display: flex;
  justify-content: flex-end;
  gap: 10px;
}

.modal-buttons button {
  padding: 0.5rem 1rem;
  border: none;
  cursor: pointer;
  border-radius: 4px;
}

.modal-buttons button:first-child {
  background-color: #ccc;
}

.modal-buttons button:last-child {
  background-color: #28a745;
  color: white;
}

  </style>
  