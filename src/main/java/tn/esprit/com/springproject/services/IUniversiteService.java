package tn.esprit.com.springproject.Services;

import lombok.AllArgsConstructor;
import tn.esprit.com.springproject.Entities.Universite;

import java.util.List;
import java.util.Optional;


public interface IUniversiteService {

    List<Universite> retrieveAllUniversite();
    Universite addUniversite(Universite b);
    Optional<Universite> retrieveUniversiteById(Long id);
    Universite updateUniversite(Universite b);
    void deleteUniversite(Long id);

    Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite);

    Universite desaffecterFoyerAUniversite(long idFoyer);
}
