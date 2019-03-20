package fr.afcepf.al33.tp.dao;

public class ProduitDaoJpa {
	
	private String data; //+get/set
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	private static ProduitDaoJpa uniqueInstance=null;
	
	public synchronized static ProduitDaoJpa getInstance() {
		if(uniqueInstance==null) {
			uniqueInstance = new ProduitDaoJpa();
		}
		return uniqueInstance;
	}
	
	private ProduitDaoJpa(){
	   //constructeur privé pour interdire new direct depuis une autre classe	
	}
	
	

}
