package jeuDesFourmis.ihm.terrain;

import jeuDesFourmis.model.terrain.Fourmiliere;

import javax.swing.*;
import java.awt.*;

public abstract class Layer extends JPanel {

    private Fourmiliere data;
    public final int DIMENSION_CASE;
    public static final int DEFAULT_CASE_DIMENSION = 5;

    public Layer(Fourmiliere data) {
        super(new BorderLayout ());
        this.DIMENSION_CASE = Layer.DEFAULT_CASE_DIMENSION;
        this.setPreferredSize(new Dimension(data.getLargeur() * DIMENSION_CASE,
                data.getHauteur() * DIMENSION_CASE));
        this.data = data;
    }

    /**
     * Dessine les éléments dur le Graphics2D
     * @param graphics
     */
    protected abstract void makeDrawing(Graphics2D graphics);

    /**
     * Peind notre layerà partir de la méthode makeDrawing
     * @param graphics
     */
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D g2DCopie = (Graphics2D) graphics.create () ;
        this.makeDrawing (g2DCopie) ;
        g2DCopie.dispose () ;
    }

    public Fourmiliere getData() {
        return data;
    }

    public void setData(Fourmiliere data) {
        this.data = data;
    }

}
