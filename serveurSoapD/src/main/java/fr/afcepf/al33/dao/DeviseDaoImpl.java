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
		// TODO Auto-generated constructor stub
	}

	@Override
	public Devise getDeviseByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

}
