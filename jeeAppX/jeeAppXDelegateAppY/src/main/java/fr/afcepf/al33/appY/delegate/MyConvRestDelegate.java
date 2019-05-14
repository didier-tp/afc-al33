package fr.afcepf.al33.appY.delegate;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import fr.afcepf.al33.conv.Convertisseur;
import fr.afcepf.al33.dto.ResConv;

public class MyConvRestDelegate implements Convertisseur{
	
	private static MyConvRestDelegate uniqueInstance=null;
	public static MyConvRestDelegate getInstance() {
		if(uniqueInstance==null) uniqueInstance = new MyConvRestDelegate();
		return uniqueInstance;
	}
	
	//private ObjectMapper mapper = new ObjectMapper();
	private Client jaxrs2client;
	//private String debutUrlDevise="http://localhost:8080/springBootWebService/rest/devises";
	private String debutUrlDevisePublic="http://localhost:8080/springBootWebService/rest/public/devises";
	
	
	public MyConvRestDelegate(){
		this.jaxrs2client = ClientBuilder.newClient();
	            //.register(JacksonFeature.class);
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

	@Override
	public String getAuteur() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double convertir(double montant, String source, String cible) {
		//..../rest/public/devises/convertir?montant=50&source=EUR&cible=USD
				WebTarget convTarget = jaxrs2client.target(debutUrlDevisePublic)
						                           .path("convertir")
						                           .queryParam("montant", montant)
												   .queryParam("source", source)
												   .queryParam("cible", cible);
				/*
				String jsonStringRes= convTarget.request(MediaType.APPLICATION_JSON_TYPE)
				                .get().readEntity(String.class);
				System.out.println("jsonStringRes="+jsonStringRes);
				
				ResConv resConv = null;
				try {
					resConv = mapper.readValue(jsonStringRes, ResConv.class);
				} catch (Exception e) {
					e.printStackTrace();
				}*/
				
				ResConv resConv= convTarget.request(MediaType.APPLICATION_JSON_TYPE)
		                .get().readEntity(ResConv.class);
				return resConv.getMontantConverti();
	}

	

}
