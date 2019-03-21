package fr.afcepf.al33.tp.afficheur;

public class AfficheurV2 implements Afficheur {

	@Override
	public void afficherMessage(String message) {
		System.out.println(message);
	}

	@Override
	public void afficherObjet(Object objet) {
		System.out.println( objet.toString());
	}

}
