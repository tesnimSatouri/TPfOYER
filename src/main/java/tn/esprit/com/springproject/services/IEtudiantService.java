package tn.esprit.com.springproject.Services;

import tn.esprit.com.springproject.Entities.Etudiant;
import tn.esprit.com.springproject.Entities.Tache;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface IEtudiantService {
    List<Etudiant> retrieveAllEtudiant();

    Etudiant addEtudiant(Etudiant b);

    Optional<Etudiant> retrieveEtudiantById(Long id);

    Etudiant updateEtudiant(Etudiant b);

    void deleteEtudiant(Long id);

    Etudiant affecterEtudiantAReservation (String nomEt, String prenomEt, String idReservation) ;
    public List<Tache> addTasksAndAffectToEtudiant(List<Tache> tasks, String nomEt, String prenomEt);


    HashMap<String, Float> calculNouveauMontantInscriptionDesEtudiants();
}
