package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.repository.EmployeRepository;
import tn.esprit.autoloc.repository.EmployeRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EmployeService implements IemployeService{
    final EmployeRepository empRepo;
    final AgenceRepository agenceRepo;
    @Override
    public List<Employe> retrieveAllEmployes() {
        return (List<Employe>) empRepo.findAll();
    }

    @Override
    public Employe addEmploye(Employe c) {
        return empRepo.save(c);
    }

    @Override
    public Employe updateEmploye(Employe c) {
        return empRepo.save(c);
    }

    @Override
    public Employe retrieveEmploye(Long idEmploye) {

        return empRepo.findById(idEmploye).orElse(null);

    }

    @Override
    public void removeEmploye(Long idEmploye) {
        empRepo.deleteById(idEmploye);

    }

    @Override
    public List<Employe> addEmployes(List<Employe> Employes) {
        return (List<Employe>) empRepo.saveAll(Employes);
    }

    @Override
    @Transactional
    public Employe desaffecterEmploye(Long idEmploye) {
        Employe employe = empRepo.findById(idEmploye)
                .orElseThrow(() -> new RuntimeException("Employé introuvable"));

        employe.setAgence(null);

        return empRepo.save(employe);
    }

    @Override
    @Transactional
    public Employe affecterEmploye(Long idEmploye, Long idAgence) {
        Employe employe = empRepo.findById(idEmploye)
                .orElseThrow(() -> new RuntimeException("Employé introuvable"));

        Agence agence = agenceRepo.findById(idAgence)
                .orElseThrow(() -> new RuntimeException("Agence introuvable"));

        if (employe.getAgence() != null) {
            throw new IllegalStateException("L'employé est déjà affecté à l'agence "
                    + employe.getAgence().getId() + " : désaffectez-le d'abord avant de le transférer");
        }

        employe.setAgence(agence);

        return empRepo.save(employe);
    }
}
