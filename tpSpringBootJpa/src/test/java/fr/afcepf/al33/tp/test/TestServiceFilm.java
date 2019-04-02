package fr.afcepf.al33.tp.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.afcepf.al33.tp.MySpringBootApplication;
import fr.afcepf.al33.tp.entity.Film;
import fr.afcepf.al33.tp.service.ServiceFilm;


@RunWith(SpringRunner.class)
@SpringBootTest(classes= {MySpringBootApplication.class})
public class TestServiceFilm {

	@Autowired
	private ServiceFilm serviceFilm; //à tester
	
	@Test
	public void test_crud_film() {
		Film filmY = new Film(null,"titre_film1" , "bon film");
		serviceFilm.sauvegarderFilm(filmY);
		Film filmRelu = serviceFilm.rechercherFilmParNumero(filmY.getNumero());
		System.out.println("filmRelu="+filmRelu);
		Assert.assertEquals("titre_film1",filmY.getTitre());
	}

}
