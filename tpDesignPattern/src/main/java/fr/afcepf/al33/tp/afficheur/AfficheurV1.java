package fr.afcepf.al33.tp.afficheur;

import javax.swing.JOptionPane;

public class AfficheurV1 implements Afficheur {

	@Override
	public void afficherMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	@Override
	public void afficherObjet(Object objet) {
		JOptionPane.showMessageDialog(null, objet.toString());
	}

}
