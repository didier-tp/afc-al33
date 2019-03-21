package fr.afcepf.al33.tp.traducteur;

public class TraducteurV1 implements Traducteur {

	@Override
	public String traduire(String message) {
		String res;
		switch(message) {
		case "computer":
			res="ordinateur"; break;
		case "smartPhone":
			res="telephone mobile"; break;
		case "book":
			res="livre"; break;
		default:
			res="fr_"+message;
		}
		return res;
	}

}
