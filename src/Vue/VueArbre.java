package Vue;

import Model.Arbre;
import Model.Entity.Joueur;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class VueArbre extends JPanel {
    private Arbre arbre;
    //Déclaration des images des arbres
    private BufferedImage arbre3; //Image 1 : arbre3
    private BufferedImage arbre4; //Image 1 : arbre4



    public VueArbre(Arbre arbre){
        this.arbre = arbre;
        try {
            //Initialisation des images des arbres
            this.arbre3 = ImageIO.read(getClass().getClassLoader().getResource("Image/Arbre/arbre3.png"));
            this.arbre4 = ImageIO.read(getClass().getClassLoader().getResource("Image/Arbre/arbre4.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Paint l'arbre
    public void paintComponent(Graphics g) {
        if(this.arbre.getNB()){
            g.drawImage(this.arbre3, this.arbre.getPosition().x*VueCase.tailleCase, this.arbre.getPosition().y*VueCase.tailleCase, null);
        }
        else{
            g.drawImage(this.arbre4, this.arbre.getPosition().x*VueCase.tailleCase, this.arbre.getPosition().y*VueCase.tailleCase, null);
        }
    }
}
