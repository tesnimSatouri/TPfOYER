package tn.esprit.com.springproject.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.com.springproject.Entities.Bloc;
import tn.esprit.com.springproject.Entities.Chambre;
import tn.esprit.com.springproject.Repositories.BlocRepository;
import tn.esprit.com.springproject.Repositories.ChambreRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BlocService implements IBlocService {

    BlocRepository blocrepo;
    ChambreRepository chambreRepository;

    @Override
    public List<Bloc> retrieveAllBloc() {
        return blocrepo.findAll();
    }

    @Override
    public Bloc addBloc(Bloc b) {
        return blocrepo.save(b);
    }

    @Override
    public Optional<Bloc> retrieveBlocById(Long id) {
        return blocrepo.findById(id);
    }

    @Override
    public Bloc updateBloc(Bloc b) {
        return blocrepo.save(b);
    }

    @Override
    public void deleteBloc(Long id) {
    blocrepo.deleteById(id);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc) {
        // 1. Trouver le Bloc par son nom
        Bloc bloc = blocrepo.findByNomBloc(nomBloc);

        // 2. Si le Bloc n'est pas trouvé, lancer une exception
        if (bloc == null) {
            throw new RuntimeException("Bloc non trouvée avec le nom : " + nomBloc);
        }

        // 3. Parcourir les numéros de Chambre avec forEach
        numChambre.forEach(numeroChambre -> {
            // 4. Chercher la Chambre par son numéro
            List<Chambre> chambres = chambreRepository.findByNumeroChambre(numeroChambre);

            // 5. Si aucune Chambre n'est trouvée, ignorer ou lancer une exception
            if (chambres.isEmpty()) {
                throw new RuntimeException("Chambre non trouvée avec le numéro : " + numeroChambre);
            }

            // 6. Associer chaque Chambre trouvée au Bloc
            chambres.forEach(chambre -> {
                chambre.setBloc(bloc); // Associer le Bloc à la Chambre
                chambreRepository.save(chambre); // Sauvegarder la Chambre mise à jour
            });
        });

        // 7. Retourner le Bloc mis à jour
        return bloc;
    }
    //2EME METHODE
    @Override
    public Bloc affecterChambresABlocc(List<Long> numChambre, String nomBloc) {
        // 1. Retrieve the Bloc by its name
        Bloc bloc = blocrepo.findByNomBloc(nomBloc);
        // 2. If the Bloc is not found, handle the error (return null or throw an exception)
        if (bloc == null) {
            throw new RuntimeException("Bloc not found with name: " + nomBloc);
        }
        // 3. Retrieve all the chambres for the given chambre numbers in a single query
        List<Chambre> chambres = chambreRepository.findByNumeroChambreIn(numChambre);

        // 4. If no chambres are found, throw an exception or handle as needed
        if (chambres.isEmpty()) {
            throw new RuntimeException("No chambres found for the given numbers.");
        }

        // 5. Update each chambre with the new bloc
        chambres.forEach(chambre -> {
            chambre.setBloc(bloc); // Set the new bloc parent.setchild
            chambreRepository.save(chambre);
        });

        // 6. Save all updated chambres in bulk (this will execute only one update query)
        //chambreRepository.saveAll(chambres);

        // 7. Return the updated Bloc
        return bloc;
    }


}
