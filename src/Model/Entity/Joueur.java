package Model.Entity;

import Utils.ActionVillageois;
import Utils.Direction;

import java.awt.*;

//Classe représentant le joueur
public class Joueur {
    //Position actuelle du joueur dans l'espace de jeu
    private Point position;
    //Le score du joueur
    private int score;
    //Booléen indiquant si le joueur est en train de se déplacer
    private boolean isMoving;
    private ActionVillageois walkAttack;
    //Fonction du joueur
    private String fonction;
    //Direction dans laquelle se déplace le joueur
    private Direction direction;
    private int etatAttack;
    private boolean isSelected;
    private int etatWalk;

    //Constructeur permettant de créer un nouveau joueur à une position donnée (x, y) avec une fonction donnée
    public Joueur(int x, int y, String fonction){
        this.position = new Point(x, y);
        this.score = 100;
        this.fonction = fonction;
        this.direction = Direction.up;
        this.isSelected = false;
        this.etatWalk = 1;
        this.walkAttack = ActionVillageois.normal;
    }



    //Getters:


    public int getEtatAttack() {
        return etatAttack;
    }

    //Retourne la position actuelle du joueur
    public Point getPosition() {
        return position;
    }

    //Retourne la fonction du joueur
    public String getFonction() {
        return fonction;
    }

    //Retourne vrai si le joueur est en train de se déplacer, faux sinon
    public boolean isMoving() {
        return isMoving;
    }

    //Retourne la direction dans laquelle se déplace le joueur
    public Direction getDirection() {
        return direction;
    }

    //Retourne le score du joueur
    public int getScore() {
        return score;
    }

    public boolean isSelected() {
        return isSelected;
    }


    public int getEtatWalk() {
        return etatWalk;
    }

    public ActionVillageois getWalkAttack() {
        return walkAttack;
    }

    //Setters:
    public void setEtatAttack(int etatAttack) {
        this.etatAttack = etatAttack;
    }

    //Définit la position du joueur
    public void setPosition(Point position) {
        this.position = position;
    }

    //Définit si le joueur est en train de se déplacer ou non
    public void setMoving(boolean moving) {
        this.isMoving = moving;
    }

    //Définit la direction dans laquelle se déplace le joueur
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    //Définit le score du joueur
    public void setScore(int score) {
        this.score = score;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public void setEtatWalk(int etatWalk) {
        this.etatWalk = etatWalk;
    }

    public void setWalkAttack(ActionVillageois walkAttack) {
        this.walkAttack = walkAttack;
    }
}
