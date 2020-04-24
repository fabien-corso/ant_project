package jeuDesFourmis.ihm.frames;

import jeuDesFourmis.ihm.terrain.Terrain;
import jeuDesFourmis.ihm.terrain.ZoomedTerrain;
import jeuDesFourmis.model.terrain.Fourmiliere;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class LoupeFrame extends JFrame implements WindowListener {

    private MainFrame mainFrame;
    private Fourmiliere data;
    private Terrain terrain;

    public LoupeFrame(MainFrame mf) {
        this.mainFrame = mf;
        this.data = mf.getData();
        this.terrain =  new ZoomedTerrain(this.data, new Point(25,25), new Dimension(11,11));
        this.add(this.terrain, BorderLayout.CENTER);
        this.addWindowListener(this);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        SwingUtilities.invokeLater( () -> this.terrain.refreshAll());
    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {
        SwingUtilities.invokeLater( () -> this.mainFrame.getTerrain().refreshAll());
    }
}
