package fr.afcepf.al33.tp.data;

import fr.afcepf.al33.tp.annot.MadMax;

public class MyPojo {
	
	private String label;//+get/set
	
	@MadMax(value=100,comment="super")
	private long valeurQuiVaPeutEtreBien;//+get/set
	

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public long getValeurQuiVaPeutEtreBien() {
		return valeurQuiVaPeutEtreBien;
	}

	public void setValeurQuiVaPeutEtreBien(long valeurQuiVaPeutEtreBien) {
		this.valeurQuiVaPeutEtreBien = valeurQuiVaPeutEtreBien;
	}

	
	

	
}
