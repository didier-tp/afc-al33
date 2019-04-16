package fr.afcepf.al33.client;

import java.net.URL;
import java.util.Map;

import javax.xml.ws.BindingProvider;

import fr.afcepf.al33.conv.Convertisseur;
import fr.afcepf.al33.conv.ConvertisseurImplService;

public class TestAppelWsSoapApp {

	
    //à lancer via Run as / java application
	public static void main(String[] args) {
		//code d'appel du WS soap qui s'appuie sur le code généré
		//pas wimport -keep -... URL_WSDL
		//.... (...Service).get...Port() 
		
		try {
			String sEndPointUrl = 
					"http://192.168.102.144:7979/serveursoap/ConvertisseurImpl";
					//"http://192.168.102.74:7979/serveurSoapD/ConvertisseurImpl";
			String sWsdlUrl = sEndPointUrl + "?wsdl";
			URL wsdlUrl = new URL(sWsdlUrl);
			Convertisseur proxyWsConvertisseur
			= (new ConvertisseurImplService(wsdlUrl)).getConvertisseurImplPort();
			
			//preciser l'url soap (seulement si necessaire):
			javax.xml.ws.BindingProvider bp = 
					  (javax.xml.ws.BindingProvider) proxyWsConvertisseur;
			Map<String,Object> context = bp.getRequestContext();
			context.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,sEndPointUrl);
			
			System.out.println("15 euros=" + 
			    proxyWsConvertisseur.euroToFranc(15.0));
			System.out.println("auteur=" + proxyWsConvertisseur.getAuteur());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
