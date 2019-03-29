package fr.afcepf.al33.tp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al33.tp.entity.Client;
import fr.afcepf.al33.tp.entity.Compte;

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

	@Override
	public List<Compte> findComptesOfClient(Long numClient) {
		/*
		//Solution1 (via lien @OneToMany):
		Client cli = entityManager.find(Client.class, numClient);
		//appeler .size() sur une lazy collection
		//provoque une boucle for interne pour connaître la taille
		//les valeurs des comptes remontent alors immédiatement des tables vers la mémoire java
		cli.getComptes().size(); //pour eviter lazyException
		return cli.getComptes();
		*/
		//Solution 2 via NamedQuery:
		return entityManager.createNamedQuery("Client.findComptesOfClient", Compte.class)
				.setParameter("numClient", numClient)
				.getResultList();
	}

	@Override
	public void addCompteForClient(Long numClient, Long numCompte) {
		Compte cpt = entityManager.find(Compte.class, numCompte);
		Client client = entityManager.find(Client.class, numClient);
		
		cpt.setClient(client);//on effectue la liaison du coté principal
		//(où il n'y a pas mappedBy) pour la relation soit bien sauvegardée en base
		//ici dans la colonne clef étrangère
		
		entityManager.merge(cpt);//faculatif à l'état persistant
	}

}
