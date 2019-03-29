package fr.afcepf.al33.tp.dao;

import fr.afcepf.al33.tp.entity.Compte;

public interface DaoCompte {
	void save(Compte c);
	//..

	Compte findById(Long num);
}
