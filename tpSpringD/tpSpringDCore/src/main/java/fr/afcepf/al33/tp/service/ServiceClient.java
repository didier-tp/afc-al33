package fr.afcepf.al33.tp.service;

import java.util.List;

import fr.afcepf.al33.tp.entity.Client;
import fr.afcepf.al33.tp.entity.Compte;

/**
 * 
 * Interface du "Business Service" (Service métier) "ServiceClient"
 * comportant:
 *    - des méthodes CRUD déléguées au DAO
 *    - des méthodes associées à des règles de gestion (verif...)
 *    - des méthodes avec comportement transactionnel
 *    - des méthodes spécifiques au métier
 */

public interface ServiceClient {
		public Client rechercherClientParNumero(Long numero);
		public Client rechercherEtMajClientParNumero(Long numero);
		public List<Client> rechercherTousClients();
		public List<Compte> rechercherComptesDuClient(Long numClient);
		public void ajouterComptePourClient(Long numClient,Long numCompte);
		public void saveOrUpdateClient(Client cpt);
		public void supprimerClient(Long numClient);
		
		
}
