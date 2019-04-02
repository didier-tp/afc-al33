package fr.afcepf.al33.tp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al33.tp.dao.DaoActeur;
import fr.afcepf.al33.tp.dao.DaoFilm;
import fr.afcepf.al33.tp.entity.Acteur;
import fr.afcepf.al33.tp.entity.Film;

@Service
@Transactional
public class ServiceFilmImpl implements ServiceFilm {
	@Autowired
	private DaoFilm daoFilm;
	@Autowired
	private DaoActeur daoActeur;
	
	@Override
	public void ajouterlienFilmActeur(Long numFilm, Long idActeur) {
		Acteur a = daoActeur.findById(idActeur).get();
		Film f = daoFilm.findById(numFilm).get();
		f.getActeurs().add(a); //A FAIRE ABSOLUMENT car coté principal avec @JoinTable
		//a.getFilms().add(f);//coté secondaire (mappedBy) 
		                      //pas persisté par commit/flush automatique
	}

	@Override
	public List<Acteur> acteursDuFilm(Long numeroFilm) {
		Film f = daoFilm.findById(numeroFilm).get();
		f.getActeurs().size(); //.size() to avoid lazyException coté web/test
		return f.getActeurs();
	}

	@Override
	public Film rechercherFilmParNumero(Long num) {
		return daoFilm.findById(num).orElse(null);
	}

	@Override
	public List<Film> rechercherFilmsParTitre(String titre) {
		return daoFilm.findByTitre(titre);
	}

	@Override
	public void sauvegarderFilm(Film film) {
		daoFilm.save(film);
	}

	@Override
	public void supprimerFilm(Long numFilm) {
		daoFilm.deleteById(numFilm);
	}

	

}
