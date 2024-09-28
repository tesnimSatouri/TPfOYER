package tn.esprit.tpfoyer.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    private String idReservation;
    @Temporal(TemporalType.DATE)
    private Date anneeUniversitaire;
    private boolean estValide;


    @ManyToMany (cascade = CascadeType.ALL , mappedBy = "reservations")
    private Set<Etudiant> etudiants ;


}