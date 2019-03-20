package fr.afcepf.al33.tp.calcul;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* Fabrique... ou ...Factory */

public class FabriqueCalcul {
	
	/*
	 éventuel singleton sur fabrique
	 */
	//si static, appel externe via Calcul calcul = FabriqueCalcul.createCalcul();
	//si singleton et pas static , appel externe via Calcul calcul = FabriqueCalcul.getInstance().createCalcul();
	//le type de retour est une chose abstraite (ex: interface)
	public static /*ou pas*/ Calcul createCalcul() {
		Calcul calcul=null;
		String calculClassName =null;
		try {
			Properties props = new Properties(); //java.util
			InputStream is = Thread.currentThread().getContextClassLoader()
				      .getResourceAsStream("calcul.properties");
			props.load(is);
			calculClassName=props.getProperty("calcul.className");
			System.out.println("calculClassName="+calculClassName);
		/*	switch(calculClassName) {
			 case "fr.afcepf.al33.tp.calcul.CalculV1" :
				calcul=new CalculV1(); break;
			 case "fr.afcepf.al33.tp.calcul.CalculV2" :
				calcul=new CalculV2(); break;
		  }	*/
		//calcul = new variable_calculClassName(); //syntaxiquement impossible
		//calcul = new "fr.afcepf.al33.tp.calcul.CalculV1"(); //syntaxiquement impossible
        //calcul = Class.forName("fr.afcepf.al33.tp.calcul.CalculV1 ou V2").newInstance();
		calcul = (Calcul) Class.forName(calculClassName).newInstance();
		} catch (Exception e) {	
			e.printStackTrace();
		} 
		return calcul;
	}

}
