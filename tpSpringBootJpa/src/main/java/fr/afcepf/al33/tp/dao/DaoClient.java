package fr.afcepf.al33.tp.dao;

import java.util.List;

import fr.afcepf.al33.tp.entity.Client;
import fr.afcepf.al33.tp.entity.Compte;

public interface DaoClient /* extends CrudRepository<Client, Long> */ {
	Client findById(Long num);
	List<Client> findAll();
	
	void save(Client cli);//au sens saveOrUpdate (selon num/id null ou pas)
	
	void deleteById(Long numCli);
	List<Compte> findComptesOfClient(Long numClient);
	void addCompteForClient(Long numClient, Long numCompte);
	

}
