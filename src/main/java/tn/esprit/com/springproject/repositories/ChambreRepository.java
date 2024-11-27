package tn.esprit.com.springproject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.com.springproject.Entities.Chambre;
import tn.esprit.com.springproject.Entities.TypeChambre;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre,Long> {


    List <Chambre> findByTypeCAndBlocIdBloc(TypeChambre typeC, Long bloc_idBloc);

    @Query(" Select c from Chambre c where c.typeC = ?1 and c.bloc.idBloc = ?2 ")
    List<Chambre> retrievebytypecandblocid (TypeChambre c , Long idb) ;

    List<Chambre>findByReservationsEstValide(boolean estValide);

    //NESTAAMEL JOIN  KI YABDA ANDI LIST KIMA LENNA RESERVATIONS BESH NEKHO MNHA CHAMP

    @Query("SELECT c FROM Chambre c JOIN c.reservations r WHERE r.estValide = :estValide")
    List<Chambre> retrieveChambreBytyoeCandBlocId(@Param("estValide") Boolean estValide);


    List<Chambre>findByBlocIdBlocAndBlocCapaciteBlocGreaterThan(Long id_bloc ,Long capacite) ;
    @Query("SELECT c FROM Chambre c where c.bloc.idBloc =?1 and c.bloc.capaciteBloc > ?2 ")
    List<Chambre> retrievebybloccapandid (Long id , Long cap);


    List<Chambre> findByNumeroChambre(Long numeroChambre);

    List<Chambre> findByNumeroChambreIn(List<Long> numChambre);

    Long countByTypeCAndBlocIdBloc(TypeChambre type, Long idBloc);
}
