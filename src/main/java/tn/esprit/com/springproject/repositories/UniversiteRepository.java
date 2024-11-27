package tn.esprit.com.springproject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.com.springproject.Entities.Universite;

@Repository
public interface UniversiteRepository extends JpaRepository<Universite, Long> {
    Universite findUniversiteByNomUniversite(String nomUniversite);

}
