package Model.Potager;

import Utils.Plante;

import java.awt.*;

public class Recolter implements Runnable {
    private int etatPotager;
    private Plante plante;
    private Point position;
    public static final int largeur = 20;
    public static final int hauteur = 20;
    private boolean isSelected;
    private Potager potager;

    private int nb;
    private Thread thread;  // Ajout de la variable d'instance pour stocker la référence à l'objet Thread correspondant

    //Constructeur:
    public Recolter(Potager potager, Point p) {
        this.position = p;
        this.potager = potager;
        this.etatPotager = 12;
        this.plante = null;
        this.isSelected = false;
    }

    // Méthode pour démarrer le thread et stocker la référence à l'objet Thread correspondant
    public void demarrerThread() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    // Méthode pour arrêter le thread
    public void arreterThread() {
        if (thread != null) {
            thread.interrupt();
            thread = null;
        }
    }

    public void planter(Plante p){
        this.plante = p;
        this.etatPotager = 1;
    }



    @Override
    public void run() {
        while (this.nb == 0) {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            this.potager.setEtatPotager(this.etatPotager);
            if (this.etatPotager == 15) {
                this.nb = 1;
            } else {
                this.etatPotager++;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.etatPotager = 0;
        this.potager.setEtatPotager(this.etatPotager);
    }


    //Guetters:
    public int getEtatPotager() {
        return etatPotager;
    }

    public int getNb() {
        return nb;
    }

    public Point getPosition() {
        return position;
    }

    public Plante getPlante() {
        return plante;
    }

    public Thread getThread() {
        return thread;
    }

    public boolean isSelected() {
        return isSelected;
    }

    //Setters:
    public void setEtatPotager(int etatPotager) {
        this.etatPotager = etatPotager;
    }


    public void setPlante(Plante plante) {
        this.plante = plante;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }
    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}

