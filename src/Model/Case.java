package Model;

import Model.Entity.Monstre;
import Model.Entity.Villageois;
import Model.Potager.Potager;

import java.util.Observable;

public class Case extends Observable {
    private int x; //Coordonnée en abscisse
    private int y; //Coordonnée en ordonnée
    private boolean occupee;
    private Batiment batiment;
    private Potager potager;
    private Villageois villageois;
    private Monstre monstre;

    //Attributs pour A*
    private Case pere;
    private int cout;
    private int heuristique;

    //Constructeur :
    public Case(int x, int y){
        this.x = x;
        this.y = y;
        this.occupee = false;
        this.potager = null;
        this.villageois = null;
        this.batiment = null;
        this.monstre = null;

        this.pere = null;
        this.cout = 0;
        this.heuristique = 0;
    }

    //Connaitre le type de batiment dans la case
    public String batimentType(){
        if(this.batiment != null){
            return this.batiment.getNom();
        }
        else{
            return null;
        }
    }

    //Savoir si un villageois est dans la case
    public boolean isVillageois() {
        return this.villageois != null && this.villageois.getFonction() =="Villageois";
    }

    public boolean isMonstre() {
        return this.monstre != null && this.monstre.getFonction() =="Monstre";
    }


    //Guetters :

    public Case getPere() {
        return this.pere;
    }
    public int getCout() {
        return this.cout;
    }

    public int getHeuristique() {
        return this.heuristique;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean isOccupee() {
        return this.occupee;
    }

    public boolean isBatiment() {
        return this.batiment != null;
    }

    public Villageois getVillageois() {
        return villageois;
    }

    //Setters:
    public void setOccupee(boolean occupee) {
        this.occupee = occupee;
    }

    public void setBatiment(Batiment batiment) {
        this.batiment = batiment;
    }

    public void setPotager(Potager potager) {
        this.potager = potager;
    }

    public void setHeuristique(int heuristique) {
        this.heuristique = heuristique;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public void setPere(Case pere) {
        this.pere = pere;
    }


    public void setVillageois(Villageois villageois) {
        if(villageois == null){
            this.villageois = null;
            this.occupee = false;
        }
        else{
            this.villageois = villageois;
            this.occupee = true;
        }
        this.notifyObservers();
    }
    public void setMonstres(Monstre monstre) {
        if(monstre == null){
            this.monstre = null;
            this.occupee = false;
        }
        else{
            this.monstre = monstre;
            this.occupee = true;
        }
        this.notifyObservers();
    }



}
