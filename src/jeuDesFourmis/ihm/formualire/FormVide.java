package jeuDesFourmis.ihm.formualire;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import jeuDesFourmis.ihm.MainFrame;
import jeuDesFourmis.model.terrain.Fourmiliere;

public class FormVide extends Formulaire{

	private JButton vide;
	
	public FormVide(Fourmiliere data, MainFrame frame) {
		super(data, frame, 1);
		
		this.vide = new JButton("vide");
		this.vide.addActionListener(this);
		
		this.add(this.vide);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.OptionPanelConfirme("confimer la vidage")) {
			this.getData().clear();
		}
	}
}
