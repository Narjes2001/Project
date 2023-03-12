package Vue;

import Model.Potager.Potager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class VuePotager extends JPanel {
    private Potager potager;

    //Déclaration des images du portager en mode normal
    private BufferedImage potager0; //Image : potager à l'état 0
    private BufferedImage potager1; //Image : potager à l'état 1
    private BufferedImage potager2; //Image : potager à l'état 2
    private BufferedImage potager3; //Image : potager à l'état 3
    private BufferedImage potager4; //Image : potager à l'état 4
    private BufferedImage potager5; //Image : potager à l'état 5
    private BufferedImage potager6; //Image : potager à l'état 6
    private BufferedImage potager7; //Image : potager à l'état 7
    private BufferedImage potager8; //Image : potager à l'état 8
    private BufferedImage potager9; //Image : potager à l'état 9
    private BufferedImage potager10; //Image : potager à l'état 10
    private BufferedImage potager11; //Image : potager à l'état 11
    private BufferedImage potager12; //Image : potager à l'état 12
    private BufferedImage potager13; //Image : potager à l'état 13
    private BufferedImage potager14; //Image : potager à l'état 14
    private BufferedImage potager15; //Image : potager à l'état 15

    //Déclaration des images du portager en mode selectionne
    private BufferedImage potager0S; //Image : potager à l'état 0
    private BufferedImage potager1S; //Image : potager à l'état 1
    private BufferedImage potager2S; //Image : potager à l'état 2
    private BufferedImage potager3S; //Image : potager à l'état 3
    private BufferedImage potager4S; //Image : potager à l'état 4
    private BufferedImage potager5S; //Image : potager à l'état 5
    private BufferedImage potager6S; //Image : potager à l'état 6
    private BufferedImage potager7S; //Image : potager à l'état 7
    private BufferedImage potager8S; //Image : potager à l'état 8
    private BufferedImage potager9S; //Image : potager à l'état 9
    private BufferedImage potager10S; //Image : potager à l'état 10
    private BufferedImage potager11S; //Image : potager à l'état 11
    private BufferedImage potager12S; //Image : potager à l'état 12
    private BufferedImage potager13S; //Image : potager à l'état 13
    private BufferedImage potager14S; //Image : potager à l'état 14
    private BufferedImage potager15S; //Image : potager à l'état 15

    public VuePotager(Potager potager){
        this.potager = potager;
        try {
            //Initialisation des images du potager état : normal
            this.potager0 = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/normal/t0.png"));
            this.potager1 = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/normal/t1.png"));
            this.potager2 = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/normal/t2.png"));
            this.potager3 = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/normal/t3.png"));
            this.potager4 = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/normal/t4.png"));
            this.potager5 = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/normal/t5.png"));
            this.potager6 = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/normal/t6.png"));
            this.potager7 = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/normal/t7.png"));
            this.potager8 = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/normal/t8.png"));
            this.potager9 = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/normal/t9.png"));
            this.potager10 = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/normal/t10.png"));
            this.potager11 = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/normal/t11.png"));
            this.potager12 = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/normal/t12.png"));
            this.potager13 = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/normal/t13.png"));
            this.potager14 = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/normal/t14.png"));
            this.potager15 = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/normal/t15.png"));

            //Initialisation des images du potager état : selectionné
            this.potager0S = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/Selectionne/t0S.png"));
            this.potager1S = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/Selectionne/t1S.png"));
            this.potager2S = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/Selectionne/t2S.png"));
            this.potager3S = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/Selectionne/t3S.png"));
            this.potager4S = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/Selectionne/t4S.png"));
            this.potager5S = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/Selectionne/t5S.png"));
            this.potager6S = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/Selectionne/t6S.png"));
            this.potager7S = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/Selectionne/t7S.png"));
            this.potager8S = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/Selectionne/t8S.png"));
            this.potager9S = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/Selectionne/t9S.png"));
            this.potager10S = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/Selectionne/t10S.png"));
            this.potager11S = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/Selectionne/t11S.png"));
            this.potager12S = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/Selectionne/t12S.png"));
            this.potager13S = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/Selectionne/t13S.png"));
            this.potager14S = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/Selectionne/t14S.png"));
            this.potager15S = ImageIO.read(getClass().getClassLoader().getResource("Image/PlanterCarotte/Selectionne/t15S.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {
        if(this.potager.isSelected()){
            if (this.potager.getEtatPotager() == 0) {
                g.drawImage(this.potager0S, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            } else if (this.potager.getEtatPotager() == 1) {
                g.drawImage(this.potager1S, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            } else if (this.potager.getEtatPotager() == 2) {
                g.drawImage(this.potager2S, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            } else if (this.potager.getEtatPotager() == 3) {
                g.drawImage(this.potager3S, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            } else if (this.potager.getEtatPotager() == 4) {
                g.drawImage(this.potager4S, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            } else if (this.potager.getEtatPotager() == 5) {
                g.drawImage(this.potager5S, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            } else if (this.potager.getEtatPotager() == 6) {
                g.drawImage(this.potager6S, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            } else if (this.potager.getEtatPotager() == 7) {
                g.drawImage(this.potager7S, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            } else if (this.potager.getEtatPotager() == 8) {
                g.drawImage(this.potager8S, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            } else if (this.potager.getEtatPotager() == 9) {
                g.drawImage(this.potager9S, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            } else if (this.potager.getEtatPotager() == 10) {
                g.drawImage(this.potager10S, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            } else if (this.potager.getEtatPotager() == 11) {
                g.drawImage(this.potager11S, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            } else if (this.potager.getEtatPotager() == 12) {
                g.drawImage(this.potager12S, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            } else if (this.potager.getEtatPotager() == 13) {
                g.drawImage(this.potager13S, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            } else if (this.potager.getEtatPotager() == 14) {
                g.drawImage(this.potager14S, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            } else if (this.potager.getEtatPotager() == 15) {
                g.drawImage(this.potager15S, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            }
        }
        else {
            if (this.potager.getEtatPotager() == 0) {
                g.drawImage(this.potager0, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            } else if (this.potager.getEtatPotager() == 1) {
                g.drawImage(this.potager1, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            } else if (this.potager.getEtatPotager() == 2) {
                g.drawImage(this.potager2, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            } else if (this.potager.getEtatPotager() == 3) {
                g.drawImage(this.potager3, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            } else if (this.potager.getEtatPotager() == 4) {
                g.drawImage(this.potager4, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            } else if (this.potager.getEtatPotager() == 5) {
                g.drawImage(this.potager5, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            } else if (this.potager.getEtatPotager() == 6) {
                g.drawImage(this.potager6, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            } else if (this.potager.getEtatPotager() == 7) {
                g.drawImage(this.potager7, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            } else if (this.potager.getEtatPotager() == 8) {
                g.drawImage(this.potager8, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            } else if (this.potager.getEtatPotager() == 9) {
                g.drawImage(this.potager9, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            } else if (this.potager.getEtatPotager() == 10) {
                g.drawImage(this.potager10, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            } else if (this.potager.getEtatPotager() == 11) {
                g.drawImage(this.potager11, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            } else if (this.potager.getEtatPotager() == 12) {
                g.drawImage(this.potager12, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            } else if (this.potager.getEtatPotager() == 13) {
                g.drawImage(this.potager13, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            } else if (this.potager.getEtatPotager() == 14) {
                g.drawImage(this.potager14, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            } else if (this.potager.getEtatPotager() == 15) {
                g.drawImage(this.potager15, this.potager.getPosition().x * VueCase.tailleCase, this.potager.getPosition().y * VueCase.tailleCase, null);
            }
        }
    }








}
