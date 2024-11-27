package tn.esprit.com.springproject.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.com.springproject.Entities.Tache;
import tn.esprit.com.springproject.Repositories.TacheRepository;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class TacheService implements ITacheService{
    TacheRepository TacheRepository;

    @Override
    public List<Tache> retrieveAllTache() {
        return TacheRepository.findAll();
    }

    @Override
    public Tache addTache(Tache b) {
        return TacheRepository.save(b);
    }

    @Override
    public Optional<Tache> retrieveTacheById(Long id) {
        return TacheRepository.findById(id);
    }

    @Override
    public Tache updateTache(Tache b) {
        return TacheRepository.save(b);
    }

    @Override
    public void deleteTache(Long id) {
        TacheRepository.deleteById(id);
    }
    
}
