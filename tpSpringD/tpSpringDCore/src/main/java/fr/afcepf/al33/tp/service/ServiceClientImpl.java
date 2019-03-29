package fr.afcepf.al33.tp.service;

import javax.annotation.PostConstruct;

import fr.afcepf.al33.tp.dao.DaoClient;
import fr.afcepf.al33.tp.entity.Client;

public class ServiceClientImpl implements ServiceClient {
	
	private DaoClient daoClient;//null tout au debut avant injection dependance
	
	//methode d'injection de dépendance appelée par spring
	public void setDaoClient(DaoClient daoClient) {
		this.daoClient = daoClient;
	}
	
	public ServiceClientImpl() {
		System.out.println("dans constructeur , daoClient inutilisable=" +daoClient );
	}
	
	@PostConstruct //OK avec EJB, JSF, Spring, ...
	public void initQueJaime() {
		//méthode appelée après toutes les injections effectuées 
		System.out.println("dans méthode prefixée par @PostConstruct , daoClient=" +daoClient );
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
