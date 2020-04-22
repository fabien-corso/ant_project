package jeuDesFourmis.ihm.button;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import javax.swing.Icon;
import javax.swing.JButton;

import jeuDesFourmis.model.terrain.Fourmiliere;

public class PlayStop extends JButton implements ActionListener, Runnable {
	
	private boolean isPlay;
	private Fourmiliere data;
	
	private Thread loopSimulation;
	
	public PlayStop(Fourmiliere data) {
		super("play");
		this.loopSimulation = new Thread(this);
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (isPlay)
			this.setText("play");
		else
			this.setText("stop");
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
		}
	}
	
}
