package fr.afcepf.al33.tp.test;

import java.lang.reflect.Field;

import fr.afcepf.al33.tp.annot.MadMax;
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
				MadMax madMaxAnnot = f.getAnnotation(MadMax.class);
				if(madMaxAnnot!=null) {
				   int valMaxDeAnnot = madMaxAnnot.value();
				   System.out.println("val maxi autorisée: " + valMaxDeAnnot);
				   if(f.getType().getName().equals("int") || f.getType().getName().equals("long")) {
					   int valNumerique = Integer.parseInt(valAttribut.toString());
					   if(valNumerique > valMaxDeAnnot) {
						   System.out.println("valeur invalide ...");
						   //ou bien retourner true or false
						   //ou bien remonter exception , ....
					   }
				   }
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	

	public static void main(String[] args) {
		MyPojo mp1 = new MyPojo(); 
		mp1.setLabel("mp1"); mp1.setValeurQuiVaPeutEtreBien(80);
		
		verifierValidite(mp1);
		
		MyPojo mp2 = new MyPojo(); 
		mp2.setLabel("mp2"); mp2.setValeurQuiVaPeutEtreBien(150);
		
		verifierValidite(mp2);
	}

}
