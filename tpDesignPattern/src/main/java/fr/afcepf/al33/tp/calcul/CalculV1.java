package fr.afcepf.al33.tp.calcul;

public class CalculV1 implements Calcul {

	@Override
	public double racineCarree(double x) {
		return Math.sqrt(x);
	}
	

	@Override
	public int factorielle(int n) {
		int res=1;
		for(int i=n;i>=1;i--)
			res=res*i;
		return res;
	}

}
