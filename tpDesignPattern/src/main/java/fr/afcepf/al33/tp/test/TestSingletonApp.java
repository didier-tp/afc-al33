package fr.afcepf.al33.tp.test;

import fr.afcepf.al33.tp.dao.ProduitDaoJpa;

public class TestSingletonApp {
	
	public static void m1() {
		ProduitDaoJpa dao = ProduitDaoJpa.getInstance();
		System.out.println(dao.toString());
		System.out.println(dao.getData());
	}

	public static void main(String[] args) {
		ProduitDaoJpa produitDao = null; 
		
		//vérifier new direct interdit si constructeur privé 
		//dans classe ProduitDaoJpa
		//produitDao = new ProduitDaoJpa();
		
		// créer une instance via un appel à .getInstance()
		produitDao = ProduitDaoJpa.getInstance();
		produitDao.setData("abc");
		
		//appeler la méthode .toString() sur l'unique instance récupérée
		
		System.out.println(produitDao.toString());
        m1();
	}

}
