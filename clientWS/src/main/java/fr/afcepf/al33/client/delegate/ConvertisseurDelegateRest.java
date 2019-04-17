package fr.afcepf.al33.client.delegate;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.jackson.JacksonFeature;

import fr.afcepf.al33.dto.ResConv;

public class ConvertisseurDelegateRest implements ConvertisseurDelegate {

	private Client jaxrs2client;
	private String debutUrlDevise="http://localhost:8080/springBootWebService/rest/devises";
	public ConvertisseurDelegateRest() {
		this.jaxrs2client = ClientBuilder.newClient()
				            .register(JacksonFeature.class);
	}
	@Override
	public double convertir(double montant, String source, String cible) {
		//..../rest/devises/convertir?montant=50&source=EUR&cible=USD
		WebTarget convTarget = jaxrs2client.target(debutUrlDevise)
				                           .path("convertir")
				                           .queryParam("montant", montant)
										   .queryParam("source", source)
										   .queryParam("cible", cible);
		
		/*String jsonStringRes= convTarget.request(MediaType.APPLICATION_JSON_TYPE)
		                .get().readEntity(String.class);
		System.out.println("jsonStringRes="+jsonStringRes);*/
		ResConv resConv= convTarget.request(MediaType.APPLICATION_JSON_TYPE)
                .get().readEntity(ResConv.class);
		return resConv.getMontantConverti();
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
