package jeuDesFourmis.ihm;

import jeuDesFourmis.ihm.terrain.DynamicLayer;
import jeuDesFourmis.ihm.terrain.StaticLayer;
import jeuDesFourmis.ihm.terrain.Terrain;
import jeuDesFourmis.model.terrain.Fourmiliere;

import javax.swing.*;

public class Test {

    public static void main (String [] args) {
        SwingUtilities.invokeLater (new Runnable () {
            public void run () { makeIt () ; }}) ;
    }
    private static void makeIt () {
        JFrame frame = new JFrame ("Fourmis");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        // La fourmilere
        Fourmiliere f = new Fourmiliere(100,100);

        // On crée quelques murs
        for (int i =1; i <4; i++)
            f.setMur(i, 2*i, true);
        // On ajoute 3 fourmis dans la fourmilière
        f.ajouteFourmi(1, 1);
        f.ajouteFourmi(2, 2);
        f.ajouteFourmi(3, 3);

        f.getFourmis().get(0).prend();
        // On pose des graines
        for (int i =0; i <10; i++){
            f.setQteGraines(2*i, i, 2);
            f.setQteGraines(2*i , 11-i , 1);
        }
        Terrain t = new Terrain(f);
        frame.setContentPane(t); ;
        frame.pack () ;
        frame.setVisible (true);
    }
}
