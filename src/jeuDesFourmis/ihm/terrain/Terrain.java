package jeuDesFourmis.ihm.terrain;

import jeuDesFourmis.model.terrain.Fourmiliere;

public class Terrain {

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
		this.data = data;
		this.staticLayer = new StaticLayer(data);
		this.dynamicLayer = new DynamicLayer(data);

		this.dynamicLayer.setOpaque(false);
		this.staticLayer.add(this.dynamicLayer);
	}

	/**
	 * Retourne le panel du terrain avec les layers correctements agencés.
	 * @return
	 */
	public Layer getTerrainPanel() {
		return this.staticLayer;
	}
}
