package fr.afcepf.al33.tp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.afcepf.al33.tp.entity.Compte;

public interface DaoCompte extends JpaRepository/*CrudRepository*/<Compte,Long> {
	//principales méthodes héritées:
	//void save(Compte c);
	//findById() , findAll() , deleteById()
}
