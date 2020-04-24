package jeuDesFourmis.ihm.frames;

import java.awt.*;

import javax.swing.*;

import jeuDesFourmis.ihm.button.PlayStop;
import jeuDesFourmis.ihm.button.Loupe;
import jeuDesFourmis.ihm.formualire.FormAleatoire;
import jeuDesFourmis.ihm.formualire.FormDimension;
import jeuDesFourmis.ihm.formualire.FormVide;
import jeuDesFourmis.ihm.terrain.Terrain;
import jeuDesFourmis.model.terrain.Fourmiliere;

public class MainFrame extends JFrame {
	
	private Fourmiliere data;
	
	private Terrain terrain;
	private Box formulaire;
	private PlayStop playStop;


	public MainFrame() {
		this.data = new Fourmiliere(100, 100);
		this.terrain = new Terrain(this.data);
		this.formulaire = Box.createVerticalBox();
		
		this.formulaire.add(new FormDimension(data, this));
		this.formulaire.add(new FormVide(data, this));
		this.formulaire.add(new FormAleatoire(data, this));
		this.formulaire.add(new Loupe(this));
		this.formulaire.add(Box.createVerticalGlue());
		
		this.playStop = new PlayStop(data, this);

		this.add(this.terrain, BorderLayout.CENTER);
		this.add(this.formulaire, BorderLayout.WEST);
		this.add(this.playStop, BorderLayout.SOUTH);

		this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
		this.pack();
		this.setVisible(true);
	}
	
	public Terrain getTerrain() {
		return this.terrain;
	}

	public Fourmiliere getData() {
		return data;
	}

	public void setVisibilityFormulaire(boolean b) {
		this.formulaire.setVisible(b);
		
	}
}
