package tn.esprit.com.springproject.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "etudiant")
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEtudiant")
    private Long idEtudiant;
    private String nomEt;
    private String prenomEt;
    private Long cin;
    private String ecole;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @OneToOne
    private Universite universite;


    //its the parent cause mapped by is in reservations
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

    @OneToMany (mappedBy = "etudiant" , cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Tache> taches ;

    @OneToOne (mappedBy = "etudiantt")
    private Tache tache ;
}
