package Model;

import java.util.Objects;

public class Quete {
    /**attributs**/
    private String nom;
    private String description;
    private Ressources ressources;
    private String typeRecomp;
    private int recompense;
    private String etat;
    /**constructeurs**/
    public Quete(String n, String descr, Ressources ress, String typeRec, int rec){
        this.nom = n;
        this.description = descr;
        this.ressources = ress;
        this.typeRecomp = typeRec;
        this.recompense = rec;
        this.etat = "faire";
    }
    /**ajouter la récompense a nos ressources globales**/
    public void ajouteRecompense(){
        ressources.ajouteRessources(this.typeRecomp, recompense);
    }
    /**si la quete est finie alors ajoute recompense**/
    public void estFini(){
        if(Objects.equals(this.etat, "fini")){
            ajouteRecompense();
        }
    }
    /**setteurs**/
    public void setEtat(String etat) {
        this.etat = etat;
    }
    /**getteurs**/
    public String getEtat() {
        return etat;
    }
    public String getNom() {
        return nom;
    }
}
