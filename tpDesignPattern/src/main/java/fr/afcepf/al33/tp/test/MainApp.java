package fr.afcepf.al33.tp.test;

import java.util.List;

import javax.inject.Inject;

import fr.afcepf.al33.tp.afficheur.Afficheur;
import fr.afcepf.al33.tp.framework.ContexteDesComposants;
import fr.afcepf.al33.tp.service.ServiceProduit;

public class MainApp {
	
	@Inject
	private ServiceProduit serviceProduit;
	
	
	@Inject  //ressemble à @EJB , @Autowired
	private Afficheur afficheur;
	
	public void doJob() {
		List<String> listeProduits = serviceProduit.rechercherProduits();
		afficheur.afficherObjet(listeProduits);
		//System.out.println(listeProduits);
	}
	
   public static void main(String[] args) {
	   ContexteDesComposants contexte = new ContexteDesComposants();
	   contexte.construire_et_relier_composants();
	   MainApp composantPrincipal = (MainApp)
			   contexte.acceder_a_un_des_composants_construits("fr.afcepf.al33.tp.test.MainApp");
	   composantPrincipal.doJob();
    }
   
   
   
   
   
   
   
   
   
   
   
   
}
