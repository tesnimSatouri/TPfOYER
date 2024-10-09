package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entities.Etudiant;

import java.util.List;

//@FieldDefaults(level = AccessLevel.PUBLIC)
public interface IEtudiantService {
    Etudiant addEtudiant (Etudiant etudiant);
    void deleteEtudiant (Long IdEtudiant);
    Etudiant updateEtudiant (Etudiant etudiant);
    List<Etudiant> getAllEtudiant ();
    Etudiant retrieveEtudiant (Long idEtudiant);
}
