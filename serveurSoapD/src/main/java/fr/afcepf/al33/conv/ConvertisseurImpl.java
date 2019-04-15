package fr.afcepf.al33.conv;

import javax.jws.WebService;

//@Stateless
@WebService(endpointInterface="fr.afcepf.al33.conv.Convertisseur")
public class ConvertisseurImpl implements Convertisseur {
	
	private static final double COEFF_EURO_FRANC = 6.55957; 
	public ConvertisseurImpl() {
		super();
	}

	public double euroToFranc(double montant) {
		return montant * COEFF_EURO_FRANC;
	}

	public double francToEuro(double montant) {
		return montant / COEFF_EURO_FRANC;
	}

	public String getAuteur() {
		return "didier";
	}

	@Override
	public double convertir(double montant, String source, String cible) {
		// sera code plus tard
		return 0;
	}

}
