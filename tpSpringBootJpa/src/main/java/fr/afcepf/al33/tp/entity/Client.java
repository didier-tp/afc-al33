package fr.afcepf.al33.tp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor
@Entity
@NamedQuery(name="Client.findAll",query="SELECT c FROM Client c")
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numero;
	
	private String nom;
	private String prenom;

	private String telephone;
	private String email;
	//private String password;
	
	
	
    @Transient //temporairement
	private Adresse adresse;
	
	
	
	@Override
	public String toString() {
		return "Client [numero=" + numero + ", nom=" + nom + ", prenom="
				+ prenom + ", adresse=" + adresse + ", telephone="
				+ telephone + ", email=" + email 
				+ "]";
	}


	public Client(Long numero, String nom, String prenom, String telephone, String email) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
	}
	
	
}
