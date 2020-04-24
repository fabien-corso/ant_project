package jeuDesFourmis.ihm.utils;

import java.awt.*;

public class Area {

    private Point centralPoint;
    private Dimension dimensionArea;

    public Area(Point centerPoint, Dimension dimensionArea) {
        this.centralPoint = centerPoint;
        this.dimensionArea = dimensionArea;
    }

    public Area(int xCentralP, int yCentralP, int width, int height) {
        this.centralPoint = new Point(xCentralP, yCentralP);
        this.dimensionArea = new Dimension(width, height);
    }

    public Point getCentralPoint() {
        return centralPoint;
    }

    public void setCentralPoint(Point centralPoint) {
        this.centralPoint = centralPoint;
    }

    public Dimension getDimensionArea() {
        return dimensionArea;
    }

    public void setDimensionArea(Dimension dimensionArea) {
        this.dimensionArea = dimensionArea;
    }

    /**
     * Renvoie le point le plus en haut à gauche de la zone.
     * On trouve ce point en prenant les coordonnées du point - le nbDeCases
     * @return
     */
    public Point getFirstPoint() {
        int xFirst = this.centralPoint.x - (this.dimensionArea.width/2);
        int yFirst = this.centralPoint.y - (this.dimensionArea.height/2);
        xFirst = xFirst < 0 ? 0 : xFirst;
        yFirst = yFirst < 0 ? 0 : yFirst;

        return new Point(xFirst, yFirst);
    }

    public Point getLastPoint() {
        int xFirst = this.centralPoint.x + (this.dimensionArea.width/2);
        int yFirst = this.centralPoint.y + (this.dimensionArea.height/2);

        return new Point(xFirst, yFirst);
    }

    public boolean containsPoint(int x, int y) {
        Point p = this.getFirstPoint();
        Point p2 = this.getLastPoint();
        return (x >= this.getFirstPoint().x) &&
               (y >= this.getFirstPoint().y) &&
               (x <= this.getLastPoint().x) &&
               (y <= this.getLastPoint().y);
    }
}
