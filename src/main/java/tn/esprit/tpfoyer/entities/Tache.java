package tn.esprit.tpfoyer.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tache")
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTache;
    private LocalDate Tache;
    private Integer duree;  // ken par exemple m nesthaqhesh fl base najm naaml annotation @transient
    private Float tarifHoraire;
    @Enumerated(EnumType.STRING) //naamelha besh me tsauvgardilish ar9am 1 0 etc
    private TypeTache typeTache;

    @ManyToOne
    private  Etudiant etudiant ;

}
