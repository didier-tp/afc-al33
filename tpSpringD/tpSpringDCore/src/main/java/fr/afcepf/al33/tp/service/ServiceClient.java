package fr.afcepf.al33.tp.service;

import fr.afcepf.al33.tp.entity.Client;

public interface ServiceClient {
    Client rechercherClientParNum(Long num);
    void sauvegarderClient(Client c);
    //...
}
