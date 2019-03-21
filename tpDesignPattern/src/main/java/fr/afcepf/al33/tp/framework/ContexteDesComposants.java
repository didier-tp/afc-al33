package fr.afcepf.al33.tp.framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContexteDesComposants {
	
	private Map<String,Object> mapComposants = new HashMap<>();
	private List<String> listeNomClasses = new ArrayList<>();
	
	ContexteDesComposants(){
		listeNomClasses.add("fr.afcepf.al33.tp.service.ServiceProduitImpl");
		listeNomClasses.add("fr.afcepf.al33.tp.dao.DaoProduitV1");
		listeNomClasses.add("fr.afcepf.al33.tp.test.MainApp");
		//il serait possible de scanner automatiquement ce qui existe en dessous
		//de fr.afcepf.al33.tp pour découvrir les classes à prendre en charge
	}
	
	public void construire_et_relier_composants() {
		try {
			for(String nomClasse : listeNomClasses) {
				Object instanceComposant = Class.forName(nomClasse).newInstance();
				mapComposants.put(nomClasse, instanceComposant);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
