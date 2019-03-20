package fr.afcepf.al33.tp.test;

import java.lang.reflect.Field;

import fr.afcepf.al33.tp.data.MyPojo;

public class TestAnnotationApp {
	
	public static void verifierValidite(Object objet) {
		try {
			Class metaClasse = objet.getClass();
			System.out.println(metaClasse.getName());
			for(Field f : metaClasse.getDeclaredFields()) {
				System.out.println("nom attribut: " + f.getName());
				f.setAccessible(true); //rendre accessible un attribut privé
				Object valAttribut = f.get(objet);
				System.out.println("valAttribut: " + valAttribut);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
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
