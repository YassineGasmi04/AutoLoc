package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domaine.agence;

import java.util.List;

public interface IagenceService {
    List<agence> retrieveAllAgences();
    agence addAgence(agence a);
    agence updateAgence(agence a);
    agence retrieveAgence(Long idAgence);
    void removeAgence(Long idAgence);
    List<agence> addAgences(List<agence> agences);
}
