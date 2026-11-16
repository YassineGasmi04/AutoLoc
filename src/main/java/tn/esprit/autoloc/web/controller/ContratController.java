package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IcontratService;
import tn.esprit.autoloc.service.IcontratService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contrat")
public class ContratController {
    private final IcontratService contratService;
    @PostMapping("/addContrat")
    public Contrat addContrat(@RequestBody Contrat c){
        return contratService.addContrat(c);
    }
    @GetMapping("/getContrats")
    public List<Contrat> getAllContrats(){
        return contratService.retrieveAllContrats();
    }
    @GetMapping("/getContratId/{idc}")
    public Contrat getContratById(@PathVariable long idc){
        return contratService.retrieveContrat(idc);
    }
    @DeleteMapping("/deleteContrat/{idc}")
    public void deleteContrat(@PathVariable long idc){
        contratService.removeContrat(idc);
    }

    @PutMapping("/updateContrat")
    public Contrat updateContrat(@RequestBody Contrat c){
        return contratService.updateContrat(c);
    }
}
