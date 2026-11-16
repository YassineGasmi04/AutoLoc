package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Employe;

import java.util.List;

public interface IemployeService {
    List<Employe> retrieveAllEmployes();
    Employe addEmploye(Employe c);
    Employe updateEmploye(Employe c);
    Employe retrieveEmploye(Long idEmploye);
    void removeEmploye(Long idEmploye);
    List<Employe> addEmployes (List<Employe> Employes);
    public Employe affecterEmploye(Long idEmploye, Long idAgence);
    public Employe desaffecterEmploye(Long idEmploye);
}
