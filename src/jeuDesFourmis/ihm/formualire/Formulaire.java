package jeuDesFourmis.ihm.formualire;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jeuDesFourmis.model.terrain.Fourmiliere;

public abstract class Formulaire extends JPanel implements ActionListener {
	//data
	private Fourmiliere data;
	
	public Formulaire(Fourmiliere data) {
		this.data = data;
	}
	
	public Fourmiliere getData() {
		return this.data;
	}
	
}
