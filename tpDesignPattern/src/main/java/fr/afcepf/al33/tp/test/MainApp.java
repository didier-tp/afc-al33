package fr.afcepf.al33.tp.test;

import java.util.List;

import javax.inject.Inject;

import fr.afcepf.al33.tp.service.ServiceProduit;

public class MainApp {
	
	@Inject
	private ServiceProduit serviceProduit;
	
	//@Inject
	//private Afficheur afficheur;
	
	public void doJob() {
		List<String> listeProduits = serviceProduit.rechercherProduits();
		System.out.println(listeProduits);
	}
	
   public static void main(String[] args) {
	   //version qui ne fonctionne pas:
	   (new MainApp()).doJob();
    }
}
