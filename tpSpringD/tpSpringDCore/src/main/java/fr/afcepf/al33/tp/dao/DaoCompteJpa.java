package fr.afcepf.al33.tp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al33.tp.entity.Compte;

@Repository //un peu comme @Stateless
@Transactional() //de Spring
public class DaoCompteJpa implements DaoCompte {
	
	@PersistenceContext()
	private EntityManager entityManager;

	@Override
	public void save(Compte c) {
		if(c.getNumero()==null)
		   entityManager.persist(c);
		else
			entityManager.merge(c);
	}

	@Override
	public Compte findById(Long num) {
		return entityManager.find(Compte.class, num);
	}

}
