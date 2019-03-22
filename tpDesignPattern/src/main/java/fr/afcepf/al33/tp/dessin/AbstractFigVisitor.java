package fr.afcepf.al33.tp.dessin;

public interface AbstractFigVisitor {
	void doActionForLine(Line l);
	void doActionForRectangle(Rectangle r);
	void doActionForCircle(Circle c);
}
