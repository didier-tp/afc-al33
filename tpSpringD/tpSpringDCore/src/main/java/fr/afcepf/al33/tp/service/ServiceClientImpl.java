package fr.afcepf.al33.tp.service;

import fr.afcepf.al33.tp.dao.DaoClient;
import fr.afcepf.al33.tp.entity.Client;

public class ServiceClientImpl implements ServiceClient {
	
	private DaoClient daoClient;
	
	//methode d'injection de dépendance appelée par spring
	public void setDaoClient(DaoClient daoClient) {
		this.daoClient = daoClient;
	}

	@Override
	public Client rechercherClientParNum(Long num) {
		return daoClient.findById(num);
	}

	@Override
	public void sauvegarderClient(Client c) {
		daoClient.save(c);
        //...
	}

}
