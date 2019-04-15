package fr.afcepf.al33.client;

import fr.afcepf.al33.conv.Convertisseur;
import fr.afcepf.al33.conv.ConvertisseurImplService;

public class TestAppelWsSoapApp {

	
    //à lancer via Run as / java application
	public static void main(String[] args) {
		//code d'appel du WS soap qui s'appuie sur le code généré
		//pas wimport -keep -... URL_WSDL
		//.... (...Service).get...Port() 
        Convertisseur proxyWsConvertisseur
        = (new ConvertisseurImplService()).getConvertisseurImplPort();
        
        System.out.println("15 euros=" + 
            proxyWsConvertisseur.euroToFranc(15.0));
	}

}
