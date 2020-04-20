package jeuDesFourmis.ihm.formualire;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import jeuDesFourmis.model.terrain.Fourmiliere;

public class FormVide extends Formulaire{

	private JButton vide;
	
	public FormVide(Fourmiliere data) {
		super(data);
		this.vide = new JButton("vide");
		this.vide.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.getData().clear();
	}
	
}
