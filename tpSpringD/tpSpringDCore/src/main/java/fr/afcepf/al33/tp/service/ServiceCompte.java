package fr.afcepf.al33.tp.service;

import fr.afcepf.al33.tp.entity.Compte;

public interface ServiceCompte {
	void sauvegarderCompte(Compte c);
	Compte rechercherCompteParNum(Long num);
	void transferer(Double montant,Long numCptDeb, Long numCptCred);
	//...
}
