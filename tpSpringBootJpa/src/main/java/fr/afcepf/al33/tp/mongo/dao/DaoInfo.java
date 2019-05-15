package fr.afcepf.al33.tp.mongo.dao;

import org.springframework.data.repository.CrudRepository;

import fr.afcepf.al33.mongo.collections.Info;

public interface DaoInfo  extends CrudRepository<Info, Long> {
	/*
	//méthodes héritées de CrudRepository:
	Optional<Info> findById(Long num);
	List<Info> findAll();
	void save(Info info);//au sens saveOrUpdate (selon num/id null ou pas)
	void deleteById(Long idInfo);
	*/
	//méthodes spécifiques:
	
}
