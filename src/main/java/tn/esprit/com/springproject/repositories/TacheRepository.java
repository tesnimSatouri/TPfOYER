package tn.esprit.com.springproject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.com.springproject.Entities.Tache;

@Repository
public interface TacheRepository extends JpaRepository<Tache, Long> {
}
