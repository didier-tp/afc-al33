package fr.afcepf.al33.dao;

import fr.afcepf.al33.entity.Devise;

public interface DeviseDao {
	public Devise getDeviseByCode(String code);
	//...
}
