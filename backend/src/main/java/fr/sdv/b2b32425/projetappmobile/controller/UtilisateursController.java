package fr.sdv.b2b32425.projetappmobile.controller;

import fr.sdv.b2b32425.projetappmobile.bo.Utilisateurs;
import fr.sdv.b2b32425.projetappmobile.repository.UtilisateursRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateursController {

    @Autowired
    private UtilisateursRepository repo;

    @GetMapping
    public  List<Utilisateurs> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateurs> getById(@PathVariable Integer id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Utilisateurs create(@RequestBody Utilisateurs user) {
        return repo.save(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Utilisateurs> update(@PathVariable Integer id, @RequestBody Utilisateurs user) {
        return repo.findById(id).map(u -> {
            u.setNom(user.getNom());
            repo.save(u);
            return ResponseEntity.ok(u);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
