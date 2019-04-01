package fr.afcepf.al33.tp.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.afcepf.al33.tp.entity.Compte;
import fr.afcepf.al33.tp.service.ServiceCompte;


@RunWith(SpringJUnit4ClassRunner.class) //nécessite spring-test et junit 4.12 dans pom.xml
@ContextConfiguration(locations={"/springConf.xml"})
public class TestServiceCompte {
	
	@Autowired
	private ServiceCompte serviceCompte; //à tester
	
	@Test
	public void testBonVirement() {
		Compte cA = new Compte(); cA.setSolde(100.0);cA.setLabel("cA");
		serviceCompte.sauvegarderCompte(cA);
		Compte cB = new Compte(); cB.setSolde(200.0);cB.setLabel("cB");
		serviceCompte.sauvegarderCompte(cB);
		System.out.println("avant bon virement:");
		System.out.println("cA:"+cA.toString());
		System.out.println("cB:"+cB.toString());
		
		serviceCompte.transferer(50.0, cA.getNumero(), cB.getNumero());
		
		Compte cAapres = serviceCompte.rechercherCompteParNum(cA.getNumero());
		Compte cBapres = serviceCompte.rechercherCompteParNum(cB.getNumero());
		System.out.println("apres bon virement:");
		System.out.println("cAapres:"+cAapres.toString());
		System.out.println("cBapres:"+cBapres.toString());
		Double nouveauSoldeA= cAapres.getSolde();
		Double nouveauSoldeB= cBapres.getSolde();
		Assert.assertEquals(50, nouveauSoldeA,0.0001); //org.junit.Assert;
		Assert.assertEquals(250, nouveauSoldeB,0.0001); //org.junit.Assert;
	}
	
	@Test
	public void testMauvaisVirement() {
		Compte cA = new Compte(); cA.setSolde(100.0);cA.setLabel("cA");
		serviceCompte.sauvegarderCompte(cA);
		Compte cB = new Compte(); cB.setSolde(200.0);cB.setLabel("cB");
		serviceCompte.sauvegarderCompte(cB);
		System.out.println("avant mauvais virement:");
		System.out.println("cA:"+cA.toString());System.out.println("cB:"+cB.toString());
		try {
			serviceCompte.transferer(50.0, cA.getNumero(), -69L /* inexistant*/);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		Compte cAapres = serviceCompte.rechercherCompteParNum(cA.getNumero());
		Compte cBapres = serviceCompte.rechercherCompteParNum(cB.getNumero());
		System.out.println("apres mauvais virement:");
		System.out.println("cAapres:"+cAapres.toString());
		System.out.println("cBapres:"+cBapres.toString());
		Double nouveauSoldeA= cAapres.getSolde();Double nouveauSoldeB= cBapres.getSolde();
		Assert.assertEquals(100, nouveauSoldeA,0.0001); //org.junit.Assert;
		Assert.assertEquals(200, nouveauSoldeB,0.0001); //org.junit.Assert;
	}

}
