package jeuDesFourmis.ihm.terrain;

import jeuDesFourmis.model.terrain.Fourmi;
import jeuDesFourmis.model.terrain.Fourmiliere;

import java.awt.*;

public class DynamicLayer extends Layer {

    public DynamicLayer(Fourmiliere data) {
        super(data);
    }

    @Override
    protected void makeDrawing(Graphics2D graphics) {
        this.drawAnts(graphics);
        this.drawSeeds(graphics);
    }

    /**
     * Déssine les fourmis. Si une fourmi est porteuse c'est un cercle bleu, sinon vert.
     * @param graphics
     */
    private void drawAnts(Graphics2D graphics) {
        for (Fourmi f : this.getData().getFourmis()) {
            if (f.porte()) {
                graphics.setColor(Color.BLUE);
            }
            else {
                graphics.setColor(Color.GREEN);
            }
            int x = f.getX() * this.DIMENSION_CASE;
            int y = f.getY() * this.DIMENSION_CASE;

            graphics.fillOval(x, y, this.DIMENSION_CASE, this.DIMENSION_CASE);
        }
    }

    /**
     * Déssine les graines, plus il y a de graines sur une case, plus elle devient rouge sombre.
     * @param graphics
     */
    public void drawSeeds (Graphics2D graphics) {
        for (int i = 0; i < this.getData().getLargeur(); i++) {
            for(int j = 0; j < this.getData().getHauteur(); j++) {
                int seedsQuantity = this.getData().getQteGraines(i, j);
                if (seedsQuantity > 0) {
                    int x = i * this.DIMENSION_CASE;
                    int y = j * this.DIMENSION_CASE;
                    graphics.setColor(new Color(255 - (30 * seedsQuantity), 0, 0));
                    graphics.fillRect(x, y, this.DIMENSION_CASE, this.DIMENSION_CASE);
                }
            }
        }
    }
}
