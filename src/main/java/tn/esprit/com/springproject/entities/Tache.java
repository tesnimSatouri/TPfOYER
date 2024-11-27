package tn.esprit.com.springproject.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name="Tache")
public class Tache implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTache ;

    private LocalDate dateTache;

    private Integer duree;
    private Float tarifHoraire ;
    @Transient
    Integer total;    //@Transient me tethattesh fl la base de donnees
    @Enumerated(EnumType.STRING)
    private TypeTache typeTache;

    @ManyToOne
    private Etudiant etudiant;

    @OneToOne
    private Etudiant etudiantt;

}
