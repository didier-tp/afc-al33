package fr.afcepf.al33.client;

import fr.afcepf.al33.client.delegate.ConvertisseurDelegate;
import fr.afcepf.al33.client.delegate.ConvertisseurDelegateSoap;

public class TestAppelWsSoapApp {

	
    //à lancer via Run as / java application
	public static void main(String[] args) {
		 
		
		ConvertisseurDelegate convertisseurDelegate = new ConvertisseurDelegateSoap();
		
			System.out.println("15 euros=" + 
					convertisseurDelegate.euroToFranc(15.0));
			System.out.println("auteur=" + convertisseurDelegate.getAuteur());
		
	}

}
