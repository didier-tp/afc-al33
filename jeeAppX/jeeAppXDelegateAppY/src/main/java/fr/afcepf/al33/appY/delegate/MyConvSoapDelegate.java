package fr.afcepf.al33.appY.delegate;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import fr.afcepf.al33.conv.Convertisseur;

public class MyConvSoapDelegate implements Convertisseur{
	
	private static MyConvSoapDelegate uniqueInstance=null;
	public static MyConvSoapDelegate getInstance() {
		if(uniqueInstance==null) uniqueInstance = new MyConvSoapDelegate();
		return uniqueInstance;
	}
	
	Convertisseur convWSProxy = null;
	
	public MyConvSoapDelegate(){
		//infos dans le WSDL
		//initialiation dynamique du proxy soap (sans wsimport , avec interface java "@WebService")
		QName SERVICE_NAME = new QName("http://conv.al33.afcepf.fr/", "ConvertisseurImplService");
		QName PORT_NAME = new QName("http://conv.al33.afcepf.fr/", "ConvertisseurImplPort");
		// en précisant une URL WSDL connue et accessible
		String wdlUrl =
		"http://localhost:8080/springBootWebService/service/convertisseur?wsdl";
		URL wsdlDocumentLocation=null;
		try {wsdlDocumentLocation = new URL(wdlUrl);
		} catch (MalformedURLException e) { e.printStackTrace();}
		//avec import javax.xml.ws.Service;
		Service service = Service.create(wsdlDocumentLocation, SERVICE_NAME);
		convWSProxy = (Convertisseur)service.getPort(PORT_NAME, Convertisseur.class);
	}

	@Override
	public double euroToFranc(double montant) {
		return convWSProxy.euroToFranc(montant);
	}

	@Override
	public double francToEuro(double montant) {
		return convWSProxy.francToEuro(montant);
	}

	@Override
	public String getAuteur() {
		return convWSProxy.getAuteur();
	}

	@Override
	public double convertir(double montant, String source, String cible) {
		return convWSProxy.convertir(montant, source, cible);
	}

	

}
