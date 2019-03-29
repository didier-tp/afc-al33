package fr.afcepf.al33.tp.dao;

import java.util.List;

import fr.afcepf.al33.tp.entity.Client;

public interface DaoClient {
	Client findById(Long numero);
	List<Client> findAll();
	void save(Client c);
	void deleteById(Long numero);
	//...
}
