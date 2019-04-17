package fr.afcepf.al33.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.afcepf.al33.conv.Convertisseur;
import fr.afcepf.al33.dao.DeviseDao;
import fr.afcepf.al33.entity.Devise;

@RestController //@Component de type @RestController
@RequestMapping(value="/rest/devises" , headers="Accept=application/json")
public class DeviseRestCtrl {

	@Autowired //injection du "business service" 
	private Convertisseur convertisseur;
	
	@Autowired //injection le dao (temporairement) 
	private DeviseDao deviseDao;
	
	//URL= http://localhost:8080/springBootWebService/rest/devises/EUR
	@RequestMapping(value="/{codeDevise}" , method=RequestMethod.GET)
	public ResponseEntity<Devise> getDeviseByCode(@PathVariable("codeDevise") String codeDevise) {
		Devise d = deviseDao.findById(codeDevise).orElse(null);
		if(d!=null)
			return new ResponseEntity<Devise>(d,HttpStatus.OK);//200=OK
		else
			return new ResponseEntity<Devise>(HttpStatus.NOT_FOUND);//404=NOT_FOUND
	}
	
	//URL= http://localhost:8080/springBootWebService/rest/devises
	//URL= http://localhost:8080/springBootWebService/rest/devises?tauxChangeMini=1
	@RequestMapping(value="" , method=RequestMethod.GET)
	public List<Devise> getDevises(@RequestParam(value="tauxChangeMini",
	                               required=false) Double tauxChangeMini) {
		
		List<Devise> toutesDevises = (List<Devise>) deviseDao.findAll();
		
		if(tauxChangeMini==null)
			return toutesDevises;
		else
			return toutesDevises.stream()
					  .filter((d)-> d.getTauxChange()>=tauxChangeMini)
					  .collect(Collectors.toList());
	}

}
