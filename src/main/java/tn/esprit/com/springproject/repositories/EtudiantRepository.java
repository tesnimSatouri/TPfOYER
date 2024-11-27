package tn.esprit.com.springproject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.com.springproject.Entities.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
    Etudiant findByNomEtAndPrenomEt(String nomEt, String prenomEt);

    Etudiant findByNomEt(String nomEt);
}
