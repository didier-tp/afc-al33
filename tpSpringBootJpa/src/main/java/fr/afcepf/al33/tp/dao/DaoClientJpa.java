package fr.afcepf.al33.tp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al33.tp.entity.Client;

@Repository // composant spring de type DAO (Data Access Object)
@Transactional // begin() et commit()/rollback() déclenchés automatiquement
public class DaoClientJpa implements DaoClient {
	
	@PersistenceContext //pour initialiser entityManager
	                    //à partir de META-INF/persistence.xml 
	                    //ou d'une config équivalente (ici spring)
	private EntityManager entityManager;

	@Override
	public Client findById(Long num) {
		return null;
	}

	@Override
	public List<Client> findAll() {
		return null;
	}

	@Override
	public void save(Client cli) {
		
	}

	@Override
	public void deleteById(Long numCli) {
		
	}

}
