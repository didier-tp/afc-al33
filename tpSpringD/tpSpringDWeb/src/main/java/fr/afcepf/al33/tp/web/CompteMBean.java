package fr.afcepf.al33.tp.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al33.tp.entity.Compte;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
//@RequestScoped
@SessionScoped
@Getter @Setter
public class CompteMBean {
	
	private Long numClient; //à saisir via h:inputText
	
	private List<Compte> comptes; //à afficher via h:dataTable
	
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
	}

	public CompteMBean() {
	}

}
