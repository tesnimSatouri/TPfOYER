package tn.esprit.com.springproject.Services;

import tn.esprit.com.springproject.Entities.Reservation;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IReservationService {
    List<Reservation> retrieveAllReservation();
    Reservation addReservation(Reservation b);
    Optional<Reservation> retrieveReservationById(String id);
    Reservation updateReservation(Reservation b);
    void deleteReservation(String id);

    public List<Reservation> getReservationParAnneeUniversitaire(Date dateDebut, Date dateFin ) ;
}
