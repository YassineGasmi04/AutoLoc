package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domaine.employe;
import tn.esprit.autoloc.repository.EmployeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeService implements IemployeService {

    private final EmployeRepository eRepo;

    @Override
    public List<employe> retrieveAllEmployes() {
        return (List<employe>) eRepo.findAll();
    }

    @Override
    public employe addEmploye(employe e) {
        return eRepo.save(e);
    }

    @Override
    public employe updateEmploye(employe e) {
        return eRepo.save(e);
    }

    @Override
    public employe retrieveEmploye(Long idEmploye) {
        return eRepo.findById(idEmploye).orElse(null);
    }

    @Override
    public void removeEmploye(Long idEmploye) {
        eRepo.deleteById(idEmploye);
    }

    @Override
    public List<employe> addEmployes(List<employe> employes) {
        return (List<employe>) eRepo.saveAll(employes);
    }
}
