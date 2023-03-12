package Model.Deplacements;

import Model.Actions.AttaqueVillageois;
import Model.Case;
import Model.Grille;
import Model.Potager.Planter;
import Model.Potager.Potager;
import Model.Potager.Recolter;
import Model.Entity.Villageois;
import Utils.ActionVillageois;
import Utils.Direction;

import java.awt.*;
import java.util.ArrayList;

public class DeplacementVillageois implements Runnable{
    //Attribut qui contient l'objet Villageois qui va se déplacer
    private Villageois villageois;
    //Attribut qui contient l'objet Grille sur laquelle les déplacements se font
    private Grille grille;
    private ArrayList<Case> chemin;
    private int idPotager;
    private String action;
    private int idMonstre;
    private Thread thread;

    //Constructeur qui initialise les attributs
    public DeplacementVillageois(Villageois v, Grille grille, ArrayList<Case> chemin, int idPotager, String action, int idMonstre){
        this.grille = grille;
        this.villageois = v;
        this.chemin = chemin;
        this.idPotager = idPotager;
        this.action = action;
        this.idMonstre = idMonstre;
    }

    @Override
    public void run() {
        while (!this.chemin.isEmpty()) {
            // Récupère la position en X du villageois
            int posX = this.villageois.getPosition().x;
            // Récupère la position en Y du villageois
            int posY = this.villageois.getPosition().y;
            Case cible = this.chemin.get(0);
            int x = cible.getX();
            int y = cible.getY();
            if(posX < x){ //Vers la gauche
                this.villageois.setDirection(Direction.right);
                for (int i1 = posX + Villageois.largeur - 1; i1 >= posX; i1--) {
                    for (int i2 = posY + Villageois.hauteur - 1; i2 >= posY; i2--) {
                        this.grille.getCases()[i1][i2].setVillageois(null);
                        this.grille.getCases()[i1][i2].setOccupee(false);
                        this.grille.getCases()[i1 + 1][i2].setVillageois(this.villageois);
                        this.grille.getCases()[i1 + 1][i2].setOccupee(true);
                    }
                }
                Point tmp = new Point(posX + 1, posY);
                this.villageois.setPosition(tmp);
            }
            else if(posX > x){ //Vers la droite
                this.villageois.setDirection(Direction.left);
                for(int i1 = posX; i1 < posX + Villageois.largeur; i1++){
                    for(int i2 = posY; i2 < posY + Villageois.hauteur; i2++){
                        this.grille.getCases()[i1][i2].setVillageois(null);
                        this.grille.getCases()[i1][i2].setOccupee(false);
                        this.grille.getCases()[i1-1][i2].setVillageois(this.villageois);
                        this.grille.getCases()[i1-1][i2].setOccupee(true);
                    }
                }
                Point tmp = new Point(posX - 1, posY);
                this.villageois.setPosition(tmp);
            }
            else if(posY < y){ //Vers le haut
                this.villageois.setDirection(Direction.up);
                for(int i2 = posY + Villageois.hauteur - 1; i2 >= posY; i2--){
                    for(int i1 = posX + Villageois.largeur - 1; i1 >= posX; i1--){
                        this.grille.getCases()[i1][i2].setVillageois(null);
                        this.grille.getCases()[i1][i2].setOccupee(false);
                        this.grille.getCases()[i1][i2+1].setVillageois(this.villageois);
                        this.grille.getCases()[i1][i2+1].setOccupee(true);
                    }
                }
                Point tmp = new Point(posX, posY+1);
                this.villageois.setPosition(tmp);
            }
            else if(posY > y){ //Vers le bas
                this.villageois.setDirection(Direction.down);
                for(int i1 = posX; i1 < posX + Villageois.largeur; i1++){
                    for(int i2 = posY; i2 < posY + Villageois.hauteur; i2++){
                        this.grille.getCases()[i1][i2].setVillageois(null);
                        this.grille.getCases()[i1][i2].setOccupee(false);
                        this.grille.getCases()[i1][i2-1].setVillageois(this.villageois);
                        this.grille.getCases()[i1][i2-1].setOccupee(true);
                    }
                }
                Point tmp = new Point(posX, posY-1);
                this.villageois.setPosition(tmp);
            }
            this.villageois.setWalkEtat();
            this.chemin.remove(0);
            this.grille.setChangedAndNotify();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if("Planter".equals(this.action)) {
            if(this.grille.getPotagers().get(this.idPotager).getRecolter().getThread() != null && this.grille.getPotagers().get(this.idPotager).getRecolter().getThread().isAlive()) {
                this.grille.getPotagers().get(this.idPotager).getRecolter().getThread().interrupt();
            }
            this.villageois.setDirection(this.grille.getPotagers().get(this.idPotager).getDirectionVillageois());
            Planter planter = this.grille.getPotagers().get(this.idPotager).getPlanter();
            if (planter.getThread() != null) {
                planter.getThread().interrupt();
            }
            planter.setNb(0);
            planter.setEtatPotager(0);
            Thread thread = new Thread(planter);
            thread.start();
            planter.setThread(thread);
            try {
                thread.join(); // attendre que le calcul soit terminé
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            this.villageois.setActionAFaire(false);

            Potager potager = this.grille.getPotagers().get(this.idPotager);
            if (potager.getThread() != null) {
                potager.getThread().interrupt();
            }
            potager.setEtatThread(0);
            potager.setNb(0);
            Thread thread2 = new Thread(potager);
            thread2.start();
            potager.setThread(thread2);

        }
        else if("Recolter".equals(this.action)){
            if(this.grille.getPotagers().get(this.idPotager).getThread().isAlive()) {
                this.grille.getPotagers().get(this.idPotager).getThread().interrupt();
            }
            this.villageois.setDirection(this.grille.getPotagers().get(this.idPotager).getDirectionVillageois());
            Recolter recolter = this.grille.getPotagers().get(this.idPotager).getRecolter();
            if (recolter.getThread() != null) {
                recolter.getThread().interrupt();
            }
            recolter.setNb(0);
            recolter.setEtatPotager(12);
            Thread thread = new Thread(recolter);
            thread.start();
            recolter.setThread(thread);
            try {
                thread.join(); // attendre que le calcul soit terminé
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            thread.interrupt();
            this.villageois.setActionAFaire(false);
        }
        else if("Attaquer".equals(this.action)){
            //Mettre le villageois en mode attack
            this.villageois.setWalkAttack(ActionVillageois.attack);
            this.villageois.setDirection(this.grille.getMonstre().get(this.idMonstre).getDirectionVillageois());
            //Demarrer le thread
            AttaqueVillageois attaquer = new AttaqueVillageois(this.villageois, this.grille.getMonstre().get(this.idMonstre));
            if (attaquer.getThread() != null) {
                attaquer.getThread().interrupt();
            }
            attaquer.setEtatAttaque(1);
            Thread thread = new Thread(attaquer);
            thread.start();
            attaquer.setThread(thread);
        }
    }

    //Guetter:
    public Thread getThread() {
        return thread;
    }

    //Setter:
    public void setThread(Thread thread) {
        this.thread = thread;
    }
}
