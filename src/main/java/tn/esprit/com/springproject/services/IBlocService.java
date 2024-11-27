package tn.esprit.com.springproject.Services;

import tn.esprit.com.springproject.Entities.Bloc;

import java.util.List;
import java.util.Optional;

public interface IBlocService {
    List<Bloc> retrieveAllBloc();
    Bloc addBloc(Bloc b);
    Optional<Bloc> retrieveBlocById(Long id);
    Bloc updateBloc(Bloc b);
    void deleteBloc(Long id);

    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc) ;

    Bloc affecterChambresABlocc(List<Long> numChambre, String nomBloc);
}
