package fr.sdv.b2b32425.projetappmobile.controller;

import fr.sdv.b2b32425.projetappmobile.bo.Articles;
import fr.sdv.b2b32425.projetappmobile.bo.Utilisateurs;
import fr.sdv.b2b32425.projetappmobile.repository.ArticlesRepository;
import fr.sdv.b2b32425.projetappmobile.repository.UtilisateursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/articles")
public class ArticlesController {

    @Autowired
    private ArticlesRepository repo;

    @GetMapping
    public List<Articles> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Articles> getById(@PathVariable Integer id) {
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Articles create(@RequestBody Articles article) {
        return repo.save(article);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Articles> update(@PathVariable Integer id, @RequestBody Articles article) {
        return repo.findById(id).map(a -> {
            a.setNom(article.getNom());
            a.setCategorie(article.getCategorie());
            a.setQuantite(article.getQuantite());
            a.setNotes(article.getNotes());
            a.setEstAchete(article.isEstAchete());
            return ResponseEntity.ok(repo.save(a));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
