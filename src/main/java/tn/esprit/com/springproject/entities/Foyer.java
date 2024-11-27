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
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFoyer;

    private String nomFoyer;

    private long capaciteFoyer;


    //foyer is the child

    @OneToMany (mappedBy = "foyer", cascade = CascadeType.ALL)
    private Set<Bloc> blocs ;


    @OneToOne( cascade = CascadeType.ALL)
    private  Universite universite;



}
