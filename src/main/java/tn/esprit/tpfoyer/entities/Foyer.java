package tn.esprit.tpfoyer.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "foyer")

public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer ;

    private String nomFoyer ;

    private Long capaciteFoyer;

    @OneToOne
    private  Universite universite;

    @OneToMany (cascade = CascadeType.ALL ,mappedBy = "foyer")
    private Set<Bloc> blocs;

}
