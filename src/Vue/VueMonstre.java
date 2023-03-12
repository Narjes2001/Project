package Vue;

import Model.Entity.Monstre;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class VueMonstre extends JPanel {
    private Monstre monstre;
    //Déclaration des images du monstre
    private BufferedImage slimeVert1; //Image : monstre vert état 1
    private BufferedImage slimeVert2; //Image : monstre vert état 2
    private BufferedImage slimeRouge1; //Image : monstre rouge état 1
    private BufferedImage slimeRouge2; //Image : monstre rouge état 2
    private BufferedImage slimeJaune1; //Image : monstre rouge état 1
    private BufferedImage slimeJaune2; //Image : monstre rouge état 2



    public VueMonstre(Monstre monstre){
        this.monstre = monstre;
        try {
            //Initialisation des images du monstre
            this.slimeVert1 = ImageIO.read(getClass().getClassLoader().getResource("Image/Monstre/greenslime1.png"));
            this.slimeVert2 = ImageIO.read(getClass().getClassLoader().getResource("Image/Monstre/greenslime2.png"));
            this.slimeRouge1 = ImageIO.read(getClass().getClassLoader().getResource("Image/Monstre/redslime1.png"));
            this.slimeRouge2 = ImageIO.read(getClass().getClassLoader().getResource("Image/Monstre/redslime2.png"));
            this.slimeJaune1 = ImageIO.read(getClass().getClassLoader().getResource("Image/Monstre/slimeYellow1.png"));
            this.slimeJaune2 = ImageIO.read(getClass().getClassLoader().getResource("Image/Monstre/slimeYellow2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Paint l'arbre
    public void paintComponent(Graphics g) {
        if(!this.monstre.subitAttaque()){
            if(this.monstre.isSelected()){
                if(this.monstre.getEtatWalk() == 1){
                    g.drawImage(this.slimeJaune1, this.monstre.getPosition().x*VueCase.tailleCase, this.monstre.getPosition().y*VueCase.tailleCase, null);
                }
                else if(this.monstre.getEtatWalk() == 2){
                    g.drawImage(this.slimeJaune2, this.monstre.getPosition().x*VueCase.tailleCase, this.monstre.getPosition().y*VueCase.tailleCase, null);
                }

            }else{
                if(this.monstre.getEtatWalk() == 1){
                    g.drawImage(this.slimeVert1, this.monstre.getPosition().x*VueCase.tailleCase, this.monstre.getPosition().y*VueCase.tailleCase, null);
                }
                else if(this.monstre.getEtatWalk() == 2){
                    g.drawImage(this.slimeVert2, this.monstre.getPosition().x*VueCase.tailleCase, this.monstre.getPosition().y*VueCase.tailleCase, null);
                }
            }
        }
        else{
            if(this.monstre.getEtatWalk() == 1){
                g.drawImage(this.slimeRouge1, this.monstre.getPosition().x*VueCase.tailleCase, this.monstre.getPosition().y*VueCase.tailleCase, null);
            }
            else if(this.monstre.getEtatWalk() == 2){
                g.drawImage(this.slimeRouge2, this.monstre.getPosition().x*VueCase.tailleCase, this.monstre.getPosition().y*VueCase.tailleCase, null);
            }
        }
    }

    public Monstre getMonstre() {
        return monstre;
    }
}
