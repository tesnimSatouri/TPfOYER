package tn.esprit.com.springproject.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.com.springproject.Entities.Etudiant;
import tn.esprit.com.springproject.Entities.Reservation;
import tn.esprit.com.springproject.Entities.Tache;
import tn.esprit.com.springproject.Repositories.EtudiantRepository;
import tn.esprit.com.springproject.Repositories.ReservationRepository;
import tn.esprit.com.springproject.Repositories.TacheRepository;

import java.util.*;

@Service
@AllArgsConstructor
public class EtudiantService implements IEtudiantService{

    EtudiantRepository EtudiantRepository;
    ReservationRepository ReservationRepository;
    TacheRepository taskRepository;
    @Override
    public List<Etudiant> retrieveAllEtudiant() {
        return EtudiantRepository.findAll();
    }

    @Override
    public  Etudiant addEtudiant(Etudiant b) {
        return EtudiantRepository.save(b);
    }

    @Override
    public Optional<Etudiant> retrieveEtudiantById(Long id) {
        return EtudiantRepository.findById(id);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant b) {
        return EtudiantRepository.save(b);
    }

    @Override
    public void deleteEtudiant(Long id) {
        EtudiantRepository.deleteById(id);
    }

    //for many to many
    @Override
    public Etudiant affecterEtudiantAReservation(String nomEt, String prenomEt, String idReservation) {
        Etudiant e = EtudiantRepository.findByNomEtAndPrenomEt (nomEt , prenomEt ) ;
        Reservation r = ReservationRepository.findByIdReservation(idReservation);
        //Etudiant is the parent me fihesh mappedby
        Set<Reservation> reservationsMisesAJour = new HashSet<Reservation>();
        if(e.getReservations()!=null) {
            reservationsMisesAJour = e.getReservations();
        }
        reservationsMisesAJour.add(r);
        e.setReservations(reservationsMisesAJour);
        EtudiantRepository.save(e);

        return e;


    }
@Override
    public List<Tache> addTasksAndAffectToEtudiant(List<Tache> tasks, String nomEt, String prenomEt) {
        // Trouver l'étudiant par nom et prénom
        Etudiant etudiant = EtudiantRepository.findByNomEtAndPrenomEt(nomEt, prenomEt);
        if (etudiant == null) {
            throw new RuntimeException("Étudiant introuvable avec le nom " + nomEt + " et le prénom " + prenomEt);
        }

        // Associer chaque tâche à l'étudiant et sauvegarder
        tasks.forEach(task -> {
            task.setEtudiant(etudiant);
            taskRepository.save(task);
        });

        return tasks;
    }


    @Override
    public HashMap<String, Float> calculNouveauMontantInscriptionDesEtudiants() {
        List<Etudiant> etudiants = EtudiantRepository.findAll(); // Récupère tous les étudiants
        HashMap<String, Float> result = new HashMap<>();

        for (Etudiant etudiant : etudiants) {
            Set<Tache> taches = etudiant.getTaches();
            float nouveauMontant = 0;

            for (Tache tache : taches) {
                nouveauMontant += tache.getDuree() * tache.getTarifHoraire();
            }

            result.put(etudiant.getNomEt(), nouveauMontant);
        }

        return result;
}

}



