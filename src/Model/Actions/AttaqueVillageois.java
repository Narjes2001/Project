package Model.Actions;

import Model.Entity.Monstre;
import Model.Entity.Villageois;
import Utils.ActionVillageois;

public class AttaqueVillageois implements Runnable{
    private Monstre monstre;
    private int etatAttaque;
    private Villageois villageois;
    private Thread thread;

    public AttaqueVillageois(Villageois villageois, Monstre monstre){
        this.etatAttaque = 1;
        this.villageois = villageois;
        this.monstre = monstre;
        this.villageois.setEtatAttack(this.etatAttaque);
    }
    @Override
    public void run() {
        int tempo = 0;
        while(!this.monstre.estMort()){
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            if(tempo == 1){
                if(this.etatAttaque == 4){
                    this.etatAttaque = 1;
                }
                else{
                    this.etatAttaque++;
                }
                this.monstre.subitDegat(this.villageois.getDegat());
                tempo = 0;
                this.villageois.setEtatAttack(this.etatAttaque);
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
        //Remettre le villageois en état normal
        this.villageois.setWalkAttack(ActionVillageois.normal);
        this.villageois.setActionAFaire(false);
    }
    //Guetter:
    public Thread getThread() {
        return thread;
    }

    //Setter:


    public void setEtatAttaque(int etatAttaque) {
        this.etatAttaque = etatAttaque;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }
}
