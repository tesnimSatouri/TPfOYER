package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entities.Chambre;

import java.util.List;

//@FieldDefaults(level = AccessLevel.PUBLIC) //k yabdew lkol public nzidou hethy w na7w kilmit public
public interface IChambreService {
     Chambre addChambre (Chambre chambre);
     void  deleteChambre(Long idChambre);
     Chambre UpdateChambre (Chambre chambre);
     List<Chambre> getAllChambre();
     Chambre retrieveChambre(Long idChambre);
}
