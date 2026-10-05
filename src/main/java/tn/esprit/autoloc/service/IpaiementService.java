package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domaine.paiement;

import java.util.List;

public interface IpaiementService {
    List<paiement> retrieveAllPaiements();
    paiement addPaiement(paiement p);
    paiement updatePaiement(paiement p);
    paiement retrievePaiement(Long idPaiement);
    void removePaiement(Long idPaiement);
    List<paiement> addPaiements(List<paiement> paiements);
}
