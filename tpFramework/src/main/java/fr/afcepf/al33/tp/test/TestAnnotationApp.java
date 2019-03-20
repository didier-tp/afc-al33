package fr.afcepf.al33.tp.test;

import fr.afcepf.al33.tp.data.MyPojo;

public class TestAnnotationApp {
	
	public static void verifierValidite(Object objet) {
		Class metaClasse = objet.getClass();
		System.out.println(metaClasse.getName());
		//...
	}
	

	public static void main(String[] args) {
		MyPojo mp1 = new MyPojo(); 
		mp1.setLabel("mp1"); mp1.setValue(80);
		
		verifierValidite(mp1);
		
		MyPojo mp2 = new MyPojo(); 
		mp2.setLabel("mp2"); mp2.setValue(150);
		
		verifierValidite(mp2);
	}

}
