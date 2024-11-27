package tn.esprit.com.springproject.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.com.springproject.Entities.Universite;
import tn.esprit.com.springproject.Services.IUniversiteService;
import tn.esprit.com.springproject.Services.UniversiteService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/Uni")

public class UniversiteController {
  IUniversiteService universiteService;


    @GetMapping("/GetAllUniversite")
    public List<Universite> getUniversites() {
        List<Universite> listUniversites = universiteService.retrieveAllUniversite();
        return listUniversites;
    }
    @GetMapping("/GetById/{id}")
    public Optional<Universite> retrieveUniversite(@PathVariable("id") Long idU) {
        return universiteService.retrieveUniversiteById(idU);
    }

    @PostMapping("/AddUni")
    public Universite addUniversite(@RequestBody Universite u) {
        Universite universite = universiteService.addUniversite(u);
        return universite;
    }
    @PutMapping("/UpdateUni")
    public Universite UpdateUniversite1(@RequestBody Universite u) {
        Universite universite = universiteService.addUniversite(u);
        return universite;
    }

    @PutMapping("/UpdateUni/{id}")
    public ResponseEntity<Universite> UpdateUniversite2(@PathVariable Long id, @RequestBody Universite universite) {
        if (!universiteService.retrieveUniversiteById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        universite.setIdUniversite(id);
        Universite updatedBloc = universiteService.updateUniversite(universite);
        return new ResponseEntity<>(updatedBloc, HttpStatus.OK);
    }

    @DeleteMapping("/remove-uni/{uni-id}")
    public void removeUni(@PathVariable("uni-id") Long id) {
        universiteService.deleteUniversite(id);
    }



    @PutMapping("/affecterFoyerAUniversite/{idFoyer}/{nomUniversite}")
    @ResponseBody
    public Universite affecterFoyerAUniversite(
            @PathVariable long idFoyer,
            @PathVariable String nomUniversite
    ) {
        Universite universiteCreated = universiteService.affecterFoyerAUniversite(idFoyer, nomUniversite);
        return universiteCreated;
    }


}
