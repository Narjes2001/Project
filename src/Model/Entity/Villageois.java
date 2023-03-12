package Model.Entity;

import Model.Case;
import Model.Deplacements.DeplacementHasard;
import Model.Deplacements.DeplacementVillageois;
import Model.Grille;

import java.util.ArrayList;

public class Villageois extends Joueur {
    private boolean actionAFaire;
    private int degat;
    //La largeur du joueur
    public static final int largeur = 5;
    //La hauteur du joueur
    public static final int hauteur = 8;;

    public Villageois(int x, int y){
        super(x, y, "Villageois");
        this.actionAFaire = false;
        this.degat = 5;
    }

    public void setWalkEtat(){
        if(this.getEtatWalk() == 4){
            this.setEtatWalk(1);
        }
        else{
            int i = this.getEtatWalk() + 1;
            this.setEtatWalk(i);
        }
    }

    public void deplacer(Grille grille){
        DeplacementHasard deplacement = new DeplacementHasard(this, grille);
        deplacement.start();
    }

    public void deplacerAction(Grille grille, ArrayList<Case> chemin, int idPotager, String action, int idMonstre){
        DeplacementVillageois deplacementAStar = new DeplacementVillageois(this, grille, chemin, idPotager, action, idMonstre);
        if (deplacementAStar.getThread() != null) {
            deplacementAStar.getThread().interrupt();
        }
        Thread thread = new Thread(deplacementAStar);
        thread.start();
        deplacementAStar.setThread(thread);
    }

    //Guetters:

    public int getDegat() {
        return degat;
    }

    public boolean isActionAFaire() {
        return actionAFaire;
    }

    //Setters:

    public void setActionAFaire(boolean actionAFaire) {
        this.actionAFaire = actionAFaire;
    }

}
