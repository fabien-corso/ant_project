package jeuDesFourmis.ihm.button;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import javax.swing.Icon;
import javax.swing.JButton;

import jeuDesFourmis.ihm.frames.MainFrame;
import jeuDesFourmis.model.terrain.Fourmiliere;

public class PlayStop extends JButton implements ActionListener {
	
	private MainFrame frame;
	
	private AntSimulationThread antSimulationThread;
	
	public PlayStop(Fourmiliere data, MainFrame mainFrame) {
		super("play");
		this.antSimulationThread = new AntSimulationThread(data, mainFrame);
		this.frame = mainFrame;
		this.addActionListener(this);
		this.antSimulationThread.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!this.frame.getPlayed()) {
			this.setText("stop");
			this.frame.setVisibilityFormulaire(false);
			this.antSimulationThread.playSimulation();
		}
		else {
			this.setText("play");
			this.frame.setVisibilityFormulaire(true);
			this.antSimulationThread.stopSimulation();
		}
		this.frame.setPlayed(this.frame.getPlayed());
	}
	
}
