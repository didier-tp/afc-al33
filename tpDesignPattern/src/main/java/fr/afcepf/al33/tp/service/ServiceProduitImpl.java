package fr.afcepf.al33.tp.service;

import java.util.List;

import javax.inject.Inject;

import fr.afcepf.al33.tp.dao.DaoProduit;

public class ServiceProduitImpl implements ServiceProduit {
	
	@Inject //pour demander à initialiser la référence daoProduit
	        //de façon à ce que ça pointe vers un composant existant 
	        //dont le type (DaoProduitV1 ou DaoProduitV2) est compatible
	        //avec l'interface DaoProduit
	private DaoProduit daoProduit; //null par defaut (sans @Inject)

	@Override
	public List<String> rechercherProduits() {
		//code améliorable
		return daoProduit.findProducts();
	}

}
