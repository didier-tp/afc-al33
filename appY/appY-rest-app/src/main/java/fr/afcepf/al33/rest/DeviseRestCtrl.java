package fr.afcepf.al33.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.afcepf.al33.conv.Convertisseur;
import fr.afcepf.al33.dao.DeviseDao;
import fr.afcepf.al33.dto.ResConv;
import fr.afcepf.al33.entity.Devise;

@CrossOrigin("*")//pour accepter de répondre à des appels ajax 
                 //provenant d'autres domaines/applications/...

@RestController //@Component de type @RestController
@RequestMapping(value="/rest/devises" , headers="Accept=application/json")
public class DeviseRestCtrl {

	@Autowired //injection du "business service" 
	private Convertisseur convertisseur;
	
	@Autowired //injection le dao (temporairement) 
	private DeviseDao deviseDao;
	
	//URL= http://localhost:8080/springBootWebService/rest/devises
	//en mode POST avec la partie body invisible de la requete contenant
	//{ "code" : "cxy" , "monnaie" : "monnaieXy" , "tauxChange": 2.2  }
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="" , method=RequestMethod.POST)
	public Devise createOrUpdateDevise(@RequestBody @Valid Devise devise) {
		deviseDao.save(devise);
		return devise; //quelquefois (pas ici) l'objet retourné comporte id auto_incr
	}
	
	
	//URL= http://localhost:8080/springBootWebService/rest/devises/EUR
	@RequestMapping(value="/{codeDevise}" , method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteDeviseByCode(@PathVariable("codeDevise") 
	                                            String codeDevise) {
		//try {
			Devise d = deviseDao.findById(codeDevise).get();//get() remonte exception si null
			deviseDao.delete(d);
			return new ResponseEntity<>(HttpStatus.OK);
		/*} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}*/ //traitement d'exception dejà effectué par defaut
	}
	
	
}
