package tn.esprit.com.springproject.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
import java.util.Set;

@Entity
@Getter

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bloc")
public class Bloc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBloc;
    private String nomBloc;
    private long capaciteBloc;

    @ManyToOne
    private Foyer foyer ;

    @OneToMany (mappedBy = "bloc", cascade = CascadeType.ALL)
    private Set<Chambre> chambres;
}
