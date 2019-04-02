package fr.afcepf.al33.tp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.afcepf.al33.tp.entity.Client;
import fr.afcepf.al33.tp.entity.Compte;

public interface DaoClient  extends CrudRepository<Client, Long> {
	/*
	//méthodes héritées de CrudRepository:
	Optional<Client> findById(Long num);
	List<Client> findAll();
	void save(Client cli);//au sens saveOrUpdate (selon num/id null ou pas)
	void deleteById(Long numCli);
	*/
	//méthodes spécifiques:
	List<Compte> findComptesOfClient(Long numClient);
	//void addCompteForClient(Long numClient, Long numCompte);
	//Sans spring-data addCompteForClient() codé sur le DaoClientJpa
	//avec spring-data , c'est codé sur le ServiceClientImpl
	
}
