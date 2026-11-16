package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Contrat;

import java.util.List;

public interface IcontratService {
    List<Contrat> retrieveAllContrats();
    Contrat addContrat(Contrat c);
    Contrat updateContrat(Contrat c);
    Contrat retrieveContrat(Long idContrat);
    void removeContrat(Long idContrat);
    List<Contrat> addContrats (List<Contrat> Contrats);
}
