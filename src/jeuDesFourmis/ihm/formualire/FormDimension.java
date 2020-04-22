package jeuDesFourmis.ihm.formualire;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import jeuDesFourmis.ihm.MainFrame;
import jeuDesFourmis.model.terrain.Fourmiliere;

public class FormDimension extends Formulaire {

	//attribue
	private JTextField hauteur;
	private JTextField largueur;
	private JButton valide;
	
	public FormDimension(Fourmiliere data, MainFrame frame) {
		super(data, frame, 3);
		
		this.hauteur = new JTextField("" + this.getData().getHauteur());
		this.largueur = new JTextField("" + this.getData().getLargeur());
		
		this.valide = new JButton("valide les longueurs");
		this.valide.addActionListener(this);
		
		this.add(this.hauteur);
		this.add(this.largueur);
		this.add(this.valide);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(this.OptionPanelConfirme("confimer les nouvelle dimension ?")) {
			int valeurLargeur = Integer.parseInt(this.largueur.getText());
			int valeurHauteur = Integer.parseInt(this.hauteur.getText());
			this.getData().setdimention(valeurLargeur, valeurHauteur);
			System.out.println(this.getData().getHauteur() + " : " + this.getData().getLargeur());
		}
	}

}
