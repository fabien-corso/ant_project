package jeuDesFourmis.ihm.terrain;

import jeuDesFourmis.model.terrain.Fourmi;
import jeuDesFourmis.model.terrain.Fourmiliere;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class DynamicLayer extends Layer {

    public DynamicLayer(Fourmiliere data, int dimensionCase) {
        super(data, dimensionCase);
    }

    public DynamicLayer(Fourmiliere data, int dimensionCase, Point cPoint, Dimension nbOfCases) {
        super(data, dimensionCase, cPoint, nbOfCases);
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
        int startX = this.getArea().getFirstPoint().x;
        int startY = this.getArea().getFirstPoint().y;

        for (Fourmi f : this.getData().getFourmis()) {
            System.out.println(f.getX() +" - " + f.getY());
            if (this.getArea().containsPoint(f.getX(), f.getY()))
            {
                if (f.porte()) {
                    graphics.setColor(Color.BLUE);
                }
                else {
                    graphics.setColor(Color.GREEN);
                }
                int x = (f.getX() - startX) * this.DIMENSION_CASE;
                int y = (f.getY() - startY) * this.DIMENSION_CASE;

                graphics.fillOval(x, y, this.DIMENSION_CASE, this.DIMENSION_CASE);
            }
        }
    }

    /**
     * Déssine les graines, plus il y a de graines sur une case, plus elle devient rouge sombre.
     * @param graphics
     */
    public void drawSeeds (Graphics2D graphics) {
        int startX = this.getArea().getFirstPoint().x;
        int startY = this.getArea().getFirstPoint().y;
        int width = this.getArea().getLastPoint().x;
        int height = this.getArea().getLastPoint().y;

        for (int i = startX; i < width; i++) {
            for(int j = startY; j < height; j++) {
                int seedsQuantity = this.getData().getQteGraines(i, j);
                if (seedsQuantity > 0) {
                    int x = (i - startX)* this.DIMENSION_CASE;
                    int y = (j - startY) * this.DIMENSION_CASE;
                    graphics.setColor(new Color(255 - (30 * seedsQuantity), 0, 0));
                    graphics.fillRect(x, y, this.DIMENSION_CASE, this.DIMENSION_CASE);
                }
            }
        }
    }
    
    public void addAnt(MouseEvent mouseEvent) {
        int startX = this.getArea().getFirstPoint().x;
        int startY = this.getArea().getFirstPoint().y;
        int x = (mouseEvent.getX() / this.DIMENSION_CASE) + startX;
        int y = (mouseEvent.getY() / this.DIMENSION_CASE) + startY;
        boolean containsAnt = this.getData().contientFourmi(x, y);

        if (!containsAnt) {
            this.getData().ajouteFourmi(x, y);
        }
        this.repaint();
    }

    public void addSeeds (MouseWheelEvent mouseWheelEvent) {
        int startX = this.getArea().getFirstPoint().x;
        int startY = this.getArea().getFirstPoint().y;
        int x = (mouseWheelEvent.getX() / this.DIMENSION_CASE) + startX;
        int y = (mouseWheelEvent.getY() / this.DIMENSION_CASE) + startY;

        int seedsQty = this.getData().getQteGraines(x, y);
        int rotation = mouseWheelEvent.getWheelRotation();

        if(rotation < 0) {
            if (seedsQty < 4)
                this.getData().setQteGraines(x, y, seedsQty + 1);
        }
        else {
            if (seedsQty > 0)
                this.getData().setQteGraines(x, y, seedsQty - 1);
        }
        this.repaint();
    }
}
