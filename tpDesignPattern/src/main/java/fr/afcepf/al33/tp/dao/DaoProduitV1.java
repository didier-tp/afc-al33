package fr.afcepf.al33.tp.dao;

import java.util.ArrayList;
import java.util.List;

public class DaoProduitV1 implements DaoProduit {

	@Override
	public List<String> findProducts() {
		// simuler un select en base
		List<String> listProd = new ArrayList<>();
		listProd.add("computer");
		listProd.add("smartPhone");
		listProd.add("book");
		return listProd;
	}

}
