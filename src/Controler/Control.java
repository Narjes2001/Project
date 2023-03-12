package Controler;

import Model.*;
import Model.Deplacements.AStar;
import Model.Entity.Monstre;
import Model.Entity.Villageois;
import Model.Potager.Potager;
import Utils.ActionVillageois;
import Vue.Affichage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Control implements ActionListener, KeyListener {
    private final Game game;
    private final Affichage affichage;
    private int idPotager = 0;
    private int idVillageois = 0;
    private int idMonstre = 0;
    private String action;

    public Control(){
        this.game = new Game();
        this.affichage = new Affichage(this.game.getGrille());
        this.affichage.addKeyListener(this);
        this.affichage.requestFocusInWindow();
        JeuThread jeu  = new JeuThread(this.game, this);
        jeu.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("Récolter".equals(e.getActionCommand())){
            Potager potager = this.game.getGrille().getPotagers().get(this.idPotager);
            potager.setSelected(true);
            this.action = "Recolter1";
        }
        if ("Planter".equals(e.getActionCommand())) {
            Potager potager = this.game.getGrille().getPotagers().get(this.idPotager);
            potager.setSelected(true);
            this.action = "Planter1";
        }
        if("Attaquer".equals(e.getActionCommand())){
            Monstre monstre = this.game.getGrille().getMonstre().get(this.idMonstre);
            monstre.setSelected(true);
            this.action = "Attaquer1";
        }
        this.game.getGrille().notifyObservers();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            if("Planter1".equals(this.action) || "Recolter1".equals(this.action)) {
                Potager potager = this.game.getGrille().getPotagers().get(this.idPotager);
                potager.setSelected(false);
                Villageois villageois = this.game.getGrille().getVillageois().get(this.idVillageois);
                villageois.setSelected(true);

                if("Planter1".equals(this.action)) {
                    this.action = "Planter2";
                }
                else if("Recolter1".equals(this.action)){
                    this.action = "Recolter2";
                }
            }
            else if("Planter2".equals(this.action) || "Recolter2".equals(this.action)) {
                Villageois villageois = this.game.getGrille().getVillageois().get(this.idVillageois);
                villageois.setSelected(false);
                villageois.setActionAFaire(true);
                Point depart = new Point(villageois.getPosition().x, villageois.getPosition().y); // choisir un point de départ
                Point destination = this.game.getGrille().getPotagers().get(this.idPotager).positionPourVillageois(); // choisir un point d'arrivée
                AStar astar = new AStar(this.game.getGrille(), depart, destination, 0); // créer un objet AStar
                if (astar.getThread() != null) {
                    astar.getThread().interrupt();
                }
                Thread thread = new Thread(astar);
                thread.start();
                astar.setThread(thread);
                try {
                    thread.join(); // attendre que le calcul soit terminé
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                ArrayList<Case> chemin = astar.getChemin(); // récupérer le chemin calculé
                System.out.println("taille du chemin pour planter ou recolter : " + chemin.size());
                thread.interrupt();
                if("Planter2".equals(this.action)) {
                    villageois.deplacerAction(this.game.getGrille(), chemin, this.idPotager, "Planter", -1);
                }
                else if("Recolter2".equals(this.action)){
                    villageois.deplacerAction(this.game.getGrille(), chemin, this.idPotager, "Recolter", -1);
                }
                this.action = null;
                this.idMonstre = 0;
                this.idPotager = 0;
                this.idVillageois = 0;
            }
            else if("Attaquer1".equals(this.action)){
                Monstre monstre = this.game.getGrille().getMonstre().get(this.idMonstre);
                monstre.setSelected(false);
                Villageois villageois = this.game.getGrille().getVillageois().get(this.idVillageois);
                villageois.setSelected(true);
                this.action = "Attaquer2";
            }
            else if("Attaquer2".equals(this.action)){
                Villageois villageois = this.game.getGrille().getVillageois().get(this.idVillageois);
                villageois.setSelected(false);
                villageois.setActionAFaire(true);
                Point depart = new Point(villageois.getPosition().x, villageois.getPosition().y); // choisir un point de départ
                Point destination = this.game.getGrille().getMonstre().get(this.idMonstre).positionPourVillageois(); // choisir un point d'arrivée
                AStar astar = new AStar(this.game.getGrille(), depart, destination, 0); // créer un objet AStar
                if (astar.getThread() != null) {
                    astar.getThread().interrupt();
                }
                Thread thread = new Thread(astar);
                thread.start();
                astar.setThread(thread);
                try {
                    thread.join(); // attendre que le calcul soit terminé
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                ArrayList<Case> chemin = astar.getChemin(); // récupérer le chemin calculé
                System.out.println("taille du chemin pour attaquer : " + chemin.size());
                //thread.interrupt();
                villageois.setWalkAttack(ActionVillageois.walkAttack);
                villageois.deplacerAction(this.game.getGrille(), chemin, -1, "Attaquer", this.idMonstre);
                this.action = null;
                this.idMonstre = 0;
                this.idPotager = 0;
                this.idVillageois = 0;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if("Planter1".equals(this.action) || "Recolter1".equals(this.action)){
                this.game.getGrille().getPotagers().get(this.idPotager).setSelected(false);
                if(this.idPotager == this.game.getGrille().getPotagers().size()-1){
                    this.idPotager = 0;
                }
                else{
                    this.idPotager++;
                }
                this.game.getGrille().getPotagers().get(this.idPotager).setSelected(true);
            }
            if("Planter2".equals(this.action) || "Recolter2".equals(this.action) || "Attaquer2".equals(this.action)){
                this.game.getVillageois().get(this.idVillageois).setSelected(false);
                if(this.idVillageois == this.game.getGrille().getVillageois().size()-1){
                    this.idVillageois = 0;
                }
                else{
                    this.idVillageois++;
                }
                this.game.getVillageois().get(this.idVillageois).setSelected(true);
            }
            if("Attaquer1".equals(this.action)){
                this.game.getGrille().getMonstre().get(this.idMonstre).setSelected(false);
                if(this.idMonstre == this.game.getGrille().getMonstre().size()-1){
                    this.idMonstre = 0;
                }
                else{
                    this.idMonstre++;
                }
                this.game.getGrille().getMonstre().get(this.idMonstre).setSelected(true);
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if("Planter1".equals(this.action) || "Recolter1".equals(this.action)){
                this.game.getGrille().getPotagers().get(this.idPotager).setSelected(false);
                if(this.idPotager == 0){
                    this.idPotager = this.game.getGrille().getPotagers().size()-1;
                }
                else{
                    this.idPotager--;
                }
                this.game.getGrille().getPotagers().get(this.idPotager).setSelected(true);
            }
            if("Planter2".equals(this.action) || "Recolter2".equals(this.action) || "Attaquer2".equals(this.action)){
                this.game.getVillageois().get(this.idVillageois).setSelected(false);
                if(this.idVillageois == 0){
                    this.idVillageois = this.game.getGrille().getVillageois().size()-1;
                }
                else{
                    this.idVillageois--;
                }
                this.game.getVillageois().get(this.idVillageois).setSelected(true);
            }
            if("Attaquer1".equals(this.action)){
                this.game.getGrille().getMonstre().get(this.idMonstre).setSelected(false);
                if(this.idMonstre == 0){
                    this.idMonstre = this.game.getGrille().getMonstre().size()-1;
                }
                else{
                    this.idMonstre--;
                }
                this.game.getGrille().getMonstre().get(this.idMonstre).setSelected(true);
            }
        }
        this.game.getGrille().notifyObservers();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    //Guetters :
    public Game getGame() {
        return game;
    }

    public Affichage getAffichage() {
        return affichage;
    }
}
