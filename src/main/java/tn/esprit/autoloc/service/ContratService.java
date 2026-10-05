package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domaine.contrat;
import tn.esprit.autoloc.repository.ContratRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratService implements IcontratService {

    private final ContratRepository cRepo;

    @Override
    public List<contrat> retrieveAllContrats() {
        return (List<contrat>) cRepo.findAll();
    }

    @Override
    public contrat addContrat(contrat c) {
        return cRepo.save(c);
    }

    @Override
    public contrat updateContrat(contrat c) {
        return cRepo.save(c);
    }

    @Override
    public contrat retrieveContrat(Long idContrat) {
        return cRepo.findById(idContrat).orElse(null);
    }

    @Override
    public void removeContrat(Long idContrat) {
        cRepo.deleteById(idContrat);
    }

    @Override
    public List<contrat> addContrats(List<contrat> contrats) {
        return (List<contrat>) cRepo.saveAll(contrats);
    }
}
