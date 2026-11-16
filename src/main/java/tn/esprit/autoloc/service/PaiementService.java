package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.repository.PaiementRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PaiementService implements IpaiementService{
   final PaiementRepository pRepo;
    @Override
    public List<Paiement> retrieveAllPaiements() {
        return (List<Paiement>) pRepo.findAll();
    }

    @Override
    public Paiement addPaiement(Paiement c) {
        return pRepo.save(c);
    }

    @Override
    public Paiement updatePaiement(Paiement c) {
        return pRepo.save(c);
    }

    @Override
    public Paiement retrievePaiement(Long idPaiement) {

        return pRepo.findById(idPaiement).orElse(null);

    }

    @Override
    public void removePaiement(Long idPaiement) {
        pRepo.deleteById(idPaiement);

    }

    @Override
    public List<Paiement> addPaiements(List<Paiement> Paiements) {
        return (List<Paiement>) pRepo.saveAll(Paiements);
    }
}
