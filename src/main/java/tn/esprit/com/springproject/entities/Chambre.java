package tn.esprit.com.springproject.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chambre")
public class Chambre {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idChambre;

    private Long numeroChambre;

    @Enumerated
    private TypeChambre typeC;

    @ManyToOne(cascade = CascadeType.ALL)
    private Bloc bloc ;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations ;
}
