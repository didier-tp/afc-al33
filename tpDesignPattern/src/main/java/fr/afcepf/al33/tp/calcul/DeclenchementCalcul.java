package fr.afcepf.al33.tp.calcul;

import java.util.Scanner;

import javax.swing.JOptionPane;

/*
 * cette classe va :
 *    - permettre de saisir la valeur de x (au clavier , à la console)
 *    - calculer le calcul de la racine carrée (ou autre calcul)
 *    - afficher le résultat
 */

public class DeclenchementCalcul {
	
	//Calcul calcul = new CalculV1(); 
	Calcul calcul = new CalculV2(); 

	public void saisieCalculAffichage() {
		
		double x=0;
		//Scanner sc = new Scanner(System.in);
		//System.out.println("x:");
		//x=sc.nextDouble();
		x= Double.parseDouble( JOptionPane.showInputDialog(null,"x:") );
		
		//double racineX = Math.sqrt(x);
		//double racineX = Math.pow(x,0.5);
		double racineX = calcul.racineCarree(x);
		int n = (int) x;
		int fact = calcul.factorielle(n);
		
		System.out.println("racineX="+racineX);
		//JOptionPane.showMessageDialog(null, "racineX="+racineX);
		System.out.println("n="+n);
		System.out.println("factorielle="+fact);
	}
	
}
