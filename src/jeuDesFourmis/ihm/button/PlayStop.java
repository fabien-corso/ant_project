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

public class PlayStop extends JButton implements ActionListener, Runnable {
	
	private boolean isPlay;
	private Fourmiliere data;
	private MainFrame frame;
	
	private Thread loopSimulation;
	
	public PlayStop(Fourmiliere data, MainFrame mainFrame) {
		super("play");
		
		this.isPlay = false;
		
		this.data = data;
		this.frame = mainFrame;
		
		this.loopSimulation = new Thread(this);
		this.loopSimulation.start();
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!isPlay) {
			this.setText("stop");
			this.frame.setVisibilityFormulaire(false);
		}
		else {
			this.setText("play");
			this.frame.setVisibilityFormulaire(true);
		}
		this.isPlay = !this.isPlay;
	}

	@Override
	public void run() {
		while (true) {
			try {
				TimeUnit.SECONDS.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.isPlay);
			if(this.isPlay) {
				this.data.evolue();
				System.out.println("evolution");
			}
			this.frame.getTerrain().refresh();
		}
	}
	
}
