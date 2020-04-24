package jeuDesFourmis.ihm.terrain;

import jeuDesFourmis.model.terrain.Fourmiliere;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class StaticLayer extends Layer {

    public StaticLayer(Fourmiliere data, int dimensionCase, Point cPoint, Dimension nbOfCases) {
        super(data, dimensionCase, cPoint, nbOfCases);
    }

    public StaticLayer(Fourmiliere data, int dimensionCase) {
        super(data, dimensionCase);
    }

    /**
     * Déssine les éléments statiques de notre layer, pour nous les murs
     * qui sont des carrés noirs.
     * @param graphics
     */
    @Override
    protected void makeDrawing(Graphics2D graphics) {
        graphics.setColor(Color.BLACK);
        this.drawWalls(graphics);
        /*
        Tracer la grille
        int rows = this.getWidth()/this.DIMENSION_CASE;
        int columns = this.getHeight()/this.DIMENSION_CASE;
        System.out.println("Lignes: " + rows);
        System.out.println("Colonnes: " + columns);
        for (int i = 0; i < rows; i++) {
            graphics.drawLine(0, i * this.DIMENSION_CASE,
                                this.getWidth(), i * this.DIMENSION_CASE);
        }

        for (int i = 0; i < columns; i++) {
            graphics.drawLine(i * this.DIMENSION_CASE, 0,
                    i * this.DIMENSION_CASE, this.getHeight());
        }*/
    }

    public void drawWalls(Graphics2D graphics) {
        int startX = this.getArea().getFirstPoint().x;
        int startY = this.getArea().getFirstPoint().y;
        int width = this.getArea().getDimensionArea().width + startX;
        int height = this.getArea().getDimensionArea().height + startY;

        for (int i = startX; i < width; i++) {
            for(int j = startY; j < height ; j++) {
                if (this.getData().getMur(i, j)) {
                    int x = (i - startX) * this.DIMENSION_CASE;
                    int y = (j - startY) * this.DIMENSION_CASE;

                    graphics.fillRect(x, y, this.DIMENSION_CASE, this.DIMENSION_CASE);
                }
            }
        }
    }

    public void addWall(MouseEvent mouseEvent) {
        int startX = this.getArea().getFirstPoint().x;
        int startY = this.getArea().getFirstPoint().y;
    	int x = (mouseEvent.getX() / this.DIMENSION_CASE) + startX;
        int y = (mouseEvent.getY() / this.DIMENSION_CASE) + startY;

        boolean containsWall = this.getData().getMur(x, y);
        this.getData().setMur(x, y, !containsWall);
        this.repaint();
    }

}
