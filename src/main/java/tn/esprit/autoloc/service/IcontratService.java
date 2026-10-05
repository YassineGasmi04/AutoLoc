package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domaine.contrat;

import java.util.List;

public interface IcontratService {
    List<contrat> retrieveAllContrats();
    contrat addContrat(contrat c);
    contrat updateContrat(contrat c);
    contrat retrieveContrat(Long idContrat);
    void removeContrat(Long idContrat);
    List<contrat> addContrats(List<contrat> contrats);
}
