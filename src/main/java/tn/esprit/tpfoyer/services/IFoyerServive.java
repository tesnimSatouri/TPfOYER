package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entities.Foyer;

import java.util.List;

//@FieldDefaults(level = AccessLevel.PUBLIC)
public interface IFoyerServive {
    Foyer addFoyer (Foyer foyer);
    void DeleteFoyer (Long IdFoyer);
    Foyer updateFoyer (Foyer foyer);
    List<Foyer> getAllFoyer ();
    Foyer retrieveFoyer(Long idFoyer);
}
