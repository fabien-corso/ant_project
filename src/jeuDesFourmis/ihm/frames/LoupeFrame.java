package jeuDesFourmis.ihm.frames;

import jeuDesFourmis.ihm.terrain.Terrain;
import jeuDesFourmis.ihm.terrain.ZoomedTerrain;
import jeuDesFourmis.model.terrain.Fourmiliere;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class LoupeFrame extends AntSimulationFrame implements WindowListener {

    public static Dimension DEFAULT_LOUPE_DIMENSION = new Dimension(11, 11);
    private MainFrame mainFrame;
    private Fourmiliere data;

    public LoupeFrame(MainFrame mf, Point centralP, Dimension d) {
        super("Loupe - cellule centrale: x=" + centralP.x + ", y=" + centralP.y);
        this.mainFrame = mf;
        this.data = mf.getData();
        this.setTerrain(new ZoomedTerrain(this.mainFrame, this.data, centralP, d));
        this.add(this.getTerrain(), BorderLayout.CENTER);
        this.addWindowListener(this);
        this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public LoupeFrame(MainFrame mainFrame, Point centralP) {
        this(mainFrame, centralP, LoupeFrame.DEFAULT_LOUPE_DIMENSION);
    }

    @Override
    public void windowOpened(WindowEvent windowEvent) {
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        SwingUtilities.invokeLater( () -> this.mainFrame.getTerrain().refreshAll());
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {

    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {
        SwingUtilities.invokeLater( () -> this.getTerrain().refreshAll());
    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {
        SwingUtilities.invokeLater( () -> this.mainFrame.getTerrain().refreshAll());
    }

}
