package fr.afcepf.al33.tp.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Film {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numero;
	
	@ManyToMany
	@JoinTable(name="film_acteur",
	           joinColumns= { @JoinColumn(name="num_film")},
	           inverseJoinColumns= {@JoinColumn(name="id_acteur")})
	private List<Acteur> acteurs;
	
	private String titre;
	private String description;
	
	@Override
	public String toString() {
		return "Film [numero=" + numero + ", titre=" + titre + ", description=" + description + "]";
	}

	public Film(Long numero, String titre, String description) {
		super();
		this.numero = numero;
		this.titre = titre;
		this.description = description;
	}
	
	

}
