package fr.afcepf.al33.tp.dessin;

public class Circle extends Fig2D {
	
	private int xC,yC,rayon;
	
	
	
	public Circle(int xC, int yC, int rayon) {
		super();
		this.xC = xC;
		this.yC = yC;
		this.rayon = rayon;
	}

	public int getxC() {
		return xC;
	}

	public void setxC(int xC) {
		this.xC = xC;
	}

	public int getyC() {
		return yC;
	}

	public void setyC(int yC) {
		this.yC = yC;
	}

	public int getRayon() {
		return rayon;
	}

	public void setRayon(int rayon) {
		this.rayon = rayon;
	}

	@Override
	public void performVisit(AbstractFigVisitor v) {
		v.doActionForCircle(this);
	}
	
	

}
