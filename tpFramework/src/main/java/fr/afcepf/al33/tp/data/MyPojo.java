package fr.afcepf.al33.tp.data;

import fr.afcepf.al33.tp.annot.MadMax;

public class MyPojo {
	
	private String label;//+get/set
	
	@MadMax(100)
	private int value;//+get/set
	

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	
}
