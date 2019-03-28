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
		return entityManager.find(Client.class, num);//SELECT ...FOM WHERE numero=...
	}

	@Override
	public List<Client> findAll() {
		/*return entityManager.createQuery("SELECT c FROM Client c", Client.class)
				            .getResultList();*/
		return entityManager.createNamedQuery("Client.findAll", Client.class)
	            .getResultList();
		//avec @NamedQuery(name="Client.findAll", ...) sur classe entity.Client
	}

	@Override
	public void save(Client cli) {
		if(cli.getNumero()==null) {
			entityManager.persist(cli);//insert into ... (et auto_increment)
			//après le .persist() , cli.getNumero() n'est plus null.
		}
		else {
			entityManager.merge(cli);//update ...
		}
	}

	@Override
	public void deleteById(Long numCli) {
		Client cli =entityManager.find(Client.class, numCli);
		entityManager.remove(cli);
	}

}
