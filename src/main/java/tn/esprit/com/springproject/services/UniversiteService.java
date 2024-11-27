package tn.esprit.com.springproject.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.com.springproject.Entities.Foyer;
import tn.esprit.com.springproject.Entities.Universite;
import tn.esprit.com.springproject.Repositories.FoyerRepository;
import tn.esprit.com.springproject.Repositories.UniversiteRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UniversiteService implements IUniversiteService{
    UniversiteRepository UniversiteRepository;
    FoyerRepository foyerRepository;

    @Override
    public List<Universite> retrieveAllUniversite() {
        return UniversiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite b) {
        return UniversiteRepository.save(b);
    }

    @Override
    public Optional<Universite> retrieveUniversiteById(Long id) {
        return UniversiteRepository.findById(id);
    }

    @Override
    public Universite updateUniversite(Universite b) {
        return UniversiteRepository.save(b);
    }

    @Override
    public void deleteUniversite(Long id) {
        UniversiteRepository.deleteById(id);
    }


    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Universite universite = UniversiteRepository.findUniversiteByNomUniversite(nomUniversite);
        // Vérifiez si l'université est trouvée
        if (universite == null) {
            throw new RuntimeException("Université non trouvée");
        }
        Foyer foyer = foyerRepository.findById(idFoyer)
                .orElseThrow(() -> new RuntimeException("Foyer non trouvé"));
        // Associer le foyer à l'université
        foyer.setUniversite(universite);// why does it work only like that ???? dima nsauvgardi  parent.setchild ()
        //on sauvegarde l'objet modifié
        foyerRepository.save(foyer);
        // Sauvegarder l'université. Le cascade prendra en charge la persistance de "Foyer"
        return universite;
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idFoyer) {
        Foyer foyer = foyerRepository.findById(idFoyer)
                .orElseThrow(() -> new RuntimeException("Foyer non trouvé"));
        Universite universite = foyer.getUniversite();
        foyer.setUniversite(null);  //parent.setchild
        foyerRepository.save(foyer);
        return universite;
}

}
