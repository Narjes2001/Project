package Model;

import java.util.Objects;

public class Ressources {
    /**attributs**/
    private int or;
    private int bois;
    private int pierre;
    private int fleurs;
    /**constructeurs**/
    public Ressources(){
        this.or = 0;
        this.bois = 0;
        this.pierre = 0;
        this.fleurs = 0;
    }
    /**on veut modifier le nombre de ressources**/
    public void ajouteRessources(String type, int quantite){
        if(Objects.equals(type, "or")){
            this.or += quantite;
        }else if(Objects.equals(type, "bois")){
            this.bois += quantite;
        }else if(Objects.equals(type, "pierre")){
            this.pierre += quantite;
        }else if(Objects.equals(type, "fleurs")){
            this.fleurs += quantite;
        }
    }
    public void retireRessources(String type, int quantite){
        if(Objects.equals(type, "or")){
            this.or -= quantite;
        }else if(Objects.equals(type, "bois")){
            this.bois -= quantite;
        }else if(Objects.equals(type, "pierre")){
            this.pierre -= quantite;
        }else if(Objects.equals(type, "fleurs")){
            this.fleurs -= quantite;
        }
    }
    /**getteurs**/
    public int getOr() {
        return or;
    }
    public int getBois() {
        return bois;
    }
    public int getFleurs() {
        return fleurs;
    }
    public int getPierre() {
        return pierre;
    }
}
