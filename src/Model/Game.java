package Model;

import Model.Entity.Villageois;

import java.awt.*;
import java.util.ArrayList;

/* La classe Game représente le jeu lui-même et contient une instance de la grille,
    une liste de villageois et un joueur. */
public class Game {
    private Grille grille; // une instance de la grille
    private ArrayList<Villageois> villageois; // liste des villageois

     //Constructeur
    public Game(){
        this.villageois = new ArrayList<>(); // initialiser la liste des villageois
        this.grille = new Grille(this.villageois); // initialiser la grille avec la liste des villageois
        Point position = this.grille.genererPoint(); // générer une position aléatoire pour le joueur
    }

    //Getters:
    public Grille getGrille() {
        return this.grille;
    }
    public ArrayList<Villageois> getVillageois() {
        return this.villageois;
    }
}
