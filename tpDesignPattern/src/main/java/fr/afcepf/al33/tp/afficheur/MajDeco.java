package fr.afcepf.al33.tp.afficheur;

public class MajDeco extends AffDecorateur {

	public MajDeco(Afficheur subAff) {
		super(subAff);
	}

	@Override
	public void afficherMessage(String message) {
		super.afficherMessage(message.toUpperCase());
	}

	@Override
	public void afficherObjet(Object objet) {
		super.afficherMessage(objet.toString().toUpperCase());
	}
	

}
