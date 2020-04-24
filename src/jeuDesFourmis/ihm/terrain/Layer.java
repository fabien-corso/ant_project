package jeuDesFourmis.ihm.terrain;

import jeuDesFourmis.ihm.utils.Area;
import jeuDesFourmis.model.terrain.Fourmiliere;

import javax.swing.*;
import java.awt.*;

public abstract class Layer extends JPanel {

    private Fourmiliere data;
    private Area area;
    public final int DIMENSION_CASE;

    public Layer(Fourmiliere data, int dimensionCase, Point cPoint, Dimension nbOfCases) {
        super(new BorderLayout ());
        this.area = new Area(cPoint, nbOfCases);
        this.DIMENSION_CASE = dimensionCase;
        this.data = data;
        this.updatePanelSize();
    }

    public Layer(Fourmiliere data, int dimensionCase) {
        this(data, dimensionCase, new Point(0,0), new Dimension(data.getLargeur(), data.getHauteur()));
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

    public void updatePanelSize() {
        this.setPreferredSize(new Dimension(data.getLargeur() * this.DIMENSION_CASE,
                data.getHauteur() * this.DIMENSION_CASE));
        this.setBounds(0,0,data.getLargeur() * this.DIMENSION_CASE,
                data.getHauteur() * this.DIMENSION_CASE);
    }

    public Fourmiliere getData() {
        return data;
    }

    public void setData(Fourmiliere data) {
        this.data = data;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public void setDimension(Dimension d) {
        this.area.setDimensionArea(d);
        this.updatePanelSize();
    }
}
