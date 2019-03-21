package fr.afcepf.al33.tp.afficheur;

public  abstract class AffDecorateur implements Afficheur {
	private Afficheur subAff;
	
	public AffDecorateur(Afficheur subAff) {
		this.subAff = subAff;
	}

	@Override
	public void afficherMessage(String message) {
		subAff.afficherMessage(message);
	}

	@Override
	public void afficherObjet(Object objet) {
		subAff.afficherObjet(objet);
	}
	
	
}
