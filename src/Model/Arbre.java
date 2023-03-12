package Model;

import java.awt.*;
import java.util.Random;

public class Arbre extends Batiment{
    public final static int LARGEUR = 20;
    public final static int HAUTEUR = 20;
    private boolean NB;

    public Arbre(Point p, String nom) {
        super(p, nom, LARGEUR, HAUTEUR);
        Random rd = new Random();
        this.NB = rd.nextBoolean();
    }



    //Guetters:
    public boolean getNB() {
        return NB;
    }
}
