package fr.afcepf.al33.tp.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afcepf.al33.tp.MySpringBootApplication;
import fr.afcepf.al33.tp.dao.DaoCompte;
import fr.afcepf.al33.tp.entity.Adresse;
import fr.afcepf.al33.tp.entity.Client;
import fr.afcepf.al33.tp.entity.Compte;
import fr.afcepf.al33.tp.service.ServiceClient;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {MySpringBootApplication.class})
public class TestServiceClient {
	
	private static Logger logger = LoggerFactory.getLogger(TestServiceClient.class);
	
	@Autowired
	private ServiceClient serviceClient ; //à tester
	//@Autowired
	//private ServiceCompte serviceCompte ; //annexe pour  tester
	
	@Autowired //comme @Inject
	private DaoCompte daoCompte;
	
	@Test
	public void testCompteEtClient() {
		Client cli = new Client(null,"Therieur","alain","0102030405" ,"alain.therieur@ici_ou_la.fr");
		serviceClient.saveOrUpdateClient(cli);
		
		Compte cpt = new Compte();cpt.setLabel("compteA"); cpt.setSolde(50.0);
		daoCompte.save(cpt);
		
		Compte cptB = new Compte();cptB.setLabel("compteB"); cptB.setSolde(100.0);
		daoCompte.save(cptB);
		
		Compte cptC = new Compte();cptC.setLabel("compteC"); cptC.setSolde(150.0);
		daoCompte.save(cptC);
		
		serviceClient.ajouterComptePourClient(cli.getNumero(), cpt.getNumero());
		serviceClient.ajouterComptePourClient(cli.getNumero(), cptB.getNumero());
		
		List<Compte> listeCpt = serviceClient.rechercherComptesDuClient(cli.getNumero());
		Assert.assertTrue(listeCpt.size()>=2);
		System.out.println("listeCpt="+listeCpt);
	}
	
	
	@Test
	public void test_CRUD_Client_via_Service_deleguant_au_dao() {
		    Client clicli = new Client(null,"Aire","axelle","0102030405" ,"axelle.aire@ici_ou_la.fr");
		    serviceClient.saveOrUpdateClient(clicli);
			//1 . Ajouter entité en base
			Client cli = new Client(null,"Therieur","alain","0102030405" ,"alain.therieur@ici_ou_la.fr");
			cli.setAdresse(new Adresse("12, rue elle " , "75002" , "Paris"));
			serviceClient.saveOrUpdateClient(cli);
			Long numCli = cli.getNumero(); 
			//2.  Verifier entité ajoutée que l'on recharge depuis la base
			List<Client> clients = serviceClient.rechercherTousClients();
			Assert.assertTrue(clients.size()>=2);
			System.out.println("clients="+clients);
			
			Client cliRelu = serviceClient.rechercherEtMajClientParNumero(numCli);
			Assert.assertTrue(cliRelu.getPrenom().equals("alain"));
			logger.info("apres ajout et relecture  , cliRelu="+cliRelu);
			//3.  modif , save() sur entité modifiée
			
			//NB: coté "test unitaire" ou "web" , 
			//cliRelu est ici en mode "détaché" 
			//(car fin transaction/entityManager) via @Transactional de Spring
			cliRelu.setPrenom("alex");
			//la modification du prénom ne sera enregistrée en base 
			// que si ordre explicite :  saveOrUpdateClient déléguant un .merge()
			serviceClient.saveOrUpdateClient(cliRelu);
			
			//4.  Rechargement et vérification mise à jour
			Client cliRelu2 = serviceClient.rechercherClientParNumero(numCli);
			Assert.assertTrue(cliRelu2.getPrenom().equals("alex"));
			logger.info("apres modif et relecture , cliRelu2="+cliRelu2);
		    //5 . supprimer l'entité en base
			//serviceClient.supprimerClient(numCli);
			//6. Rechercher et vérifier que ça n'existe plus
			boolean existeEncore = (serviceClient.rechercherClientParNumero(numCli) != null) ;
			//Assert.assertFalse(existeEncore);
	}
	
	
}
