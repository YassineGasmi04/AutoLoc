package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Agence;

import java.util.List;

public interface IagenceService {
    List<Agence> retrieveAllAgences();
    Agence addAgence(Agence c);
    Agence updateAgence(Agence c);
    Agence retrieveAgence(Long idAgence);
    void removeAgence(Long idAgence);
    List<Agence> addAgences (List<Agence> Agences);
    List<Agence> getByVille(String ville);
}
