package fr.afcepf.al33.tp.dessin.swing;

import java.awt.Color;
import java.awt.Graphics;

import fr.afcepf.al33.tp.dessin.AbstractFigVisitor;
import fr.afcepf.al33.tp.dessin.Circle;
import fr.afcepf.al33.tp.dessin.Line;
import fr.afcepf.al33.tp.dessin.Rectangle;

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

	@Override
	public void doActionForRectangle(Rectangle r) {
		g.setColor(Color.decode(r.getLineColor())); //"#ff0000"
		g.drawRect(r.getX1(),r.getY1(),r.getL(),r.getH());
	}
	
	@Override
	public void doActionForCircle(Circle c) {
		g.setColor(Color.decode(c.getLineColor())); //"#ff0000"
		int x = c.getxC() - c.getRayon();
		int y = c.getyC() - c.getRayon();
		int l = 2* c.getRayon();
		int h = l;
		g.drawOval(x,y,l,h);
	}

}
