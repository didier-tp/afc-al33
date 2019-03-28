package fr.afcepf.al33.tp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the compte database table.
 * 
 */

@Getter @Setter @NoArgsConstructor
@Entity
public class Compte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length=64) //VARCHAR(64)
	private String label;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//auto_increment géré par mysql ou h2
	private Long numero;

	private Double solde;

	
}