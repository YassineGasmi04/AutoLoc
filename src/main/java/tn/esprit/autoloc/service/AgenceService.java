package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domaine.agence;
import tn.esprit.autoloc.repository.AgenceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgenceService implements IagenceService {

    private final AgenceRepository aRepo;

    @Override
    public List<agence> retrieveAllAgences() {
        return (List<agence>) aRepo.findAll();
    }

    @Override
    public agence addAgence(agence a) {
        return aRepo.save(a);
    }

    @Override
    public agence updateAgence(agence a) {
        return aRepo.save(a);
    }

    @Override
    public agence retrieveAgence(Long idAgence) {
        return aRepo.findById(idAgence).orElse(null);
    }

    @Override
    public void removeAgence(Long idAgence) {
        aRepo.deleteById(idAgence);
    }

    @Override
    public List<agence> addAgences(List<agence> agences) {
        return (List<agence>) aRepo.saveAll(agences);
    }
}
