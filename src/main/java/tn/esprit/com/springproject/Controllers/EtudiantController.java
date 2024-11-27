package tn.esprit.com.springproject.Controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.com.springproject.Entities.Etudiant;
import tn.esprit.com.springproject.Entities.Tache;
import tn.esprit.com.springproject.Services.IEtudiantService;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantController {
    private final IEtudiantService EtudiantService;

    // GET all Etudiants
    @GetMapping
    public ResponseEntity<List<Etudiant>> getAllEtudiants() {
        List<Etudiant> Etudiants = EtudiantService.retrieveAllEtudiant();
        return new ResponseEntity<>(Etudiants, HttpStatus.OK);
    }

    // GET a Etudiant by ID
    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable Long id) {
        Optional<Etudiant> Etudiant = EtudiantService.retrieveEtudiantById(id);
        return Etudiant.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST a new Etudiant
    @PostMapping
    public ResponseEntity<Etudiant> createEtudiant(@RequestBody Etudiant Etudiant) {
        Etudiant createdEtudiant = EtudiantService.addEtudiant(Etudiant);
        return new ResponseEntity<>(createdEtudiant, HttpStatus.CREATED);
    }

    // PUT (update) an existing Etudiant
    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable Long id, @RequestBody Etudiant Etudiant) {
        if (!EtudiantService.retrieveEtudiantById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Etudiant.setIdEtudiant(id); // Set the ID to ensure the existing Etudiant is updated
        Etudiant updatedEtudiant = EtudiantService.updateEtudiant(Etudiant);
        return new ResponseEntity<>(updatedEtudiant, HttpStatus.OK);
    }

    //Update sans mettre un Id au path

    @PutMapping("/Update")
    public Etudiant UpdateEtud(@RequestBody Etudiant u) {
        Etudiant Etudiant = EtudiantService.addEtudiant(u);
        return Etudiant;
    }

    // DELETE a Etudiant by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable Long id) {
        if (!EtudiantService.retrieveEtudiantById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        EtudiantService.deleteEtudiant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping("/affecter-taches")
    public ResponseEntity<List<Tache>> addTasksAndAffectToEtudiant(
            @RequestBody List<Tache> taches,
            @RequestParam String nomEt,
            @RequestParam String prenomEt) {
        try {
            List<Tache> updatedTaches = EtudiantService.addTasksAndAffectToEtudiant(taches, nomEt, prenomEt);
            return new ResponseEntity<>(updatedTaches, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/calculMontantInsc")
    public ResponseEntity<HashMap<String, Float>> calculMontantPourTous() {
        try {
            HashMap<String, Float> result = EtudiantService.calculNouveauMontantInscriptionDesEtudiants();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
