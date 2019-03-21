package fr.afcepf.al33.tp.test;

import fr.afcepf.al33.tp.afficheur.Afficheur;
import fr.afcepf.al33.tp.afficheur.AfficheurV1;

public class TestDecorateurApp {

	public static void main(String[] args) {
		Afficheur afficheur=null;
		Afficheur afficheurSimple = new AfficheurV1();
		//Afficheur afficheurMaj = new MajDeco(afficheurSimple);
		//Afficheur afficheurLog = new LogDeco(afficheurSimple);
		//Afficheur afficheurLogMaj = new LogDeco(afficheurMaj);
		
		afficheur=afficheurSimple;
		//afficheur=afficheurLog;
		//afficheur=afficheurMaj;
		//afficheur=afficheurLogMaj;
		
		afficheur.afficherObjet("MontRouge");
	}

}
