package fr.afcepf.al33.tp.calcul;

public class CalculV2 implements Calcul {

	@Override
	public double racineCarree(double x) {
		return Math.pow(x,0.5);
	}

	@Override
	public int factorielle(int n) {
		if(n==1)
			return 1;
		else 
			return n * factorielle(n-1);
	}

}
