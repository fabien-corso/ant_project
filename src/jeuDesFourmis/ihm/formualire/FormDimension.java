
package jeuDesFourmis.ihm.formualire;

import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import jeuDesFourmis.ihm.frames.MainFrame;
import jeuDesFourmis.ihm.terrain.Terrain;
import jeuDesFourmis.model.terrain.Fourmiliere;

public class FormDimension extends Formulaire {

	//attribue
	private JTextField hauteur;
	private JTextField largeur;
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
		this.largeur = new JTextField("" + (this.getData().getLargeur() - 2));
		
		Box bHauteur = Box.createHorizontalBox();
		bHauteur.add(new JLabel("hauteur"));
		bHauteur.add(this.hauteur);
		
		Box bLargeur = Box.createHorizontalBox();
		bLargeur.add(new JLabel("largeur"));
		bLargeur.add(this.largeur);
		
		this.valide = new JButton("valide les longueurs");
		this.valide.addActionListener(this);
		
		this.add(bHauteur);
		this.add(bLargeur);
		this.add(this.valide);
	}
	/**
	 * permet au Jbutton de lancer le traitement.
	 * ce traitement est de faire changer la dimension du terrain.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(this.optionPanelConfirme("confimer les nouvelle dimension ?")) {
			try {
				int valeurLargeur = Integer.parseInt(this.largeur.getText());
				int valeurHauteur = Integer.parseInt(this.hauteur.getText());
				this.getData().setDimensions(valeurLargeur, valeurHauteur);
				this.getMain().getTerrain().refreshDimensions();				
			} catch (Exception e) {
				this.optionPanelAlert("l'une des dimension n'est pas correcte");
			}

		}
	}

}