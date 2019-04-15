package fr.afcepf.al33.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.al33.entity.Devise;

@Stateless
@Local
public class DeviseDaoImpl implements DeviseDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	public DeviseDaoImpl() {
	}

	@Override
	public Devise getDeviseByCode(String code) {
		return entityManager.find(Devise.class, code);
	}

}
