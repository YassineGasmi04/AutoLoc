package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domaine.client;

import java.util.List;

public interface IclientService {
    List<client> retrieveAllClients();
    client addClient(client c);
    client updateClient(client c);
    client retrieveClient(Long idClient);
    void removeClient(Long idClient);
    List<client> addClients (List<client> clients);


}
