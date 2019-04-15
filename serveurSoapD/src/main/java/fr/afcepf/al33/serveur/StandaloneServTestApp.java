package fr.afcepf.al33.serveur;

import javax.xml.ws.Endpoint;

import fr.afcepf.al33.conv.ConvertisseurImpl;
//https://github.com/didier-tp/afc-al33
public class StandaloneServTestApp {

	public StandaloneServTestApp() {
		System.out.println("demarrage du serveurSoap ...");
		String URL="http://localhost:8087/conv/Convertisseur";//url du endpoint soap
		ConvertisseurImpl implementor= new ConvertisseurImpl();
		System.out.println("URL WSDL="+URL+"?wsdl");
		Endpoint.publish(URL, implementor);//ça démarre un mini container web/http
		//intégré à la machine virtuelle java (ressemblant à Jetty)
	}

	public static void main(String[] args) {
		new StandaloneServTestApp();//thread en tache de fond pour traiter requetes
		try {
			Thread.sleep(1000 * 60 * 15); //pause de 15 minutes
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("arret automatique du serveur au bout de 15 minutes");
		System.exit(0);//arret complet (de tous les Threads) du serveur
	}

}
