package fr.afcepf.al33.tp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al33.tp.dao.DaoActeur;
import fr.afcepf.al33.tp.entity.Acteur;

@Service
@Transactional
public class ServiceActeurImpl implements ServiceActeur {

	@Autowired
	private DaoActeur daoActeur;

	@Override
	public void sauvegarderActeur(Acteur acteur) {
		daoActeur.save(acteur);
	}

}
