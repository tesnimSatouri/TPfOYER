package tn.esprit.com.springproject.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.com.springproject.Entities.Bloc;
import tn.esprit.com.springproject.Services.BlocService;
import tn.esprit.com.springproject.Services.IBlocService;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api/bloc")
@AllArgsConstructor


public class BlocController {
    private final IBlocService blocService;

    // GET all Blocs
    @GetMapping
    public ResponseEntity<List<Bloc>> getAllBlocs() {
        List<Bloc> blocs = blocService.retrieveAllBloc();
        return new ResponseEntity<>(blocs, HttpStatus.OK);
    }

    // GET a Bloc by ID
    @GetMapping("/{id}")
    public ResponseEntity<Bloc> getBlocById(@PathVariable Long id) {
        Optional<Bloc> bloc = blocService.retrieveBlocById(id);
        return bloc.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST a new Bloc
    @PostMapping
    public ResponseEntity<Bloc> createBloc(@RequestBody Bloc bloc) {
        Bloc createdBloc = blocService.addBloc(bloc);
        return new ResponseEntity<>(createdBloc, HttpStatus.CREATED);
    }

    // PUT (update) an existing Bloc
    @PutMapping("/{id}")
    public ResponseEntity<Bloc> updateBloc(@PathVariable Long id, @RequestBody Bloc bloc) {
        if (!blocService.retrieveBlocById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        bloc.setIdBloc(id); // Set the ID to ensure the existing Bloc is updated
        Bloc updatedBloc = blocService.updateBloc(bloc);
        return new ResponseEntity<>(updatedBloc, HttpStatus.OK);
    }

    //Update sans mettre un Id au path

    @PutMapping("/UpdateUni")
    public Bloc UpdateUniversite(@RequestBody Bloc u) {
        Bloc bloc = blocService.addBloc(u);
        return bloc;
    }

    // DELETE a Bloc by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBloc(@PathVariable Long id) {
        if (!blocService.retrieveBlocById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blocService.deleteBloc(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/affecter-chambres/{nomBloc}")
    public ResponseEntity<Bloc> affecterChambresABloc(@PathVariable String nomBloc,
                                                      @RequestBody List<Long> numChambre) {
        try {
            Bloc updatedBloc = blocService.affecterChambresABloc(numChambre, nomBloc);
            return new ResponseEntity<>(updatedBloc, HttpStatus.OK);
        } catch (RuntimeException e) {
            // Handle any error that may occur (e.g., Bloc or Chambres not found)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }



}
