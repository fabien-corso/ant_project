package jeuDesFourmis.ihm.terrain;

import jeuDesFourmis.ihm.frames.LoupeFrame;
import jeuDesFourmis.ihm.frames.MainFrame;
import jeuDesFourmis.model.terrain.Fourmiliere;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Terrain extends JLayeredPane implements MouseListener, MouseWheelListener {

	public static final int DEFAULT_CASE_DIMENSION = 5;
	public final int CASE_DIMENSION;
	private MainFrame mainFrame;
	private Fourmiliere data;
	private StaticLayer staticLayer;
	private DynamicLayer dynamicLayer;

	/**
	 * Construit les différents layer du terrain et les agence de la bonne façon.
	 * Le layer dynamique est AU DESSUS du layer statique, il faut donc rendre son
	 * background transparent pour voir les 2.
	 * @param data
	 */
	public Terrain (MainFrame mainFrame, Fourmiliere data, int caseDimension, Point centralPoint, Dimension dim) {
		super();
		this.mainFrame = mainFrame;
		this.CASE_DIMENSION = caseDimension;
		this.data = data;

		//Attribue sa taille au panel et le place correctement
		this.setPreferredSize(new Dimension(dim.width * this.CASE_DIMENSION,dim.height * this.CASE_DIMENSION));

		this.staticLayer = new StaticLayer(data, this.CASE_DIMENSION, centralPoint, dim);
		this.dynamicLayer = new DynamicLayer(data, this.CASE_DIMENSION, centralPoint, dim);

		this.staticLayer.setOpaque(false);
		this.dynamicLayer.setOpaque(false);
		this.setOpaque(false);

		this.add(this.dynamicLayer, Integer.valueOf(-1));
		this.add(this.staticLayer, Integer.valueOf(0));
		this.addMouseListener(this);
		this.addMouseWheelListener(this);
	}

	public Terrain(MainFrame mainFrame, Fourmiliere data, int caseDimension) {
		this(mainFrame, data, caseDimension, new Point(0, 0), new Dimension(data.getLargeur(), data.getHauteur()));
	}

	public Terrain(MainFrame mf, Fourmiliere data) {
		this(mf, data, Terrain.DEFAULT_CASE_DIMENSION);
	}

	/**
	 * Redéssine le layer dynamique (fourmis + graines)
	 */
	public void refresh () {
		this.dynamicLayer.repaint();
	}

	/**
	 * Redéssine tout le terrain
	 */
	public void refreshAll() {
		this.staticLayer.setGridDrawable(!this.mainFrame.getPlayed());
		this.staticLayer.repaint();
		this.refresh();
	}

	/**
	 *
	 */
	public void refreshDimensions() {
		this.setSize(new Dimension(this.data.getLargeur() * this.CASE_DIMENSION,
				this.data.getHauteur() * this.CASE_DIMENSION));
		Dimension dimension = new Dimension(this.data.getLargeur(), this.data.getHauteur());
		this.staticLayer.setDimension(dimension);
		this.dynamicLayer.setDimension(dimension);
		this.repaint();
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
	}

	@Override
	public void mousePressed(MouseEvent mouseEvent) {
		if(this.mainFrame.isLoupeMode() == false) {
			if(this.mainFrame.getPlayed() == false) {
				if(!mouseEvent.isShiftDown()) {
					this.staticLayer.addWall(mouseEvent);
				}
				else {
					this.dynamicLayer.addAnt(mouseEvent);
				}
			}
		}
		else {
			this.mainFrame.setLoupeMode(false);
			int x = (mouseEvent.getX() / this.CASE_DIMENSION);
			int y = (mouseEvent.getY() / this.CASE_DIMENSION);
			LoupeFrame lpFrame = new LoupeFrame(this.mainFrame, new Point(x, y));
			this.mainFrame.addFrame(lpFrame);
			lpFrame.setVisible(true);
			this.mainFrame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
	public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
		this.dynamicLayer.addSeeds(mouseWheelEvent);
	}
}
