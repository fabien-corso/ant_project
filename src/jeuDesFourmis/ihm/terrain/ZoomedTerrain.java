package jeuDesFourmis.ihm.terrain;

import jeuDesFourmis.ihm.frames.MainFrame;
import jeuDesFourmis.model.terrain.Fourmiliere;

import java.awt.*;

public class ZoomedTerrain extends Terrain{

    public static final int DEFAULT_ZOOMED_CASE_DIMENSION = 30;
    public ZoomedTerrain(MainFrame mf, Fourmiliere data, Point centralPoint, Dimension dim) {
        super(mf, data, ZoomedTerrain.DEFAULT_ZOOMED_CASE_DIMENSION, centralPoint, dim);
    }
}
