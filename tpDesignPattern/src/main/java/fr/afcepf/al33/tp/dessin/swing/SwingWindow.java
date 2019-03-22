package fr.afcepf.al33.tp.dessin.swing;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import fr.afcepf.al33.tp.dessin.Fig2D;
import fr.afcepf.al33.tp.dessin.Line;

public class SwingWindow  extends JFrame{
	
	public static void main(String[] args) {
		new SwingWindow();
	}
	
	public SwingWindow() {
			this.setTitle("application de dessin");
			this.setBounds(50,50,600,400);
			this.setVisible(true);
			//pour que le programme s'arr�te bien
			//lorque l'on ferme la fenetre principale:
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			//this.getContentPane()...
			
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		List<Fig2D> listFig = new ArrayList<Fig2D>();
		
		Line l1 = new Line(50,50, 150,100);	l1.setLineColor("#ff0000");
		listFig.add(l1);
		
		Line l2 = new Line(80,80, 30,80);	l2.setLineColor("#00aa00");
		listFig.add(l2); 
		
		SwingDrawingVisitor swingVisitor = 
				new SwingDrawingVisitor(this.getContentPane().getGraphics());
		
		for(Fig2D f : listFig) {
			f.performVisit(swingVisitor);//c'est le visiteur qui va récupérer les coordonnées 
			                            //et dessiner la figure (Line ou Circle ou Rectange).
		}
		
		/*
		l1.dessinerAvecCouleur();
		*/
		
	}
	
	

}
