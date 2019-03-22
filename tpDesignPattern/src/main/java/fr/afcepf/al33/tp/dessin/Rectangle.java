package fr.afcepf.al33.tp.dessin;

public class Rectangle extends Fig2D {
	
	private int x1,y1,l,h;
	
	

	public Rectangle(int x1, int y1, int l, int h) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.l = l;
		this.h = h;
	}
	
	

	

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	



	public int getL() {
		return l;
	}





	public void setL(int l) {
		this.l = l;
	}





	public int getH() {
		return h;
	}





	public void setH(int h) {
		this.h = h;
	}





	@Override
	public void performVisit(AbstractFigVisitor v) {
		v.doActionForRectangle(this);
	}
	
	

}
