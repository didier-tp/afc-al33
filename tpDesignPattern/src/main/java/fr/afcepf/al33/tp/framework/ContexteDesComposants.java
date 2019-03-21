package fr.afcepf.al33.tp.framework;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import fr.afcepf.al33.tp.dao.DaoProduit;

public class ContexteDesComposants {
	
	private Map<String,Object> mapComposants = new HashMap<>();
	private List<String> listeNomClasses = new ArrayList<>();
	
	public ContexteDesComposants(){
		listeNomClasses.add("fr.afcepf.al33.tp.service.ServiceProduitImpl");
		listeNomClasses.add("fr.afcepf.al33.tp.dao.DaoProduitV1");
		listeNomClasses.add("fr.afcepf.al33.tp.test.MainApp");
		//il serait possible de scanner automatiquement ce qui existe en dessous
		//de fr.afcepf.al33.tp pour découvrir les classes à prendre en charge
	}
	
	private boolean estCompatibleAvec(Object dependance,String interfaceName) {
		boolean ok=false;
		try {
			Class<?> interfaceMetaClasse = Class.forName(interfaceName);
			ok = interfaceMetaClasse.isAssignableFrom(dependance.getClass());
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		/*
		String nomClasseDependance = dependance.getClass().getName();
		if(nomClasseDependance.equals("fr.afcepf.al33.tp.service.ServiceProduitImpl")
				&& interfaceName.equals("fr.afcepf.al33.tp.service.ServiceProduit"))
			ok=true;
		if(nomClasseDependance.equals("fr.afcepf.al33.tp.dao.DaoProduitV1")
				&& interfaceName.equals("fr.afcepf.al33.tp.dao.DaoProduit"))
			ok=true;
			*/
		return ok;
	}
	
	private void gererInjection(Object composant) throws Exception{
		Class metaClasse = composant.getClass();
		for(Field f : metaClasse.getDeclaredFields()) {
			f.setAccessible(true); //pour que ça fonctionne aussi sur des choses privées
			Inject annotInject = f.getAnnotation(Inject.class);
			if(annotInject!=null) {
				for(Object dependance : mapComposants.values()) {
				    if( estCompatibleAvec(dependance,f.getType().getName())) {
				    	f.set(composant,dependance /* valeur à affecter*/);
				    }
				}
			}
		}
	}
	
	public Object acceder_a_un_des_composants_construits(String nom) {
		return mapComposants.get(nom);
	}
	
	public void construire_et_relier_composants() {
		try {
			//boucle pour construire/instancier tous les composants
			for(String nomClasse : listeNomClasses) {
				Object instanceComposant = Class.forName(nomClasse).newInstance();
				mapComposants.put(nomClasse, instanceComposant);
			}
			//boucle pour relier les composants entre eux:
			for(String nomClasse : listeNomClasses) {
				gererInjection(mapComposants.get(nomClasse));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
