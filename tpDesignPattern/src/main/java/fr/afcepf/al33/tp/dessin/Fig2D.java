package fr.afcepf.al33.tp.dessin;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Fig2D {
	protected String lineColor="black";
	
	public String getLineColor() {
		return lineColor;
	}

	public void setLineColor(String lineColor) {
		this.lineColor = lineColor;
	}
	
	public abstract void performVisit(AbstractFigVisitor v);
	
   /*
    //Ancien code pas réutilisable (car spécifique à awt/swing)
	public void dessinerAvecCouleur(Graphics g) {
		g.setColor(Color.decode(this.lineColor));
		this.dessiner(g);
	}
	
	public abstract void dessiner(Graphics g);
	*/
}
