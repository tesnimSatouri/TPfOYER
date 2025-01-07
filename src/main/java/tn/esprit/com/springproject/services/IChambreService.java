package tn.esprit.com.springproject.Services;

import lombok.AllArgsConstructor;
import tn.esprit.com.springproject.Entities.Chambre;
import tn.esprit.com.springproject.Entities.TypeChambre;

import java.util.List;
import java.util.Optional;


public interface IChambreService {
    List<Chambre> retrieveAllChambre();
    Chambre addChambre(Chambre b);
    Optional<Chambre> retrieveChambreById(Long id);
    Chambre updateChambre(Chambre b);
    void deleteChambre(Long id);
    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) ;

    String affecterMaintenance();
}
