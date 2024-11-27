package tn.esprit.com.springproject.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.com.springproject.Entities.Chambre;
import tn.esprit.com.springproject.Entities.TypeChambre;
import tn.esprit.com.springproject.Repositories.ChambreRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class ChambreService implements IChambreService{

    ChambreRepository chambreRepository;

    @Override
    public List<Chambre> retrieveAllChambre() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre b) {
        return chambreRepository.save(b);
    }

    @Override
    public Optional<Chambre> retrieveChambreById(Long id) {
        return chambreRepository.findById(id);
    }

    @Override
    public Chambre updateChambre(Chambre b) {
        return chambreRepository.save(b);
    }

    @Override
    public void deleteChambre(Long id) {
    chambreRepository.deleteById(id);
    }

    @Override
    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) {
        // Recherche du nombre de chambres avec le type et l'id du bloc spécifiés
        return chambreRepository.countByTypeCAndBlocIdBloc(type, idBloc);
    }



}
