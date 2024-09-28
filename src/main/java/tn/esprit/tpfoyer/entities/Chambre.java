package tn.esprit.tpfoyer.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Chambre")
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;
    private Long numeroChambre ;
    @Enumerated(EnumType.STRING)
    private TypeChambre typeC;

    @ManyToOne
    private  Bloc bloc ;


    @OneToMany (cascade = CascadeType.ALL)
    private Set<Reservation> reservations ;
}
