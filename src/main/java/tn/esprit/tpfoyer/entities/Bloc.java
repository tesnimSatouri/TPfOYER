package tn.esprit.tpfoyer.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "bloc")
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idBloc ;
    private String nomBloc;
    private Long capaciteBloc;

    @ManyToOne
    private Foyer foyer ;

    @OneToMany (cascade = CascadeType.ALL,mappedBy = "bloc")
    private Set<Chambre> chambres ;

}
