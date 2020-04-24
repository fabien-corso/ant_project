package jeuDesFourmis.ihm.frames;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import jeuDesFourmis.ihm.button.PlayStop;
import jeuDesFourmis.ihm.button.Loupe;
import jeuDesFourmis.ihm.formualire.FormAleatoire;
import jeuDesFourmis.ihm.formualire.FormDimension;
import jeuDesFourmis.ihm.formualire.FormVide;
import jeuDesFourmis.ihm.terrain.Terrain;
import jeuDesFourmis.model.terrain.Fourmiliere;

public class MainFrame extends AntSimulationFrame {
	
	private Fourmiliere data;
	private Box formulaire;
	private PlayStop playStop;
	
	private boolean isPlayed;
	private List<AntSimulationFrame> allFrames;

	public MainFrame() {
		super("Ant simulation");
		this.data = new Fourmiliere(100, 100);
		this.allFrames = new ArrayList<>();
		this.setTerrain(new Terrain(this.data));
		this.formulaire = Box.createVerticalBox();
		
		this.isPlayed = false;
		this.formulaire.add(new FormDimension(data, this));
		this.formulaire.add(new FormVide(data, this));
		this.formulaire.add(new FormAleatoire(data, this));
		this.formulaire.add(new Loupe(this));
		this.formulaire.add(Box.createVerticalGlue());
		
		this.playStop = new PlayStop(data, this);

		this.add(this.getTerrain(), BorderLayout.CENTER);
		this.add(this.formulaire, BorderLayout.WEST);
		this.add(this.playStop, BorderLayout.SOUTH);

		this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE) ;
		this.pack();
		this.setVisible(true);
	}

	public Fourmiliere getData() {
		return data;
	}

	public void setVisibilityFormulaire(boolean b) {
		this.formulaire.setVisible(b);
		
	}

	public void addFrame(AntSimulationFrame frame) {
		this.allFrames.add(frame);
	}

	public void removeFrame(AntSimulationFrame frame) {
		this.allFrames.remove(frame);
	}
	public boolean getPlayed() {
		return this.isPlayed;
	}
	
	public void setPlayed(boolean played) {
		this.isPlayed = played;
	}

	@Override
	public void refresh() {
		this.getTerrain().refresh();
		for(AntSimulationFrame frame : this.allFrames) {
			SwingUtilities.invokeLater( () -> frame.refresh());
		}
	}
}
