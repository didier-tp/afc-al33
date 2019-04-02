package fr.afcepf.al33.tp.service;

import java.util.List;

import fr.afcepf.al33.tp.entity.Acteur;
import fr.afcepf.al33.tp.entity.Film;

public interface ServiceFilm {
	Film rechercherFilmParNumero(Long num);
	List<Film> rechercherFilmsParTitre(String titre);
	void sauvegarderFilm(Film film);//insert or update
	void supprimerFilm(Long numFilm);
    void ajouterlienFilmActeur(Long numFilm,Long idActeur);
    List<Acteur> acteursDuFilm(Long numeroFilm);
}
