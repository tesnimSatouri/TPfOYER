package tn.esprit.com.springproject.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.com.springproject.Entities.Reservation;
import tn.esprit.com.springproject.Services.IReservationService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/reservation")
public class ReservationController {
    private final IReservationService ReservationService;

    // GET all Reservations
    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> Reservations = ReservationService.retrieveAllReservation();
        return new ResponseEntity<>(Reservations, HttpStatus.OK);
    }

    // GET a Reservation by ID
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable String id) {
        Optional<Reservation> Reservation = ReservationService.retrieveReservationById(id);
        return Reservation.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST a new Reservation
    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation Reservation) {
        Reservation createdReservation = ReservationService.addReservation(Reservation);
        return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
    }

    // PUT (update) an existing Reservation
    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable String id, @RequestBody Reservation Reservation) {
        if (!ReservationService.retrieveReservationById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Reservation.setIdReservation(id); // Set the ID to ensure the existing Reservation is updated
        Reservation updatedReservation = ReservationService.updateReservation(Reservation);
        return new ResponseEntity<>(updatedReservation, HttpStatus.OK);
    }

    //Update sans mettre un Id au path

    @PutMapping("/Update")
    public Reservation UpdateRes(@RequestBody Reservation u) {
        Reservation Reservation = ReservationService.addReservation(u);
        return Reservation;
    }

    // DELETE a Reservation by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable String id) {
        if (!ReservationService.retrieveReservationById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ReservationService.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> getReservationsParAnnee(
            @RequestParam("dateDebut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
            @RequestParam("dateFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {
        try {
            List<Reservation> reservations = ReservationService.getReservationParAnneeUniversitaire(dateDebut, dateFin);
            return new ResponseEntity<>(reservations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
