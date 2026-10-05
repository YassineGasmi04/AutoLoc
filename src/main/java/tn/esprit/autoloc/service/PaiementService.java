package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domaine.paiement;
import tn.esprit.autoloc.repository.PaiementRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaiementService implements IpaiementService {

    private final PaiementRepository pRepo;

    @Override
    public List<paiement> retrieveAllPaiements() {
        return (List<paiement>) pRepo.findAll();
    }

    @Override
    public paiement addPaiement(paiement p) {
        return pRepo.save(p);
    }

    @Override
    public paiement updatePaiement(paiement p) {
        return pRepo.save(p);
    }

    @Override
    public paiement retrievePaiement(Long idPaiement) {
        return pRepo.findById(idPaiement).orElse(null);
    }

    @Override
    public void removePaiement(Long idPaiement) {
        pRepo.deleteById(idPaiement);
    }

    @Override
    public List<paiement> addPaiements(List<paiement> paiements) {
        return (List<paiement>) pRepo.saveAll(paiements);
    }
}
