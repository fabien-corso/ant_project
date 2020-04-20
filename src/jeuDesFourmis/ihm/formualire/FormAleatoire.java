package jeuDesFourmis.ihm.formualire;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JTextField;

import jeuDesFourmis.model.terrain.Fourmiliere;

public class FormAleatoire extends Formulaire {
	
	private JTextField fourmi;
	private JTextField murs;
	private JTextField grain;
	private JButton aleatoire;

	
	public FormAleatoire(Fourmiliere data) {
		super(data);
		
		this.fourmi = new JTextField();
		this.murs = new JTextField();
		this.grain = new JTextField();
		
		this.aleatoire = new JButton("lancer l'aléatoire");
		this.aleatoire.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO
	}

}
