package fr.afcepf.al33.tp.web;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.afcepf.al33.tp.entity.Compte;
import fr.afcepf.al33.tp.service.ServiceClient;
import lombok.Getter;
import lombok.Setter;

//@ManagedBean
//@SessionScoped
@Component //cette classe sera d'abord gérée par spring, puis ré-utilisée par JSF
@Scope("request")//ou @Scope("session")
@Getter @Setter
public class CompteMBean {
	
	private Long numClient; //à saisir via h:inputText
	
	private List<Compte> comptes; //à afficher via h:dataTable
	
	//@ManagedProperty("#{serviceClientImpl}")
	@Autowired //ressemble à @EJB ou @Inject
	private ServiceClient serviceClient;
	
	@PostConstruct
	public void initAfterInjection() {
		/*Client cli= new Client(.)
		serviceClient.saveOrUpdateClient(cli);*/
		//OU BIEN import.sql spécifique à Hibernate
		//de scr/main/resources du projet ...Core 
	}
	
	public String doSearchComptes() {
		comptes = serviceClient.rechercherComptesDuClient(this.numClient);
		return null;
	}
	
	/*
	public String doSearchComptes() {
		String suite=null; //rester par defaut sur meme page .xhtml
		//V1 (simulation) sans spring si database:
		comptes = new ArrayList<>();
		Compte cA = new Compte(); cA.setNumero(1L);
		cA.setSolde(150.0); cA.setLabel("cA");
		comptes.add(cA);
		Compte cB = new Compte(); cB.setNumero(2L);
		cB.setSolde(250.0); cB.setLabel("cB");
		comptes.add(cB);
		return suite;//si on retourne null on reste sur la meme page xhtml
		             //si on retourne pageXy on demande a naviguer vers pageXy.xhtml
	}*/
	

	public CompteMBean() {
	}

}
