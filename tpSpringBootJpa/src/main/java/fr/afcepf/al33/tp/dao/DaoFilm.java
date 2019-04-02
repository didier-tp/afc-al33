package fr.afcepf.al33.tp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.afcepf.al33.tp.entity.Film;

public interface DaoFilm extends CrudRepository<Film,Long>{
    //méthodes héritées: findById, save, deleteById, ...
	
	//méthodes supplémentaires via conventions de noms:
	List<Film> /*Film*/ findByTitre(String titre); 
	List<Film> findByDescription(String description);
	//retournera souvent liste à 1 seul élément
}
