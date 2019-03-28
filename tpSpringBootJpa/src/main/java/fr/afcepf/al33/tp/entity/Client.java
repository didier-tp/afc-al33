package fr.afcepf.al33.tp.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor
@Entity
@NamedQueries({
   @NamedQuery(name="Client.findAll",query="SELECT c FROM Client c"),
   @NamedQuery(name="Client.findComptesOfClientSimple",
               query="SELECT cpt FROM Compte cpt WHERE cpt.client.numero = :numClient") ,
   @NamedQuery(name="Client.findComptesOfClient",
              query="SELECT cpt FROM Client cli INNER JOIN cli.comptes cpt WHERE cli.numero = :numClient")
})
/* :numClient pour .setParameter("numClient", ....) , 
et  cpt est un alias pour un membre de la collection cli.comptes */
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numero;
	
	private String nom;
	private String prenom;

	private String telephone;
	private String email;
	//private String password;
	
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	//mappedBy="nom java de la relation inverse manyToOne"
	private List<Compte> comptes;
	
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
