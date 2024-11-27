package tn.esprit.com.springproject.Services;

import org.springframework.stereotype.Service;
import tn.esprit.com.springproject.Entities.Foyer;
import tn.esprit.com.springproject.Repositories.BlocRepository;
import tn.esprit.com.springproject.Repositories.FoyerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FoyerService implements IFoyerService{
    BlocRepository blocRepository;
    
    FoyerRepository foyerRepository;

    @Override
    public List<Foyer> retrieveAllFoyer() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer b) {
        return foyerRepository.save(b);
    }

    @Override
    public Optional<Foyer> retrieveFoyerById(Long id) {
        return foyerRepository.findById(id);
    }

    @Override
    public Foyer updateFoyer(Foyer b) {
        return foyerRepository.save(b);
    }

    @Override
    public void deleteFoyer(Long id) {
        foyerRepository.deleteById(id);
    }




    @Override
    public Foyer AddFoyerAndBlocsAssocie(Foyer f){
        Foyer foyer=foyerRepository.save(f);
        foyer.getBlocs().forEach(bloc ->
        {
            bloc.setFoyer(foyer);
            blocRepository.save(bloc);
        } );
        return f;

    }


}
