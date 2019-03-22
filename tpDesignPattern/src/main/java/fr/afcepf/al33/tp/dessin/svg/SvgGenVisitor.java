package fr.afcepf.al33.tp.dessin.svg;

import fr.afcepf.al33.tp.dessin.AbstractFigVisitor;
import fr.afcepf.al33.tp.dessin.Circle;
import fr.afcepf.al33.tp.dessin.Line;
import fr.afcepf.al33.tp.dessin.Rectangle;

public class SvgGenVisitor implements AbstractFigVisitor {
	
	private String svgHeader =
		     "<svg width='500' height='400' "
		     +" xmlns='http://www.w3.org/2000/svg'>";
	
	private StringBuffer svgContent = new StringBuffer(svgHeader);
	
	public SvgGenVisitor() {
		
	}
	
	public String getAllSvgFileContent(){
	    svgContent.append("</svg>");
	    return svgContent.toString();
	}

	@Override
	public void doActionForLine(Line l) {
		svgContent.append(" <line x1='"+l.getX1()
                +"' y1='"+l.getY1()
                +"' x2='"+l.getX2()
                +"' y2='"+l.getY2()+
                "' style='stroke:"+l.getLineColor()+ "'/>");
	}

	@Override
	public void doActionForRectangle(Rectangle r) {
		svgContent.append(" <rect x='"+r.getX1()+"' y='"+r.getY1()+
                "' width='"+r.getH()+
                "' height='"+r.getH()+
                "' stroke='"+r.getLineColor()+"' fill='none' />");
	}
	
	@Override
	public void doActionForCircle(Circle c) {
		svgContent.append(" <circle cx='"+c.getxC()+"' cy='"+c.getyC()
                +"' r='"+c.getRayon()+"' stroke='"+c.getLineColor()+"' "
                +  "stroke-width='1' fill='none' />");
		
	}

}
