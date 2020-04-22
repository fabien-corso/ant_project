package jeuDesFourmis.ihm.terrain;

import jeuDesFourmis.model.terrain.Fourmiliere;

import javax.swing.*;
import java.awt.*;

public class StaticLayer extends Layer {

    public StaticLayer(Fourmiliere data) {
        super(data);
    }

    /**
     * Déssine les éléments statiques de notre layer, pour nous les murs
     * qui sont des carrés noirs.
     * @param graphics
     */
    @Override
    protected void makeDrawing(Graphics2D graphics) {
        graphics.setColor(Color.BLACK);

        for (int i = 0; i < this.getData().getLargeur(); i++) {
            for(int j = 0; j < this.getData().getHauteur(); j++) {
                if (this.getData().getMur(i, j)) {
                    int x = i * this.DIMENSION_CASE;
                    int y = j * this.DIMENSION_CASE;

                    graphics.drawRect(x, y, this.DIMENSION_CASE, this.DIMENSION_CASE);
                }
            }
        }
        /*int rows = this.getWidth()/this.DIMENSION_CASE;
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

}
