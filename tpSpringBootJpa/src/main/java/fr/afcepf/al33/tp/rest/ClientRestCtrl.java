package fr.afcepf.al33.tp.rest;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.afcepf.al33.tp.entity.Adresse;
import fr.afcepf.al33.tp.entity.Client;
import fr.afcepf.al33.tp.service.ServiceClient;

@RestController
@RequestMapping(path="/rest/client", headers="Accept=application/json")
//@CrossOrigin(origins = "*")
public class ClientRestCtrl {

	@Autowired
	private ServiceClient serviceClient;
	
	//URL = http://localhost:8080/tpSpringBootJpa/rest/client/1
	@RequestMapping(value="/{numClient}" , method=RequestMethod.GET)
	public Client getClientByNum(@PathVariable("numClient")Long numero) {
		return serviceClient.rechercherClientParNumero(numero);
	}
	
	@PostConstruct
	public void initDataEnModeDev() {
		Client cli = new Client(null,"Therieur","alain","0102030405" ,"alain.therieur@ici_ou_la.fr");
		cli.setAdresse(new Adresse("12, rue elle " , "75002" , "Paris"));
		serviceClient.saveOrUpdateClient(cli);
	}

}
