package fr.afcepf.al33.tp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.afcepf.al33.tp.entity.Acteur;

public interface DaoActeur extends JpaRepository/*CrudRepository*/<Acteur,Long>{
	 //méthodes héritées: findById, save, deleteById, ...
	
	//méthodes supplémentaires via conventions de noms:
	List<Acteur> findByNomAndPrenom(String nom,String prenom);
	List<Acteur> findByNom(String nom);
	List<Acteur> findByPrenom(String prenom);
}
