package jeuDesFourmis.ihm;

import jeuDesFourmis.ihm.frames.MainFrame;

import javax.swing.*;

public class Test {

    public static void main (String [] args) {
        SwingUtilities.invokeLater (new Runnable () {
            public void run () { makeIt () ; }}) ;
    }
    private static void makeIt () {
        MainFrame mf = new MainFrame();
        mf.getTerrain();
    }
}
