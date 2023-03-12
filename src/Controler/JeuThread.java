package Controler;

import Model.Defense;
import Model.Entity.Monstre;
import Model.Game;
import Model.Grille;
import Vue.Affichage;
import Vue.VueMonstre;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class JeuThread extends Thread {
    private Game game;
    private Control control;

    public JeuThread(Game game, Control control) {
        this.game = game;
        this.control = control;
    }


    @Override
    public void run() {
        int tempo = 0;
        while(true) {
            //Faire déplacer les villageois de manière au hasard
            for(int i =  0; i < this.game.getVillageois().size(); i++){
                if(!this.game.getVillageois().get(i).isActionAFaire() && !this.game.getVillageois().get(i).isMoving()) {
                    this.game.getVillageois().get(i).setMoving(true);
                    this.game.getVillageois().get(i).deplacer(this.game.getGrille());
                }
            }

            //Ajouter un monstre à chaque tempo
            if(tempo == 120){
                this.game.getGrille().addMonstres();
                Monstre monster = this.game.getGrille().getMonstre().get(this.game.getGrille().getMonstre().size()-1);
                this.control.getAffichage().getGrille().addMonstres(new VueMonstre(monster));
                monster.deplacer(this.game.getGrille());
                tempo = 0;
            }
            else {
                tempo++;
            }
            //Supprimer les monstres morts
            for(int i = 0; i < this.game.getGrille().getMonstre().size(); i++){
                Monstre monstre = this.game.getGrille().getMonstre().get(i);
                if((monstre != null && monstre.estMort()) || monstre == null){
                    int x = monstre.getPosition().x;
                    int y = monstre.getPosition().y;
                    int idVueMonstre = -1;
                    for(int s = 0;  s < this.control.getAffichage().getGrille().getMonstres().size(); s++){
                        if(this.control.getAffichage().getGrille().getMonstres().get(s).getMonstre() == monstre){
                            idVueMonstre = s;
                            break;
                        }
                    }
                    this.control.getAffichage().getGrille().removeMonstre(idVueMonstre);
                    this.game.getGrille().getMonstre().remove(monstre);
                    for(int i1 = x; i1 < x + Monstre.largeur; i1++){
                        for(int i2 = y; i2 < y + Monstre.hauteur; i2++){
                            this.game.getGrille().getCases()[i1][i2].setMonstres(null);
                        }
                    }
                }
            }
            //Lancer les tours de défenses si un monstre est dans leurs rayon
            for(int i = 0; i < this.game.getGrille().getDefenses().size(); i++){
                Defense defense = this.game.getGrille().getDefenses().get(i);
                if(defense.getMonstre() == null) {
                    defense.verifieMonstreDansRayon();
                    if (defense.getMonstre() != null && !defense.isEnAttaque()) {
                        defense.setEnAttaque(true);
                        if (defense.getThread() != null) {
                            defense.getThread().interrupt();
                        }
                        Thread t = new Thread(defense);
                        t.start();
                        defense.setThread(t);
                    }
                }
            }

            //Rafraichir les places occupées
            for(int i = 0; i < this.game.getGrille().getMonstre().size(); i++){
                int posX = this.game.getGrille().getMonstre().get(i).getPosition().x;
                int posY = this.game.getGrille().getMonstre().get(i).getPosition().y;
                for(int i1 = posX; i1 < posX + Monstre.largeur; i1++){
                    for(int i2 = posY; i2 < posY + Monstre.hauteur; i2++){
                        this.game.getGrille().getCases()[i1][i2].setMonstres(this.game.getGrille().getMonstre().get(i));
                    }
                }
            }

            // Attendre un certain temps secondes
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }


    private int genererInt(int borneInf, int borneSup){
        Random random = new Random();
        int nb;
        nb = borneInf+random.nextInt(borneSup-borneInf);
        return nb;
    }
}
