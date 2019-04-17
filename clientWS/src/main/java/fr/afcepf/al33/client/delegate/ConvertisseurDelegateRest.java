package fr.afcepf.al33.client.delegate;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class ConvertisseurDelegateRest implements ConvertisseurDelegate {

	private Client jaxrs2client;
	
	public ConvertisseurDelegateRest() {
		this.jaxrs2client = ClientBuilder.newClient();
	}
	
	@Override
	public double convertir(double montant, String source, String cible) {
		String convUrl = 
				"http://localhost:8080/springBootWebService/rest/devises/convertir";
		WebTarget convTarget = jaxrs2client.target(convUrl);
		
		String res= convTarget.request(MediaType.APPLICATION_JSON_TYPE)
		                .get().readEntity(String.class);
		System.out.println("res="+res);
		return 0;
	}

	@Override
	public String getAuteur() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double euroToFranc(double montant) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double francToEuro(double montant) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
