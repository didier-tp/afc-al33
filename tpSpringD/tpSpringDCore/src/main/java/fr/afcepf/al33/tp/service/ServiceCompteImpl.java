package fr.afcepf.al33.tp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al33.tp.dao.DaoCompte;
import fr.afcepf.al33.tp.entity.Compte;

@Service //ou @Component
@Transactional
public class ServiceCompteImpl implements ServiceCompte {
	
	@Autowired
	private DaoCompte daoCompte;

	@Override
	public void sauvegarderCompte(Compte c) {
		daoCompte.save(c);
	}

	@Override
	public Compte rechercherCompteParNum(Long num) {
		return daoCompte.findById(num);
	}

	@Override //logique metier = virement bancaire
	//@Transactional ici ou bien au dessus de la classe
	public void transferer(Double montant, Long numCptDeb, Long numCptCred) {
		//entityManager et transaction automatiquement initialises par Spring
		//des le debut de l'execution de cette methode
		
		Compte cptDeb = daoCompte.findById(numCptDeb);
		cptDeb.setSolde(cptDeb.getSolde()-montant);
		//daoCompte.save(cptDeb);//facultatif si cptDeb est persistant (du fait de @Transactional)
		
		Compte cptCred = daoCompte.findById(numCptCred);
		cptCred.setSolde(cptCred.getSolde()+montant);
		//daoCompte.save(cptCred);//facultatif si cptCred est persistant (du fait de @Transactional)
	
	    //si exception --> rollback automatique (modifs database temporaires non validees)
		//si pas exception --> commit automatique
		//et tous les objets a l'etat persistant sont automatiquement mis a jour en base
	}

}
