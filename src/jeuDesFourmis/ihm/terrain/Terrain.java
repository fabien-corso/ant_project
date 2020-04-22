package jeuDesFourmis.ihm.terrain;

import jeuDesFourmis.model.terrain.Fourmiliere;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Terrain extends JLayeredPane implements MouseListener, MouseWheelListener {

	private Fourmiliere data;
	private StaticLayer staticLayer;
	private DynamicLayer dynamicLayer;

	/**
	 * Construit les différents layer du terrain et les agence de la bonne façon.
	 * Le layer dynamique est AU DESSUS du layer statique, il faut donc rendre son
	 * background transparent pour voir les 2.
	 * @param data
	 */
	public Terrain(Fourmiliere data) {
		super();
		this.setPreferredSize(new Dimension(data.getLargeur() * 5,
				data.getHauteur() * 5));
		this.setBounds(0,0,data.getLargeur() * 5,
				data.getHauteur() * 5);
		this.data = data;
		this.staticLayer = new StaticLayer(data);
		this.dynamicLayer = new DynamicLayer(data);

		this.staticLayer.setOpaque(false);
		this.dynamicLayer.setOpaque(false);
		this.setOpaque(false);

		this.add(this.dynamicLayer, Integer.valueOf(-1));
		this.add(this.staticLayer, Integer.valueOf(0));
		this.addMouseListener(this);
	}

	/**
	 * Retourne le panel du terrain avec les layers correctements agencés.
	 * @return
	 */
	public Layer getTerrainPanel() {
		return this.dynamicLayer;
	}

	@Override
	public void mouseClicked(MouseEvent mouseEvent) {
		//this.dispatchEvent(mouseEvent);
	}

	@Override
	public void mousePressed(MouseEvent mouseEvent) {
		if(!mouseEvent.isShiftDown()) {
			this.staticLayer.addMurs(mouseEvent);
		}
		else {
			this.dynamicLayer.addFourmi(mouseEvent);
		}
	}

	@Override
	public void mouseReleased(MouseEvent mouseEvent) {

	}

	@Override
	public void mouseEntered(MouseEvent mouseEvent) {

	}

	@Override
	public void mouseExited(MouseEvent mouseEvent) {

	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		
	}
}
