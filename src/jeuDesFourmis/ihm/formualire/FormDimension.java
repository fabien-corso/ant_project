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
	
	/**
	 * constructeur du formualaire de changement de dimension du terrain.
	 * 
	 * @param data
	 * @param frame
	 */
	public FormDimension(Fourmiliere data, MainFrame frame) {
		super(data, frame, 3);
		
		this.hauteur = new JTextField("" + (this.getData().getHauteur() - 2));
		this.largueur = new JTextField("" + (this.getData().getLargeur() - 2));
		
		this.valide = new JButton("valide les longueurs");
		this.valide.addActionListener(this);
		
		this.add(this.hauteur);
		this.add(this.largueur);
		this.add(this.valide);
	}
	/**
	 * permet au Jbutton de lancer le traitement.
	 * ce traitement est de faire changer la dimension du terrain.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(this.OptionPanelConfirme("confimer les nouvelle dimension ?")) {
			int valeurLargeur = Integer.parseInt(this.largueur.getText()) - 2;
			int valeurHauteur = Integer.parseInt(this.hauteur.getText()) - 2;
			this.getData().setdimention(valeurLargeur, valeurHauteur);
			this.refreshTerrain();
		}
	}

}
