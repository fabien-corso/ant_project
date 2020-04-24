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
	
	public PlayStop(Fourmiliere data, MainFrame frame) {
		super("play");
		
		this.data = data;
		this.frame = frame;
		
		this.loopSimulation = new Thread(this);
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (isPlay) {
			this.setText("play");
			this.loopSimulation.start();
		}
		else {
			this.setText("stop");
			this.loopSimulation.stop();
		}
		this.isPlay = !this.isPlay;
	}

	@Override
	public void run() {
		while (this.isPlay) {
			try {
				TimeUnit.SECONDS.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.data.evolue();
			this.frame.getTerrain().refresh();
		}
	}
	
}
