package jeuDesFourmis.ihm.formualire;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JTextField;

import jeuDesFourmis.ihm.MainFrame;
import jeuDesFourmis.model.terrain.Fourmiliere;

public class FormAleatoire extends Formulaire {
	
	private JTextField fourmi;
	private JTextField murs;
	private JTextField grain;
	private JButton aleatoire;

	
	public FormAleatoire(Fourmiliere data, MainFrame frame) {
		super(data, frame, 4);
		
		this.fourmi = new JTextField();
		this.murs = new JTextField();
		this.grain = new JTextField();
		
		this.aleatoire = new JButton("lancer l'al�atoire");
		this.aleatoire.addActionListener(this);
		
		this.add(this.fourmi);
		this.add(this.murs);
		this.add(this.grain);
		this.add(this.aleatoire);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.OptionPanelConfirme("confimer les parametre d'al�atoire ?")) {
			int probaFourmi = Integer.parseInt(this.fourmi.getText());
			int probaMurs = Integer.parseInt(this.murs.getText());
			int probagrain = Integer.parseInt(this.grain.getText());
			
			Fourmiliere data = this.getData();
			data.clear();
			
			// on commence a 1 car il y a des mur par d�faut
			for(int i = 1; i < data.getHauteur(); i++ ) {
				for(int j = 1; j < data.getHauteur(); j ++) {
					if(Math.random()*100 < probaMurs)
						data.setMur(i, j, true);
					if(Math.random()*100 < probaFourmi)
						data.ajouteFourmi(i, j);
					if(Math.random()*100 < probagrain)
						data.setQteGraines(i, j, (int)(Math.random()*4));
				}
			}
		}
	}

}