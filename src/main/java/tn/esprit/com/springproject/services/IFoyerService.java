package tn.esprit.com.springproject.Services;

import tn.esprit.com.springproject.Entities.Foyer;

import java.util.List;
import java.util.Optional;

public interface IFoyerService {
    List<Foyer> retrieveAllFoyer();
    Foyer addFoyer(Foyer b);
    Optional<Foyer> retrieveFoyerById(Long id);
    Foyer updateFoyer(Foyer b);
    void deleteFoyer(Long id);

    Foyer AddFoyerAndBlocsAssocie(Foyer f);
}
