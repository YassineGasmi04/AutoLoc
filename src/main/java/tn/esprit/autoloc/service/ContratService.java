package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.repository.ContratRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ContratService implements IcontratService{
    final ContratRepository contRepo;
    @Override
    public List<Contrat> retrieveAllContrats() {
        return (List<Contrat>) contRepo.findAll();
    }

    @Override
    public Contrat addContrat(Contrat c) {
        return contRepo.save(c);
    }

    @Override
    public Contrat updateContrat(Contrat c) {
        return contRepo.save(c);
    }

    @Override
    public Contrat retrieveContrat(Long idContrat) {

        return contRepo.findById(idContrat).orElse(null);

    }

    @Override
    public void removeContrat(Long idContrat) {
        contRepo.deleteById(idContrat);

    }

    @Override
    public List<Contrat> addContrats(List<Contrat> Contrats) {
        return (List<Contrat>) contRepo.saveAll(Contrats);
    }
}
