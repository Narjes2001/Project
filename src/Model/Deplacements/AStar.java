package Model.Deplacements;

import Model.Arbre;
import Model.Case;
import Model.Entity.Monstre;
import Model.Grille;
import Model.Entity.Villageois;
import Utils.Direction;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AStar implements Runnable {
    private Grille grille;
    private Point depart;
    private Point destination;
    private ArrayList<Case> chemin;
    private Thread thread;  // Ajout de la variable d'instance pour stocker la référence à l'objet Thread correspondant
    private int faitAppel; //0 pour le villageois et 1 pour le monstre

    public AStar(Grille grille, Point depart, Point destination, int quiFaitAppel) {
        this.grille = grille;
        this.depart = depart;
        this.faitAppel = quiFaitAppel;
        if(this.faitAppel == 0) {
            if (Grille.LARGEUR - Arbre.LARGEUR - Villageois.largeur < destination.x) {
                if (Grille.HAUTEUR - Arbre.HAUTEUR - Villageois.hauteur < destination.y) {
                    this.destination = new Point(Grille.LARGEUR-Arbre.LARGEUR-Villageois.largeur, Grille.HAUTEUR-Arbre.HAUTEUR-Villageois.hauteur);
                } else if(destination.y < Arbre.HAUTEUR){
                    this.destination = new Point(Grille.LARGEUR-Arbre.LARGEUR-Villageois.largeur, Arbre.HAUTEUR);
                }
                else{
                    this.destination = new Point(Grille.LARGEUR-Arbre.LARGEUR-Villageois.largeur, destination.y);
                }
            } else if(Arbre.LARGEUR > destination.x){
                if (Grille.HAUTEUR - Arbre.HAUTEUR - Villageois.hauteur < destination.y) {
                    this.destination = new Point(Arbre.LARGEUR, Grille.HAUTEUR-Arbre.HAUTEUR-Villageois.hauteur);
                } else if(destination.y < Arbre.HAUTEUR){
                    this.destination = new Point(Arbre.LARGEUR, Arbre.HAUTEUR);
                }
                else{
                    this.destination = new Point(Arbre.LARGEUR, destination.y);
                }
            }
            else{
                if (Grille.HAUTEUR - Arbre.HAUTEUR - Villageois.hauteur < destination.y) {
                    this.destination = new Point(destination.x, Grille.HAUTEUR-Arbre.HAUTEUR-Villageois.hauteur);
                } else if(destination.y < Arbre.HAUTEUR){
                    this.destination = new Point(destination.x, Arbre.HAUTEUR);
                }
                else{
                    this.destination = destination;
                }
            }
        }
        else if(this.faitAppel == 1){
            if (Grille.LARGEUR - Arbre.LARGEUR - Monstre.largeur < destination.x) {
                if (Grille.HAUTEUR - Arbre.HAUTEUR - Monstre.hauteur < destination.y) {
                    this.destination = new Point(Grille.LARGEUR-Arbre.LARGEUR-Monstre.largeur, Grille.HAUTEUR-Arbre.HAUTEUR-Monstre.hauteur);
                } else if(destination.y < Arbre.HAUTEUR){
                    this.destination = new Point(Grille.LARGEUR-Arbre.LARGEUR-Monstre.largeur, Arbre.HAUTEUR);
                }
                else{
                    this.destination = new Point(Grille.LARGEUR-Arbre.LARGEUR-Monstre.largeur, destination.y);
                }
            } else if(Arbre.LARGEUR > destination.x){
                if (Grille.HAUTEUR - Arbre.HAUTEUR - Monstre.hauteur < destination.y) {
                    this.destination = new Point(Arbre.LARGEUR, Grille.HAUTEUR-Arbre.HAUTEUR-Monstre.hauteur);
                } else if(destination.y < Arbre.HAUTEUR){
                    this.destination = new Point(Arbre.LARGEUR, Arbre.HAUTEUR);
                }
                else{
                    this.destination = new Point(Arbre.LARGEUR, destination.y);
                }
            }
            else{
                if (Grille.HAUTEUR - Arbre.HAUTEUR - Monstre.hauteur < destination.y) {
                    this.destination = new Point(destination.x, Grille.HAUTEUR-Arbre.HAUTEUR-Monstre.hauteur);
                } else if(destination.y < Arbre.HAUTEUR){
                    this.destination = new Point(destination.x, Arbre.HAUTEUR);
                }
                else{
                    this.destination = destination;
                }
            }
        }
        else{
            this.destination = null;
        }
        System.out.println("La cible dans A* est : " + this.destination);
        this.chemin = new ArrayList<>();
    }

    public ArrayList<Case> getChemin() {
        return this.chemin;
    }

    @Override
    public void run() {
        Case depart = this.grille.getCases()[this.depart.x][this.depart.y];
        Case destination = this.grille.getCases()[this.destination.x][this.destination.y];
        HashSet<Case> ouverts = new HashSet<>();
        HashSet<Case> fermes = new HashSet<>();
        ouverts.add(depart);
        while (!ouverts.isEmpty()) {
            Case courante = getCaseAvecCoutMinimum(ouverts);
            if (courante.equals(destination)) {
                ArrayList<Case> chemins = new ArrayList<>();
                chemins.add(courante);
                while (courante.getPere() != null) {
                    courante = courante.getPere();
                    chemins.add(0, courante);
                }
                System.out.println("A* a trouve un resultat");
                this.chemin = chemins;
                //rafraichissement cases pour A*
                for(int i = 0; i < Grille.LARGEUR; i++){
                    for(int j = 0; j < Grille.HAUTEUR; j++){
                        this.grille.getCases()[i][j].setCout(0);
                        this.grille.getCases()[i][j].setHeuristique(0);
                        this.grille.getCases()[i][j].setPere(null);
                    }
                }
                return;
            }

            ouverts.remove(courante);
            fermes.add(courante);

            for (Case voisin : getVoisinsDeCase(courante)) {
                if (!fermes.contains(voisin)) {
                    int nouveauCout = courante.getCout() + getCoutEntreCases(voisin);

                    if (nouveauCout < voisin.getCout() || !ouverts.contains(voisin)) {
                        voisin.setCout(nouveauCout);
                        voisin.setHeuristique(getHeuristiqueEntreCases(voisin, destination));
                        voisin.setPere(courante);

                        if (!ouverts.contains(voisin)) {
                            ouverts.add(voisin);
                        }
                    }
                }
            }
        }
        //rafraichissement cases pour A*
        for(int i = 0; i < Grille.LARGEUR; i++){
            for(int j = 0; j < Grille.HAUTEUR; j++){
                this.grille.getCases()[i][j].setCout(0);
                this.grille.getCases()[i][j].setHeuristique(0);
                this.grille.getCases()[i][j].setPere(null);
            }
        }
        System.out.println("A* n'a pas trouvé de resultat");
    }


    private Case getCaseAvecCoutMinimum(Set<Case> noeuds) {
        Case noeudMinimum = null;
        int coutMinimum = Integer.MAX_VALUE;

        for (Case noeud : noeuds) {
            int cout = noeud.getCout() + noeud.getHeuristique();

            if (cout < coutMinimum) {
                noeudMinimum = noeud;
                coutMinimum = cout;
            }
        }

        return noeudMinimum;
    }

    private int getCoutEntreCases(Case arrivee) {
        int cout = 1;

        if (this.grille.positionOccupee(arrivee.getX(), arrivee.getY())){
            cout = Integer.MAX_VALUE;
        }
        return cout;
    }

    private int getHeuristiqueEntreCases(Case depart, Case arrivee) {
        int dx = Math.abs(depart.getX() - arrivee.getX());
        int dy = Math.abs(depart.getY() - arrivee.getY());
        return dx + dy;
    }

    private ArrayList<Case> getVoisinsDeCase(Case caseCourante) {
        ArrayList<Case> voisins = new ArrayList<>();

        Point point = new Point(caseCourante.getX(), caseCourante.getY());

        if (point.x > 0 && positionPossible(point.x, point.y, Direction.left)) {
            Case voisinGauche = grille.getCases()[point.x - 1][point.y];
            voisins.add(voisinGauche);
        }
        if (point.x < Grille.LARGEUR - 1 && positionPossible(point.x, point.y, Direction.right)) {
            Case voisinDroite = grille.getCases()[point.x + 1][point.y];
            voisins.add(voisinDroite);
        }

        if (point.y > 0 && positionPossible(point.x, point.y, Direction.down)) {
            Case voisinBas = grille.getCases()[point.x][point.y - 1];
            voisins.add(voisinBas);
        }

        if (point.y < Grille.HAUTEUR - 1 && positionPossible(point.x, point.y, Direction.up)) {
            Case voisinHaut = grille.getCases()[point.x][point.y + 1];
            voisins.add(voisinHaut);
        }
        return voisins;
    }

    private boolean positionPossible(int x, int y, Direction d){
        boolean res = true;
        if(this.faitAppel == 0) {
            if (d == Direction.up) {
                for (int i = x; i < x + Villageois.largeur; i++) {
                    res = res && !this.grille.positionOccupee(i, y + Villageois.hauteur + 1);
                }
            } else if (d == Direction.down) {
                for (int i = x; i < x + Villageois.largeur; i++) {
                    res = res && !this.grille.positionOccupee(i, y - 2);
                }
            } else if (d == Direction.left) {
                for (int j = y; j < y + Villageois.hauteur; j++) {
                    res = res && !this.grille.positionOccupee(x - 1, j);
                }
            }
            else if (d == Direction.right) {
                for (int j = y; j < y + Villageois.hauteur; j++) {
                    res = res && !this.grille.positionOccupee(x + Villageois.largeur + 1, j);
                }
            }
        }
        else if(this.faitAppel == 1){
            if (d == Direction.up) {
                for (int i = x; i < x + Monstre.largeur; i++) {
                    res = res && !this.grille.positionOccupee(i, y + Monstre.hauteur + 1);
                }
            } else if (d == Direction.down) {
                for (int i = x; i < x + Monstre.largeur; i++) {
                    res = res && !this.grille.positionOccupee(i, y - 2);
                }
            } else if (d == Direction.left) {
                for (int j = y; j < y + Monstre.hauteur; j++) {
                    res = res && !this.grille.positionOccupee(x - 1, j);
                }
            }
            else if (d == Direction.right) {
                for (int j = y; j < y + Monstre.hauteur; j++) {
                    res = res && !this.grille.positionOccupee(x + Monstre.largeur + 1, j);
                }
            }
        }
        else{
            res = false;
        }
        return res;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }
}