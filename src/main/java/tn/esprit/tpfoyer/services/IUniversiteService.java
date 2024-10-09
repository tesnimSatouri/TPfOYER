package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entities.Universite;

import java.util.List;

//@FieldDefaults(level = AccessLevel.PUBLIC)
public interface IUniversiteService {
    Universite addUniversite (Universite universite);
    void deleteUniversite (Long idUniversite);
    Universite updateUniversite (Universite universite);
    List<Universite> getAllUniversite ();
    Universite retrieveUniversite(Long idUniversite);
}
