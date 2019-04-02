package fr.afcepf.al33.tp.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afcepf.al33.tp.MySpringBootApplication;
import fr.afcepf.al33.tp.entity.Acteur;
import fr.afcepf.al33.tp.entity.Film;
import fr.afcepf.al33.tp.service.ServiceActeur;
import fr.afcepf.al33.tp.service.ServiceFilm;


@RunWith(SpringRunner.class)
@SpringBootTest(classes= {MySpringBootApplication.class})
public class TestServiceFilm {

	@Autowired
	private ServiceFilm serviceFilm; //à tester
	
	@Autowired
	private ServiceActeur serviceActeur; //annexe
	
	@Test
	public void test_acteur_film() {
		Film filmA = new Film(null,"film A","bon film");serviceFilm.sauvegarderFilm(filmA);
		Film filmB = new Film(null,"film B","bon film");serviceFilm.sauvegarderFilm(filmB);
		Film filmC = new Film(null,"film C","navet");serviceFilm.sauvegarderFilm(filmC);
		
		Acteur acteurBelmondo = new Acteur(null,"Belmondo" ,"Jean paul");
		serviceActeur.sauvegarderActeur(acteurBelmondo);
		Acteur acteurDepardieu = new Acteur(null,"Depardieu" ,"Gerard");
		serviceActeur.sauvegarderActeur(acteurDepardieu);
		Acteur actriceCecile = new Acteur(null,"Defrance" ,"Cecile");
		serviceActeur.sauvegarderActeur(actriceCecile);
		
		serviceFilm.ajouterlienFilmActeur(filmA.getNumero(), acteurBelmondo.getId());
		serviceFilm.ajouterlienFilmActeur(filmA.getNumero(), acteurDepardieu.getId());
		
		serviceFilm.ajouterlienFilmActeur(filmB.getNumero(), acteurDepardieu.getId());
		serviceFilm.ajouterlienFilmActeur(filmB.getNumero(), actriceCecile.getId());
		
		List<Acteur> acteursDuFilmB = serviceFilm.acteursDuFilm(filmB.getNumero());
		Assert.assertTrue(acteursDuFilmB.size()>=2);
		System.out.println("acteursDuFilmB="+acteursDuFilmB);
	}
	
	@Test
	public void test_crud_film() {
		Film filmY = new Film(null,"titre_film1" , "bon film");
		serviceFilm.sauvegarderFilm(filmY);
		Film filmRelu = serviceFilm.rechercherFilmParNumero(filmY.getNumero());
		System.out.println("filmRelu="+filmRelu);
		Assert.assertEquals("titre_film1",filmY.getTitre());//org.junit.Assert
		
		//Tester éventuellement autres recherches , mise à jour , suppression, ...
	}

}
