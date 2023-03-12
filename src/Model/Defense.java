package Model;

import Model.Entity.Monstre;

import java.awt.*;

public class Defense extends Batiment implements Runnable {
    private int degat;
    private int rayon;
    private int etatWeapon;
    private int niveau;
    private Grille grille;
    private Monstre monstre;
    private boolean enAttaque;
    private Point positionMonstre;

    private Thread thread;  // Ajout de la variable d'instance pour stocker la référence à l'objet Thread correspondant


    //Constructeur:
    public Defense(Grille grille, Point p, String nom, int l, int h, int d, int r) {
        super(p, nom, l, h);
        this.degat = d;
        this.rayon = r;
        this.etatWeapon = 1;
        this.niveau = 1;
        this.grille = grille;
        this.monstre = null;
        this.enAttaque = false;
        this.positionMonstre = null;
    }

    public void verifieMonstreDansRayon(){
        for(int i = 0; i < this.grille.getMonstre().size(); i++){
            //Coordonnée du centre de l'objet monstre
            int xM = this.grille.getMonstre().get(i).getPosition().x + (Monstre.largeur / 2);
            int yM = this.grille.getMonstre().get(i).getPosition().y + (Monstre.hauteur / 2);
            //Coordonnée du centre de la tour de défense
            int xB = this.getPosition().x + (this.getLargeur()/2);
            int yB = this.getPosition().y + (this.getHauteur()/2);
            //Calculer la distance
            double posXP = Math.pow(xM - xB, 2);
            double posYP = Math.pow(yM - yB, 2);
            double distance = Math.sqrt(posXP + posYP);
            if(distance <= this.rayon){
                this.monstre = this.grille.getMonstre().get(i);
                this.positionMonstre = this.grille.getMonstre().get(i).getPosition();
            }
        }
    }

    @Override
    public void run() {
        int tempo = 0;
        while(this.monstre != null && !this.monstre.estMort()){
            if(tempo == 1){
                if(this.etatWeapon == 6){
                    this.etatWeapon = 1;
                }
                else{
                    this.etatWeapon++;
                }
                this.monstre.subitDegat(this.degat);
                tempo = 0;
            }
            else{
                this.monstre.setGetAttacked(false);
                tempo++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.monstre = null;
        this.enAttaque = false;
    }

    //Guetters:


    public boolean isEnAttaque() {
        return enAttaque;
    }

    public Thread getThread() {
        return thread;
    }

    public int getRayon() {
        return rayon;
    }

    public int getDegat() {
        return degat;
    }

    public int getEtatWeapon() {
        return etatWeapon;
    }

    public Monstre getMonstre(){
        return this.monstre;
    }

    public Point getPositionMonstre() {
        return positionMonstre;
    }

    public int getNiveau() {
        return niveau;
    }

    //Setters:


    public void setMonstre(Monstre monstre) {
        this.monstre = monstre;
    }

    public void setDegat(int degat) {
        this.degat = degat;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public void setPositionMonstre(Point positionMonstre) {
        this.positionMonstre = positionMonstre;
    }

    public void setNiveau(int niveau) {
        if(niveau == 2){
            this.setHauteur(30);
        }
        else if(niveau == 3){
            this.setHauteur(33);
        }
        this.niveau = niveau;
        for (int i = this.getPosition().x; i < this.getPosition().x + this.getLargeur(); i++) {
            for (int j = this.getPosition().y; j < this.getPosition().y + this.getHauteur(); j++) {
                this.grille.getCases()[i][j].setBatiment(this);
                this.grille.getCases()[i][j].setOccupee(true);
            }
        }
        this.grille.notifyObservers();
    }

    public void setEnAttaque(boolean enAttaque) {
        this.enAttaque = enAttaque;
    }

    public void setRayon(int rayon) {
        this.rayon = rayon;
    }

    public void setEtatWeapon(int etatWeapon) {
        this.etatWeapon = etatWeapon;
    }

}
