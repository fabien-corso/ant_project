package jeuDesFourmis.ihm.formualire;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JTextField;

import jeuDesFourmis.model.terrain.Fourmiliere;

public class FormDimension extends Formulaire {

	//attribue
	private JTextField hauteur;
	private JTextField largueur;
	private JButton valide;
	
	public FormDimension(Fourmiliere data) {
		super(data);
		
		this.hauteur = new JTextField("" + this.getData().getHauteur());
		this.largueur = new JTextField("" + this.getData().getLargeur());
		this.valide = new JButton("valide les longueurs");
		this.valide.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int valeurLargeur = Integer.parseInt(this.largueur.getText());
		int valeurHauteur = Integer.parseInt(this.hauteur.getText());
		this.getData().setdimention(valeurLargeur, valeurHauteur);
	}

}
