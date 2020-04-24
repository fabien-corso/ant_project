package jeuDesFourmis.ihm.frames;

import jeuDesFourmis.ihm.terrain.Terrain;

import javax.swing.*;
import java.awt.*;

public abstract class AntSimulationFrame extends JFrame {

    private Terrain terrain;
    public AntSimulationFrame() throws HeadlessException {
        super();
    }

    public AntSimulationFrame(String title) throws HeadlessException {
        super(title);
    }

    public void refresh() {
        this.terrain.refresh();
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }
}
