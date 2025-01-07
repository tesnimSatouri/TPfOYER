package tn.esprit.com.springproject.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.com.springproject.Entities.*;
import tn.esprit.com.springproject.Repositories.ChambreRepository;
import tn.esprit.com.springproject.Repositories.TacheRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class ChambreService implements IChambreService{

    ChambreRepository chambreRepository;
    TacheRepository tacheRepository;

    @Override
    public List<Chambre> retrieveAllChambre() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre b) {
        return chambreRepository.save(b);
    }

    @Override
    public Optional<Chambre> retrieveChambreById(Long id) {
        return chambreRepository.findById(id);
    }

    @Override
    public Chambre updateChambre(Chambre b) {
        return chambreRepository.save(b);
    }

    @Override
    public void deleteChambre(Long id) {
    chambreRepository.deleteById(id);
    }

    @Override
    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) {
        // Recherche du nombre de chambres avec le type et l'id du bloc spécifiés
        return chambreRepository.countByTypeCAndBlocIdBloc(type, idBloc);
    }



    public String affecterMaintenance() {
            List<Chambre> chambres = chambreRepository.findAll();

            if (chambres.isEmpty()) {
                return "Aucune chambre avec des réservations.";
            }

            int nbtache = 0;

            for (Chambre chambre : chambres) {
                for (Reservation reservation : chambre.getReservations()) {

                    LocalDate dateReservation = new java.sql.Date(reservation.getAnneeUniversitaire().getTime()).toLocalDate();
                    TypeTache typeTache;

                    if (dateReservation.isAfter(LocalDate.now().minusDays(7))) {
                        typeTache = TypeTache.MENAGERE;
                    } else if (dateReservation.isAfter(LocalDate.now().minusDays(30))) {
                        typeTache = TypeTache.BRICOLAGE;
                    } else {
                        typeTache = TypeTache.JARDINAGE;
                    }
                    Tache tache = new Tache();
                    tache.setEtudiant(reservation.getEtudiants().iterator().next());
                    tache.setTypeTache(typeTache);
                    tache.setDateTache(LocalDate.now());
                    tache.setDuree(2);
                    tache.setTarifHoraire(50.0f);

                    tacheRepository.save(tache);
                    nbtache++;
                }
            }

            return nbtache + " tâches affectées.";
        }
    }




