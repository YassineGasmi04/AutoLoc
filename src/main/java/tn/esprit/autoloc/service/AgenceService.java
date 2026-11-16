package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.repository.AgenceRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AgenceService implements IagenceService {
   final  AgenceRepository agRepo;
    @Override
    public List<Agence> retrieveAllAgences() {
        return (List<Agence>) agRepo.findAll();
    }

    @Override
    public Agence addAgence(Agence c) {
        return agRepo.save(c);
    }

    @Override
    public Agence updateAgence(Agence c) {
        return agRepo.save(c);
    }

    @Override
    public Agence retrieveAgence(Long idAgence) {

        return agRepo.findById(idAgence).orElse(null);

    }

    @Override
    public void removeAgence(Long idAgence) {
        agRepo.deleteById(idAgence);

    }

    @Override
    public List<Agence> addAgences(List<Agence> Agences) {
        return (List<Agence>) agRepo.saveAll(Agences);
    }

    @Override
    public List<Agence> getByVille(String ville) {
        return agRepo.findByVille(ville);
    }
}
