package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entities.Bloc;

import java.util.List;

//@FieldDefaults(level = AccessLevel.PUBLIC)
public interface IBlocService {
    Bloc addBloc (Bloc bloc);
    void deleteBloc (Long idBloc);
    Bloc updateBloc (Bloc bloc);
    List<Bloc> getAllChambre ();
    Bloc retrieveBloc(Long idBloc);
}
