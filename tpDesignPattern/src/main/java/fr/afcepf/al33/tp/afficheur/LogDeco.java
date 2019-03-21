package fr.afcepf.al33.tp.afficheur;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogDeco extends AffDecorateur {
	
	private Logger logger = LoggerFactory.getLogger(AffDecorateur.class);

	public LogDeco(Afficheur subAff) {
		super(subAff);
	}

	@Override
	public void afficherMessage(String message) {
		//System.out.println("LOG>>" + message);
		logger.info("LOG>> " + message + " <<");
		super.afficherMessage(message);
	}

	@Override
	public void afficherObjet(Object objet) {
		//System.out.println("LOG>>" + objet.toString());
		logger.info("LOG>> " + objet.toString() + " <<");
		super.afficherObjet(objet);
	}
	
	

}
