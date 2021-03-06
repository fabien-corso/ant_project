package jeuDesFourmis.ihm.formualire;

import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import jeuDesFourmis.ihm.frames.MainFrame;
import jeuDesFourmis.model.terrain.Fourmiliere;

public class FormAleatoire extends Formulaire {
	
	private JTextField fourmi;
	private JTextField murs;
	private JTextField grain;
	
	private JButton aleatoire;

	/**
	 * constructeur du formualaire qui modifie le terrain aléatoirement.
	 * 
	 * @param data
	 * @param frame
	 */
	public FormAleatoire(Fourmiliere data, MainFrame frame) {
		super(data, frame, 4);
		
		this.fourmi = new JTextField("100");
		this.murs = new JTextField("100");
		this.grain = new JTextField("100");
		
		Box bFourmi = Box.createVerticalBox();
		bFourmi.add(new JLabel("probabilité des fourmis"));
		bFourmi.add(this.fourmi);
		
		Box bMurs = Box.createVerticalBox();
		bMurs.add(new JLabel("probabilité des murs"));
		bMurs.add(this.murs);
		
		Box bGrain = Box.createVerticalBox();
		bGrain.add(new JLabel("probablitit des graines"));
		bGrain.add(this.grain);
		
		this.aleatoire = new JButton("lancer l'aléatoire");
		this.aleatoire.addActionListener(this);
		
		this.add(bFourmi);
		this.add(bMurs);
		this.add(bGrain);
		this.add(this.aleatoire);
	}

	/**
	 * permet au Jbutton de lancer le traitement.
	 * le traitement est la modification du terrain pour une génération aléatoire.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.optionPanelConfirme("confimer les parametre d'aléatoire ?")) {
			try {
				int probaFourmi = Integer.parseInt(this.fourmi.getText());
				int probaMurs = Integer.parseInt(this.murs.getText());
				int probaGraine = Integer.parseInt(this.grain.getText());
				makeRand(probaMurs, probaFourmi, probaGraine);
				this.refreshTerrain();
			} catch (Exception e2) {
				this.optionPanelAlert("l'une des probabilité n'est pas correcte");
			}
		}
	}
	/**
	 * faire les modification du terrain aléatoirment avec les probabilité donnés
	 * @param probaMurs
	 * @param probaFourmi
	 * @param probaGraine
	 */
	public void makeRand(int probaMurs, int probaFourmi, int probaGraine) {
		Fourmiliere data = this.getData();
		data.clear();
		for(int i = 1; i < data.getHauteur() - 1; i++ ) {
			for(int j = 1; j < data.getHauteur() - 1; j ++) {
				if(Math.random()*100 < probaMurs)
					data.setMur(i, j, true);
				if(Math.random()*100 < probaFourmi)
					data.ajouteFourmi(i, j);
				if(Math.random()*100 < probaGraine && !data.getMur(i, j))
					data.setQteGraines(i, j, (int)(Math.random()*4));
			}
		}
	}

}