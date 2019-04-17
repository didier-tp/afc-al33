package fr.afcepf.al33.dto;
//.payload quelquefois utilisé à la place de .dto

import lombok.AllArgsConstructor;

// DTO = Data Transfert Object 
//objet de données tranférées à travers le réseau (via REST ou SOAP ou RMI)
//surtout pas de @Entity

import lombok.Data;

//@ToString @Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Data @AllArgsConstructor
public class ResConv {
	private Double montant;
	private String source;
	private String cible;
	private Double montantConverti;

}
