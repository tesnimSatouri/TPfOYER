package tn.esprit.com.springproject.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.com.springproject.Entities.Foyer;
import tn.esprit.com.springproject.Entities.Universite;
import tn.esprit.com.springproject.Services.IFoyerService;
import tn.esprit.com.springproject.Services.IUniversiteService;

@RestController
@AllArgsConstructor
@RequestMapping("/foy")

public class FoyerController {
    IFoyerService foyerService;
     IUniversiteService universiteService;
    @PutMapping("/affecterFoyerAUniversite/{idFoyer}/{nomUniversite}")
    @ResponseBody
    public Universite affecterFoyerAUniversite(@PathVariable long idFoyer, @PathVariable String nomUniversite)
    {
        Universite universiteCreated = universiteService.affecterFoyerAUniversite(idFoyer, nomUniversite);
        return universiteCreated;
    }
    @PostMapping("/Addfoy")
    public Foyer Addfoy(@RequestBody Foyer u) {
        Foyer foyer = foyerService.addFoyer(u);
        return foyer;
    }
    @PostMapping("/AddFoyerAndItsBlocs")
    @ResponseBody
    public Foyer AddFoyerAndItsBlocs(@RequestBody Foyer f)
    {
        Foyer foyer=foyerService.AddFoyerAndBlocsAssocie(f);
        return foyer;
    }

    @PutMapping("/desaffecter-foyer/{idFoyer}")
    public Universite desaffecterFoyerAUniversite(@PathVariable long idFoyer) {
        return universiteService.desaffecterFoyerAUniversite(idFoyer);
}
}
