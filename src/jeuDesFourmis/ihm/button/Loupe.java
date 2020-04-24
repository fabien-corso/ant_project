package jeuDesFourmis.ihm.button;

import jeuDesFourmis.ihm.frames.MainFrame;
import jeuDesFourmis.ihm.frames.LoupeFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Loupe extends JButton implements ActionListener {

    private MainFrame mainFrame;
    public Loupe(MainFrame mf) {
        super("Loupe");
        this.mainFrame = mf;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        LoupeFrame lpFrame = new LoupeFrame(this.mainFrame);
    }
}
