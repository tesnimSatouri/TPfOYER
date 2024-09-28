package tn.esprit.tpfoyer.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "etudiant")
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;
    private String nomE;
    private String prenomE;
    private Long cin;
    private String ecole;
    @Temporal(TemporalType.DATE) //naamelha besh m tsiresh moshkla when persisting data
    private Date dateNaissance;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

    @OneToMany (cascade = CascadeType.ALL , mappedBy = "etudiant")
    private Set<Tache> taches ;
}
