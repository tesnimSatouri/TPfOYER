package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entities.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation addReservation ( Reservation reservation);
    void DeleteReservation (String IdReservation);
    Reservation updateReservation ( Reservation reservation);
    List< Reservation> getAllReservation ();
    Reservation retrieveReservation (String idReservation);
}
