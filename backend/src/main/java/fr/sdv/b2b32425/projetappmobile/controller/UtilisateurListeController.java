package fr.sdv.b2b32425.projetappmobile.controller;

import fr.sdv.b2b32425.projetappmobile.bo.UtilisateurListe;
import fr.sdv.b2b32425.projetappmobile.bo.UtilisateurListeId;
import fr.sdv.b2b32425.projetappmobile.bo.Utilisateurs;
import fr.sdv.b2b32425.projetappmobile.repository.UtilisateursListeRepository;
import fr.sdv.b2b32425.projetappmobile.repository.UtilisateursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateur-liste")
public class UtilisateurListeController {

    @Autowired
    private UtilisateursListeRepository repo;

    @GetMapping
    public List<UtilisateurListe> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public UtilisateurListe create(@RequestBody UtilisateurListe ul) {
        return repo.save(ul);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody UtilisateurListeId id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
