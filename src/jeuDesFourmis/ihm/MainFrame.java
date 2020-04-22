package jeuDesFourmis.ihm;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JFrame;

import jeuDesFourmis.ihm.formualire.FormAleatoire;
import jeuDesFourmis.ihm.formualire.FormDimension;
import jeuDesFourmis.ihm.formualire.FormVide;
import jeuDesFourmis.ihm.terrain.Terrain;
import jeuDesFourmis.model.terrain.Fourmiliere;

public class MainFrame extends JFrame {
	
	private Fourmiliere data;
	
	private Terrain terrain;
	private Box formulaire;
	
	public MainFrame() {
		this.data = new Fourmiliere(100, 100);
		
		this.terrain = new Terrain(this.data);
		
		this.formulaire = Box.createVerticalBox();
		
		this.formulaire.add(new FormDimension(data, this));
		this.formulaire.add(new FormVide(data, this));
		this.formulaire.add(new FormAleatoire(data, this));
		this.formulaire.add(Box.createVerticalGlue());
		
		this.add(this.terrain, BorderLayout.CENTER);
		this.add(this.formulaire, BorderLayout.WEST);
		
		this.pack();
		this.setVisible(true);
	}
	
	public Terrain getTerrain() {
		return this.terrain;
	}
	
}
