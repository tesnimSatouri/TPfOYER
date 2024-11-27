package tn.esprit.com.springproject.Services;

import tn.esprit.com.springproject.Entities.Tache;

import java.util.List;
import java.util.Optional;

public interface ITacheService {
    List<Tache> retrieveAllTache();
    Tache addTache(Tache b);
    Optional<Tache> retrieveTacheById(Long id);
    Tache updateTache(Tache b);
    void deleteTache(Long id);
}
