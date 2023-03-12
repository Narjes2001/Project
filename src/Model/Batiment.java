package Model;

import java.awt.*;
import java.util.Observable;

public class Batiment extends Observable {
    private int HP;
    private int etat;
    private Point position;
    private int largeur;
    private int hauteur;
    private String nom;

    //Constructeur
    public Batiment(Point p, String nom, int l, int h){
        this.position = p;
        this.HP = 100;
        this.nom = nom;
        this.largeur = l;
        this.hauteur = h;
    }

    //Guetters :
    public int getHP() {
        return this.HP;
    }

    public int getEtat() {
        return this.etat;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public String getNom() {
        return nom;
    }

    public Point getPosition() {
        return position;
    }

    // Si un batiment n'a plus de HP, son etat passe a casse
    public void estDetruit(){
        if (this.HP == 0) {
            this.etat = 0;
        }
    }

    // Si le batiment gagne un niveau, ces HPs sont augmentées et son etat devient automatiquement bon
    public void lvlUp(){
        this.HP += 300;
        this.etat = 3;
    }

    //Setters:
    public void setPosition(Point position) {
        this.position = position;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }
}
