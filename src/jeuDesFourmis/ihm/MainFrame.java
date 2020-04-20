package jeuDesFourmis.ihm;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import jeuDesFourmis.model.terrain.Fourmiliere;

public class MainFrame extends JFrame {
	
	private final int DEFAULT_HAUTEUR = 100;
	private final int DEFAULT_LONGUEUR = 100;
	
	private Fourmiliere data;
	
	
	
	public MainFrame() {
		this.data = new Fourmiliere(DEFAULT_LONGUEUR, DEFAULT_HAUTEUR);
		
		this.pack();
		this.setVisible(true);
	}
	
}
