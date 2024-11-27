package tn.esprit.com.springproject.Controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.com.springproject.Entities.Chambre;
import tn.esprit.com.springproject.Entities.TypeChambre;
import tn.esprit.com.springproject.Services.IChambreService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chambreapi")
@AllArgsConstructor
public class ChambreController {
    private final IChambreService ChambreService;

    // GET all Chambres
    @GetMapping
    public ResponseEntity<List<Chambre>> getAllChambres() {
        List<Chambre> Chambres = ChambreService.retrieveAllChambre();
        return new ResponseEntity<>(Chambres, HttpStatus.OK);
    }

    // GET a Chambre by ID
    @GetMapping("/{id}")
    public ResponseEntity<Chambre> getChambreById(@PathVariable Long id) {
        Optional<Chambre> Chambre = ChambreService.retrieveChambreById(id);
        return Chambre.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST a new Chambre
    @PostMapping
    public ResponseEntity<Chambre> createChambre(@RequestBody Chambre Chambre) {
        Chambre createdChambre = ChambreService.addChambre(Chambre);
        return new ResponseEntity<>(createdChambre, HttpStatus.CREATED);
    }

    // PUT (update) an existing Chambre
    @PutMapping("/{id}")
    public ResponseEntity<Chambre> updateChambre(@PathVariable Long id, @RequestBody Chambre Chambre) {
        if (!ChambreService.retrieveChambreById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Chambre.setIdChambre(id); // Set the ID to ensure the existing Chambre is updated
        Chambre updatedChambre = ChambreService.updateChambre(Chambre);
        return new ResponseEntity<>(updatedChambre, HttpStatus.OK);
    }

    //Update sans mettre un Id au path

    @PutMapping("/UpdateUni")
    public Chambre UpdateUniversite(@RequestBody Chambre u) {
        Chambre Chambre = ChambreService.addChambre(u);
        return Chambre;
    }

    // DELETE a Chambre by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChambre(@PathVariable Long id) {
        if (!ChambreService.retrieveChambreById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ChambreService.deleteChambre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/nbParTypeEtBloc")
    public ResponseEntity<Long> getNbChambresParTypeEtBloc(@RequestParam TypeChambre type,
                                                           @RequestParam long idBloc) {
        long nbChambres = ChambreService.nbChambreParTypeEtBloc(type, idBloc);
        return new ResponseEntity<>(nbChambres, HttpStatus.OK);
    }
}
