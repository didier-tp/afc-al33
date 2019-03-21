package fr.afcepf.al33.tp.dessin;

import java.awt.Graphics;

import javax.swing.JFrame;

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
		Line l1 = new Line(50,50, 150,100);
		l1.dessiner(this.getContentPane().getGraphics());
	}
	
	

}
