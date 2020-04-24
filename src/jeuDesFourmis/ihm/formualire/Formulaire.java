package jeuDesFourmis.ihm.formualire;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import jeuDesFourmis.ihm.frames.MainFrame;
import jeuDesFourmis.model.terrain.Fourmiliere;

public abstract class Formulaire extends JPanel implements ActionListener {
	//data
	private Fourmiliere data;
	//frame
	private MainFrame main;
	
	/**
	 * 
	 * constructeur des formulaire g�n�rale.
	 * on a besoin de savoir combient de ligne il y a dans ce formulaire pour le gridLayout
	 * 
	 * @param data
	 * @param mainFrame
	 * @param row
	 */
	public Formulaire(Fourmiliere data, MainFrame mainFrame, int row) {
		super(new GridLayout(row, 1, 0, 10));
		this.data = data;
		this.main = mainFrame;
	}
	/**
	 * getter de data
	 * @return data
	 */
	public Fourmiliere getData() {
		return this.data;
	}

	public MainFrame getMain() {
		return main;
	}

	public void refreshTerrain() {
		this.main.getTerrain().refreshAll();
		this.main.getTerrain().refreshDimensions();
	}
	
	/**
	 * affichage d'une fenetre de confirmation et retourne le r�sultat de cette f�n�tre
	 * @param message
	 * @return validation
	 */
	public boolean optionPanelConfirme(String message) {
		return JOptionPane.showConfirmDialog(main, message, "confirmation ?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
	}
	/**
	 * affichage d'une fenetre d'information pour alert� qu'un probl�me
	 * @param message
	 */
	public void optionPanelAlert(String message) {
		JOptionPane.showMessageDialog(main, message, "alerte !", JOptionPane.WARNING_MESSAGE);
	}
}
