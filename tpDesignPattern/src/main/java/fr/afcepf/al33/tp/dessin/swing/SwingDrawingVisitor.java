package fr.afcepf.al33.tp.dessin.swing;

import java.awt.Color;
import java.awt.Graphics;

import fr.afcepf.al33.tp.dessin.AbstractFigVisitor;
import fr.afcepf.al33.tp.dessin.Line;

public class SwingDrawingVisitor implements AbstractFigVisitor {
	
	private Graphics g;
	
	public SwingDrawingVisitor(Graphics g) {
		this.g=g;
	}

	@Override
	public void doActionForLine(Line l) {
		g.setColor(Color.decode(l.getLineColor())); //"#ff0000"
		g.drawLine(l.getX1(), l.getY1(), l.getX2(), l.getY2());
	}

}
