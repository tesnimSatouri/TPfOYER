package tn.esprit.com.springproject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.com.springproject.Entities.Bloc;
import tn.esprit.com.springproject.Entities.Reservation;

import java.util.List;

@Repository
public interface BlocRepository extends JpaRepository<Bloc,Long> {

    List<Bloc> findByFoyerUniversiteIdUniversite( Long idUniversite);

    @Query("SELECT b from Bloc b WHERE b.foyer.universite.idUniversite = ?1 ")
    List<Bloc>retrieveBlocByUniversiteID (Long UniversiteId) ;


    Bloc findByNomBloc(String nomBloc);
}
