package fr.afcepf.al33.tp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al33.tp.dao.DaoClient;
import fr.afcepf.al33.tp.entity.Client;
import fr.afcepf.al33.tp.entity.Compte;


@Service //héritant de @Component
@Transactional
public class ServiceClientImpl implements ServiceClient {
	
	
	@Autowired
	private DaoClient daoClient; //dao vers lequel déléguer
	
	
	
	//@Autowired
	//private DaoCompte daoCompte; //dao vers lequel déléguer
	

	@Override
	public Client rechercherClientParNumero(Long numero) {
		return daoClient.findById(numero);/*.orElse(null);*/
	}

	@Override
	public void saveOrUpdateClient(Client cpt) {
			daoClient.save(cpt);
	}

	@Override
	public void supprimerClient(Long numClient) {
		daoClient.deleteById(numClient);
	}

	@Override
	public Client rechercherEtMajClientParNumero(Long numero) {
		//en début de méthode , nouvel entityManager 
		//et début de transaction automatique car @Transactional
		Client cli = daoClient.findById(numero);
		cli.setNom(cli.getNom().toUpperCase());
		//pas besoin de déclencher ici
		//daoClient.save() (ni indirectement entityManager.merge())
		return cli;
		//en fin de méthode , commit automatique si pas d'exception.
		//le commit() déclencle le flush() qui update automatiquement
		//les valeurs modifiées en mémoire sur les objets persistants 
	}

	@Override
	public List<Client> rechercherTousClients() {
		return daoClient.findAll();
	}

	@Override
	public List<Compte> rechercherComptesDuClient(Long numClient) {
		return daoClient.findComptesOfClient(numClient);
	}

	@Override
	public void ajouterComptePourClient(Long numClient, Long numCompte) {
		daoClient.addCompteForClient(numClient,numCompte);
	}

	
	
}
