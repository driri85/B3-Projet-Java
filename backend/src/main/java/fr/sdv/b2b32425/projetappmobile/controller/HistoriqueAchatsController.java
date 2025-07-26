package fr.sdv.b2b32425.projetappmobile.controller;

import fr.sdv.b2b32425.projetappmobile.bo.Articles;
import fr.sdv.b2b32425.projetappmobile.bo.HistoriqueAchats;
import fr.sdv.b2b32425.projetappmobile.bo.Utilisateurs;
import fr.sdv.b2b32425.projetappmobile.repository.ArticlesRepository;
import fr.sdv.b2b32425.projetappmobile.repository.HistoriqueAchatsRepository;
import fr.sdv.b2b32425.projetappmobile.repository.UtilisateursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historique")
public class HistoriqueAchatsController {

    @Autowired
    private HistoriqueAchatsRepository repo;
    @Autowired
    private UtilisateursRepository utilisateursRepository;

    @Autowired
    private ArticlesRepository articlesRepository;


    @GetMapping
    public List<HistoriqueAchats> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoriqueAchats> getById(@PathVariable Integer id) {
        return repo.findById(Long.valueOf(id)).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/utilisateur/{id}")
    public ResponseEntity<List<HistoriqueAchats>> getAchatsParUtilisateur(@PathVariable Integer id) {
        List<HistoriqueAchats> achats = repo.findByUtilisateurId(id);
        return ResponseEntity.ok(achats);
    }


    @PostMapping
    public ResponseEntity<HistoriqueAchats> create(@RequestBody HistoriqueAchats achat) {
        Long userId = achat.getUtilisateur().getId().longValue();
        Long articleId = achat.getArticle().getId().longValue();

        Utilisateurs utilisateur = utilisateursRepository.findById(Math.toIntExact(userId)).orElse(null);
        Articles article = articlesRepository.findById(Math.toIntExact(articleId)).orElse(null);

        if (utilisateur == null || article == null) {
            return ResponseEntity.badRequest().build();
        }

        achat.setUtilisateur(utilisateur);
        achat.setArticle(article);

        HistoriqueAchats saved = repo.save(achat);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!repo.existsById(Long.valueOf(id))) return ResponseEntity.notFound().build();
        repo.deleteById(Long.valueOf(id));
        return ResponseEntity.noContent().build();
    }
}
