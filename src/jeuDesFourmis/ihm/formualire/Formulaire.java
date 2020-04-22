package jeuDesFourmis.ihm.formualire;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jeuDesFourmis.ihm.MainFrame;
import jeuDesFourmis.model.terrain.Fourmiliere;

public abstract class Formulaire extends JPanel implements ActionListener {
	//data
	private Fourmiliere data;
	//frame
	private MainFrame main;
	
	public Formulaire(Fourmiliere data, MainFrame frame, int row) {
		super(new GridLayout(row, 1, 0, 10));
		this.data = data;
		
	}
	
	public Fourmiliere getData() {
		return this.data;
	}
	
	public boolean OptionPanelConfirme(String message) {
		return JOptionPane.showConfirmDialog(main, message, "confirmation ?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
	}
}
