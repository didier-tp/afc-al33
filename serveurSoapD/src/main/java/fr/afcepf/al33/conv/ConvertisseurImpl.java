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
