package fr.afcepf.al33.tp.dessin.svg;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import fr.afcepf.al33.tp.dessin.Circle;
import fr.afcepf.al33.tp.dessin.Fig2D;
import fr.afcepf.al33.tp.dessin.Line;
import fr.afcepf.al33.tp.dessin.Rectangle;

public class GenererFichierSvg {

	public static void main(String[] args) {
List<Fig2D> listFig = new ArrayList<Fig2D>();
		
		Line l1 = new Line(50,50, 150,100);	l1.setLineColor("#ff0000");
		listFig.add(l1);
		
		Rectangle r1 = new Rectangle(100,100, 100,100);	r1.setLineColor("#0000aa");
		listFig.add(r1); 
		
		Line l2 = new Line(80,80, 30,80);	l2.setLineColor("#00aa00");
		listFig.add(l2); 
		
		Circle c1 = new Circle(150,150,50);	c1.setLineColor("#aa00aa");
		listFig.add(c1); 
		
		SvgGenVisitor svgGenVisitor = new SvgGenVisitor();
		
		for(Fig2D f : listFig) {
			f.performVisit(svgGenVisitor);//c'est le visiteur qui va récupérer les coordonnées 
			                             //et dessiner la figure (Line ou Circle ou Rectange).
		}
		String svgAsString = svgGenVisitor.getAllSvgFileContent();
        System.out.println(svgAsString);
        try {
        	PrintWriter out = new PrintWriter("figures.svg");
			out.println(svgAsString);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
