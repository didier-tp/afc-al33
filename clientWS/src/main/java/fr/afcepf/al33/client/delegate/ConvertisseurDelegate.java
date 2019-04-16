package fr.afcepf.al33.client.delegate;

//cette interface sera inmplémentée par:
//   ConvertisseurDelegateSoap
//ou ConvertisseurDelegateRest
//ou ConvertisseurDelegateRmi
//ou ...
public interface ConvertisseurDelegate {
	String getAuteur();
	double euroToFranc(double montant);
	double francToEuro(double montant);
	double convertir(double montant,String source,String cible);
}
