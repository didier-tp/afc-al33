package fr.afcepf.al33.conv;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;

import fr.afcepf.al33.dao.DeviseDao;
import fr.afcepf.al33.entity.Devise;

@Stateless
//@Local 
@Remote

//Run as , Run on serveur en se placant sur le projet serveurSoap
//si project facet EJB

//NB: Jboss (et d'autres technos java) n'acceptent par defaut (en mode dev)
//que des requetes provenant de localhost.
//IL FAUT ajouter l'option -b 0.0.0.0 au démarrage de jboss
//pour qu'il accepte des requêtes provenant d'autres machines
//avec eclipse , server_jboss /open / open lauch config 
//decocher "always update config from runtime" et remplacer -b localhost
//par -b 0.0.0.0 puis redémarrer jboss (stop et run as run on server)

//test via soap-ui : au niveau de l'url , add new endpoint
//et remplacer localhost par 192.168.102.74 ou autre (selon ipconfig)

//http://localhost:7979_ou_8080/serveurSoapD/ConvertisseurImpl?wsdl
//est l'url visible au démarrage dans la console jboss (sous eclipse ou pas)
@WebService(endpointInterface="fr.afcepf.al33.conv.Convertisseur")
public class ConvertisseurImpl implements Convertisseur {
	
	@EJB //ou @Inject si META-INF/beans.xml de CDI present dans le projet ejb
	private DeviseDao deviseDao;
	
	private static final double COEFF_EURO_FRANC = 6.55957; 
	public ConvertisseurImpl() {
		super();
	}
	
	public double convertir(double montant, String source, String cible) {
		Devise deviseSource = deviseDao.getDeviseByCode(source);
		Devise deviseCible = deviseDao.getDeviseByCode(cible);
		return montant * deviseSource.getTauxChange() / deviseCible.getTauxChange();
		//ou return montant * deviseCible.getTauxChange() / deviseSource.getTauxChange();
	}

	public double euroToFranc(double montant) {
		return montant * COEFF_EURO_FRANC;
	}

	public double francToEuro(double montant) {
		return montant / COEFF_EURO_FRANC;
	}

	public String getAuteur() {
		return "didier";
	}

	

}
