package jeuDesFourmis.ihm.terrain;

import jeuDesFourmis.model.terrain.Fourmiliere;

import java.awt.*;

public class ZoomedTerrain extends Terrain{

    public static final int DEFAULT_ZOOMED_CASE_DIMENSION = 30;
    public ZoomedTerrain(Fourmiliere data, Point centralPoint, Dimension dim) {
        super(data, ZoomedTerrain.DEFAULT_ZOOMED_CASE_DIMENSION, centralPoint, dim);
    }
}
