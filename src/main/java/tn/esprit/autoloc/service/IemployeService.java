package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domaine.employe;

import java.util.List;

public interface IemployeService {
    List<employe> retrieveAllEmployes();
    employe addEmploye(employe e);
    employe updateEmploye(employe e);
    employe retrieveEmploye(Long idEmploye);
    void removeEmploye(Long idEmploye);
    List<employe> addEmployes(List<employe> employes);
}
