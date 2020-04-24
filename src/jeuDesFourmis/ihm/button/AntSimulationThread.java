package jeuDesFourmis.ihm.button;

import jeuDesFourmis.ihm.frames.MainFrame;
import jeuDesFourmis.model.terrain.Fourmiliere;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class AntSimulationThread extends Thread{

    private boolean play;
    private Fourmiliere data;
    private MainFrame mainFrame;

    public AntSimulationThread(Fourmiliere data, MainFrame mainFrame) {
        this.data = data;
        this.mainFrame = mainFrame;
        this.play = false;
    }

    public void playSimulation() {
        this.play = true;
    }

    public void stopSimulation() {
        this.play = false;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this.play);
            if(this.play){
                System.out.println(this.play);
                this.data.evolue();
                System.out.println("evolution");
                SwingUtilities.invokeLater( () -> mainFrame.refresh());
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
