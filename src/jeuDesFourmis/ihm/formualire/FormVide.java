package jeuDesFourmis.ihm.formualire;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import jeuDesFourmis.ihm.frames.MainFrame;
import jeuDesFourmis.model.terrain.Fourmiliere;

public class FormVide extends Formulaire{

	private JButton vide;
	/**
	 * constructeur du formualaire qui vide le terrain.
	 *
	 * @param data
	 * @param mainFrame
	 */
	public FormVide(Fourmiliere data, MainFrame mainFrame) {
		super(data, mainFrame, 1);
		
		this.vide = new JButton("vide");
		this.vide.addActionListener(this);
		
		this.add(this.vide);	
	}
	/**
	 * permet au Jbutton de lancer le traitement.
	 * le traitement est de remmetre par d�fault le terrain (le vide)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.optionPanelConfirme("confimer la vidage")) {
			this.getData().clear();
			this.refreshTerrain();
		}
	}
}
