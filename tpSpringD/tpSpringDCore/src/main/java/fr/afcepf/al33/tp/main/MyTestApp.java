package fr.afcepf.al33.tp.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.afcepf.al33.tp.entity.Client;
import fr.afcepf.al33.tp.service.ServiceClient;

public class MyTestApp {

	public static void main(String[] args) {
		ApplicationContext contextSpring =
				 new ClassPathXmlApplicationContext("springConf.xml");
        //ServiceClient s = (ServiceClient) contextSpring.getBean("serviceClientImpl" /*id*/);
		ServiceClient s =  contextSpring.getBean(ServiceClient.class);
        Client c1=new Client();c1.setNom("toto");
        s.sauvegarderClient(c1);
        Client c1Relu = s.rechercherClientParNum(c1.getNumero());
        System.out.println("c1Relu=" + c1Relu);
	}

}
