package fr.afcepf.al33.tp.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the compte database table.
 * 
 */

@Getter @Setter @NoArgsConstructor

public class Compte implements Serializable {
	private static final long serialVersionUID = 1L;

	private String label;

	
	private Long numero;

	private Double solde;

	
}