package fr.afcepf.al33.client.delegate;

import java.net.URL;
import java.util.Map;

import javax.xml.ws.BindingProvider;

import fr.afcepf.al33.conv.Convertisseur;
import fr.afcepf.al33.conv.ConvertisseurImplService;

public class ConvertisseurDelegateSoap implements ConvertisseurDelegate {

	private Convertisseur proxyWsConvertisseur;
	public ConvertisseurDelegateSoap() {
		//code d'appel du WS soap qui s'appuie sur le code généré
		//pas wimport -keep -... URL_WSDL
		//.... (...Service).get...Port()
		try {
			String sEndPointUrl = 
					//"http://192.168.102.144:7979/serveursoap/ConvertisseurImpl";
					"http://192.168.102.74:7979/serveurSoapD/ConvertisseurImpl";
			String sWsdlUrl = sEndPointUrl + "?wsdl";
			URL wsdlUrl = new URL(sWsdlUrl);
			this.proxyWsConvertisseur
			= (new ConvertisseurImplService(wsdlUrl)).getConvertisseurImplPort();
			
			//preciser l'url soap (seulement si necessaire):
			javax.xml.ws.BindingProvider bp = 
					  (javax.xml.ws.BindingProvider) proxyWsConvertisseur;
			Map<String,Object> context = bp.getRequestContext();
			context.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,sEndPointUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getAuteur() {
		return proxyWsConvertisseur.getAuteur();
	}

	@Override
	public double euroToFranc(double montant) {
		return proxyWsConvertisseur.euroToFranc(montant);
	}

	@Override
	public double francToEuro(double montant) {
		return proxyWsConvertisseur.francToEuro(montant);
	}

	@Override
	public double convertir(double montant, String source, String cible) {
		return proxyWsConvertisseur.convertir(montant, source, cible);
	}

}
