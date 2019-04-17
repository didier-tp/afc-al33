package fr.afcepf.al33.dto;
//.payload quelquefois utilisé à la place de .dto

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter @NoArgsConstructor @AllArgsConstructor
//@Data @AllArgsConstructor @NoArgsConstructor
public class ResConv implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Double montant;
	private String source;
	private String cible;
	private Double montantConverti;

}
