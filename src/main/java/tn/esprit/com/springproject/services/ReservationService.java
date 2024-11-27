package tn.esprit.com.springproject.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.com.springproject.Entities.Reservation;
import tn.esprit.com.springproject.Repositories.ReservationRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService{
    
    ReservationRepository reservationRepository;
    @Override
    public List<Reservation> retrieveAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public  Reservation addReservation(Reservation b) {
        return reservationRepository.save(b);
    }

    @Override
    public Optional<Reservation> retrieveReservationById(String id) {
        return reservationRepository.findById(id);
    }

    @Override
    public Reservation updateReservation(Reservation b) {
        return reservationRepository.save(b);
    }

    @Override
    public void deleteReservation(String id) {
        reservationRepository.deleteById(id);
    }


    @Override
    public List<Reservation> getReservationParAnneeUniversitaire(Date dateDebut, Date dateFin) {
        return reservationRepository.findByAnneeUniversitaireBetween(dateDebut, dateFin);
    }



}
