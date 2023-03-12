package Model.Potager;

import Model.Grille;
import Model.Entity.Villageois;
import Utils.Direction;
import Utils.Plante;

import java.awt.*;

public class Potager implements Runnable {
    private int etatPotager;
    private Plante plante;
    private Point position;
    public static final int largeur = 20;
    public static final int hauteur = 20;
    private boolean isSelected;
    private Recolter recolter;
    private Planter planter;
    private Grille grille;
    private Direction directionVillageois;

    private int etatThread;
    private int nb;
    private Thread thread;  // Ajout de la variable d'instance pour stocker la référence à l'objet Thread correspondant

    //Constructeur:
    public Potager(Grille grille, Point p) {
        this.position = p;
        this.grille = grille;
        this.planter = new Planter(this, p);
        this.recolter = new Recolter(this, p);
        this.etatPotager = this.planter.getEtatPotager();
        this.plante = null;
        this.etatThread = 0;
        this.isSelected = false;
    }
    public void planter(Plante p){
        this.plante = p;
        this.etatPotager = 1;
    }

    public Point positionPourVillageois(){
        Point res = null;
        boolean fini = false;
        int x = this.position.x;
        int y = this.position.y;

        while(!fini) {
            int random = (int) Math.floor(Math.random() * 4 + 1);
            if (random == 1) { // Donner une position vers le haut
                res = new Point((x + (largeur/2)) - (Villageois.largeur/2), y - Villageois.hauteur-1);
                this.directionVillageois = Direction.up;
            }
            else if (random == 2) { // Donner une position vers le bas
                res = new Point((x + (largeur/2)) - (Villageois.largeur/2), y+hauteur+1);
                this.directionVillageois = Direction.down;
            }
            else if (random == 3) { // Donner une position vers la gauche
                res = new Point(x-Villageois.largeur-1, y + (Villageois.hauteur /2));
                this.directionVillageois = Direction.right;
            }
            else if (random == 4) { // Donner une position vers la droite
                res = new Point((x+largeur+1), y + (Villageois.hauteur/2));
                this.directionVillageois = Direction.left;
            }
            if(res != null && positionPossible(res.x, res.y)){
                fini = true;
            }
        }
        return res;
    }
    private boolean positionPossible(int x, int y){
        boolean res = true;
        for(int i = x; i < x + Villageois.largeur; i++){
            for(int j = y; j < y + Villageois.hauteur; j++){
                res = res && !this.grille.positionOccupee(i,j);
            }
        }
        return res;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }

            if (this.etatPotager <= 12 && this.nb == 0) {
                if (this.etatThread == 3) {
                    try {
                        Thread.sleep(25000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    this.etatThread = 0;
                } else {
                    if (this.etatPotager == 12) {
                        this.nb = 1;
                    } else {
                        this.etatPotager++;
                    }
                    this.etatThread++;
                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }


    //Guetters:
    public int getEtatPotager() {
        return etatPotager;
    }

    public Planter getPlanter() {
        return planter;
    }

    public Recolter getRecolter() {
        return recolter;
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

    public Direction getDirectionVillageois() {
        return directionVillageois;
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

    public void setEtatThread(int etatThread) {
        this.etatThread = etatThread;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
