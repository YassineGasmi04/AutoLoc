package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IclientService;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")


public class ClientController {
    private final IclientService clientService;
    @PostMapping("/addClient")
    public Client addClient(@RequestBody Client c){
        return clientService.addClient(c);
    }
    @GetMapping("/getClients")
    public List<Client> getAllCLients(){
        return clientService.retrieveAllClients();
    }
    @GetMapping("/getClientId/{idc}")
    public Client getClientById(@PathVariable long idc){
        return clientService.retrieveClient(idc);
    }
    @DeleteMapping("/deleteClient/{idc}")
    public void deleteClient(@PathVariable long idc){
     clientService.removeClient(idc);
    }

    @PutMapping("/updateClient")
    public Client updateClient(@RequestBody Client c){
        return clientService.updateClient(c);
    }





}
