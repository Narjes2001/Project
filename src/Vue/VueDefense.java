package Vue;

import Model.Defense;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class VueDefense extends JPanel {
    private Defense defense;

    //Déclaration des images du batiment de defense
    private BufferedImage tour1; //Image : la tour d'archer niveau 1
    private BufferedImage tour2; //Image : la tour d'archer niveau 2
    private BufferedImage tour3; //Image : la tour d'archer niveau 3
    private BufferedImage weapon1; //Image : arc en état 1
    private BufferedImage weapon2; //Image : arc en état 2
    private BufferedImage weapon3; //Image : arc en état 3
    private BufferedImage weapon4; //Image : arc en état 4
    private BufferedImage weapon5; //Image : arc en état 5
    private BufferedImage weapon6; //Image : arc en état 6


    public VueDefense(Defense defense){
        this.defense = defense;
        //Initialisation des images du batiment de defense
        try {
            this.tour1 = ImageIO.read(getClass().getClassLoader().getResource("Image/Weapon/Tower1.png"));
            this.tour2 = ImageIO.read(getClass().getClassLoader().getResource("Image/Weapon/Tower2.png"));
            this.tour3 = ImageIO.read(getClass().getClassLoader().getResource("Image/Weapon/Tower3.png"));
            this.weapon1 = ImageIO.read(getClass().getClassLoader().getResource("Image/Weapon/Weapon1.png"));
            this.weapon2 = ImageIO.read(getClass().getClassLoader().getResource("Image/Weapon/Weapon2.png"));
            this.weapon3 = ImageIO.read(getClass().getClassLoader().getResource("Image/Weapon/Weapon3.png"));
            this.weapon4 = ImageIO.read(getClass().getClassLoader().getResource("Image/Weapon/Weapon4.png"));
            this.weapon5 = ImageIO.read(getClass().getClassLoader().getResource("Image/Weapon/Weapon5.png"));
            this.weapon6 = ImageIO.read(getClass().getClassLoader().getResource("Image/Weapon/Weapon6.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //Calculter l'angle entre l'arc et la cible
    private static double getAngle(double x1, double y1, double x2, double y2) {
        double angle = Math.atan2(y2 - y1, x2 - x1);
        return angle;
    }


    //Faire la rotation
    public static void drawRotatedImage(Graphics2D g2d, Image image, double centerX, double centerY, double x2, double y2) {
        int imageX = (int)(centerX + image.getWidth(null) / 2.0);
        int imageY = (int)(centerY + image.getHeight(null) / 2.0);
        double angle = getAngle(imageX, imageY, x2, y2);
        g2d.rotate(angle, imageX, imageY);
        g2d.scale(-1, 1);
;       g2d.drawImage(image, -(int) centerX - image.getWidth(null), (int) centerY, null);
        g2d.scale(-1, 1);
        g2d.rotate(-angle, imageX, imageY);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        if(!this.defense.isEnAttaque()) {
            if (this.defense.getNiveau() == 1) {
                g.drawImage(this.tour1, this.defense.getPosition().x * VueCase.tailleCase, this.defense.getPosition().y * VueCase.tailleCase, null);
                if (this.defense.getEtatWeapon() == 1) {
                    g.drawImage(this.weapon1, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour1.getWidth() / 2) - (this.weapon1.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour1.getHeight() / 4) - (this.weapon1.getHeight() / 2), null);
                } else if (this.defense.getEtatWeapon() == 2) {
                    g.drawImage(this.weapon2, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour1.getWidth() / 2) - (this.weapon2.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour1.getHeight() / 4) - (this.weapon2.getHeight() / 2), null);
                } else if (this.defense.getEtatWeapon() == 3) {
                    g.drawImage(this.weapon3, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour1.getWidth() / 2) - (this.weapon3.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour1.getHeight() / 4) - (this.weapon3.getHeight() / 2), null);
                } else if (this.defense.getEtatWeapon() == 4) {
                    g.drawImage(this.weapon4, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour1.getWidth() / 2) - (this.weapon4.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour1.getHeight() / 4) - (this.weapon4.getHeight() / 2), null);
                } else if (this.defense.getEtatWeapon() == 5) {
                    g.drawImage(this.weapon5, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour1.getWidth() / 2) - (this.weapon5.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour1.getHeight() / 4) - (this.weapon5.getHeight() / 2), null);
                } else if (this.defense.getEtatWeapon() == 6) {
                    g.drawImage(this.weapon6, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour1.getWidth() / 2) - (this.weapon6.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour1.getHeight() / 4) - (this.weapon6.getHeight() / 2), null);
                }
            } else if (this.defense.getNiveau() == 2) {
                g.drawImage(this.tour2, this.defense.getPosition().x * VueCase.tailleCase, this.defense.getPosition().y * VueCase.tailleCase, null);
                if (this.defense.getEtatWeapon() == 1) {
                    g.drawImage(this.weapon1, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour2.getWidth() / 2) - (this.weapon1.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour2.getHeight() / 4) - (this.weapon1.getHeight() / 2), null);
                } else if (this.defense.getEtatWeapon() == 2) {
                    g.drawImage(this.weapon2, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour2.getWidth() / 2) - (this.weapon2.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour2.getHeight() / 4) - (this.weapon2.getHeight() / 2), null);
                } else if (this.defense.getEtatWeapon() == 3) {
                    g.drawImage(this.weapon3, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour2.getWidth() / 2) - (this.weapon3.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour2.getHeight() / 4) - (this.weapon3.getHeight() / 2), null);
                } else if (this.defense.getEtatWeapon() == 4) {
                    g.drawImage(this.weapon4, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour2.getWidth() / 2) - (this.weapon4.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour2.getHeight() / 4) - (this.weapon4.getHeight() / 2), null);
                } else if (this.defense.getEtatWeapon() == 5) {
                    g.drawImage(this.weapon5, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour2.getWidth() / 2) - (this.weapon5.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour2.getHeight() / 4) - (this.weapon5.getHeight() / 2), null);
                } else if (this.defense.getEtatWeapon() == 6) {
                    g.drawImage(this.weapon6, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour2.getWidth() / 2) - (this.weapon6.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour2.getHeight() / 4) - (this.weapon6.getHeight() / 2), null);
                }
            } else if (this.defense.getNiveau() == 3) {
                g.drawImage(this.tour3, this.defense.getPosition().x * VueCase.tailleCase, this.defense.getPosition().y * VueCase.tailleCase, null);
                if (this.defense.getEtatWeapon() == 1) {
                    g.drawImage(this.weapon1, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour3.getWidth() / 2) - (this.weapon1.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour3.getHeight() / 4) - (this.weapon1.getHeight() / 2), null);
                } else if (this.defense.getEtatWeapon() == 2) {
                    g.drawImage(this.weapon2, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour3.getWidth() / 2) - (this.weapon2.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour3.getHeight() / 4) - (this.weapon2.getHeight() / 2), null);
                } else if (this.defense.getEtatWeapon() == 3) {
                    g.drawImage(this.weapon3, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour3.getWidth() / 2) - (this.weapon3.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour3.getHeight() / 4) - (this.weapon3.getHeight() / 2), null);
                } else if (this.defense.getEtatWeapon() == 4) {
                    g.drawImage(this.weapon4, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour3.getWidth() / 2) - (this.weapon4.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour3.getHeight() / 4) - (this.weapon4.getHeight() / 2), null);
                } else if (this.defense.getEtatWeapon() == 5) {
                    g.drawImage(this.weapon5, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour3.getWidth() / 2) - (this.weapon5.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour3.getHeight() / 4) - (this.weapon5.getHeight() / 2), null);
                } else if (this.defense.getEtatWeapon() == 6) {
                    g.drawImage(this.weapon6, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour3.getWidth() / 2) - (this.weapon6.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour3.getHeight() / 4) - (this.weapon6.getHeight() / 2), null);
                }
            }
        }
        else{
            int x = this.defense.getPositionMonstre().x;
            int y = this.defense.getPositionMonstre().y;
            Graphics2D g2d = (Graphics2D) g;
            if (this.defense.getNiveau() == 1) {
                g.drawImage(this.tour1, this.defense.getPosition().x * VueCase.tailleCase, this.defense.getPosition().y * VueCase.tailleCase, null);
                if (this.defense.getEtatWeapon() == 1) {
                    drawRotatedImage(g2d, this.weapon1, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour1.getWidth() / 2) - (this.weapon1.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour1.getHeight() / 4) - (this.weapon1.getHeight() / 2), x, y);
                } else if (this.defense.getEtatWeapon() == 2) {
                    drawRotatedImage(g2d, this.weapon2, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour1.getWidth() / 2) - (this.weapon2.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour1.getHeight() / 4) - (this.weapon2.getHeight() / 2), x, y);
                } else if (this.defense.getEtatWeapon() == 3) {
                    drawRotatedImage(g2d, this.weapon3, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour1.getWidth() / 2) - (this.weapon3.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour1.getHeight() / 4) - (this.weapon3.getHeight() / 2), x, y);
                } else if (this.defense.getEtatWeapon() == 4) {
                    drawRotatedImage(g2d, this.weapon4, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour1.getWidth() / 2) - (this.weapon4.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour1.getHeight() / 4) - (this.weapon4.getHeight() / 2), x, y);
                } else if (this.defense.getEtatWeapon() == 5) {
                    drawRotatedImage(g2d, this.weapon5, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour1.getWidth() / 2) - (this.weapon5.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour1.getHeight() / 4) - (this.weapon5.getHeight() / 2), x, y);
                } else if (this.defense.getEtatWeapon() == 6) {
                    drawRotatedImage(g2d, this.weapon6, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour1.getWidth() / 2) - (this.weapon6.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour1.getHeight() / 4) - (this.weapon6.getHeight() / 2), x, y);
                }
            } else if (this.defense.getNiveau() == 2) {
                g.drawImage(this.tour2, this.defense.getPosition().x * VueCase.tailleCase, this.defense.getPosition().y * VueCase.tailleCase, null);
                if (this.defense.getEtatWeapon() == 1) {
                    drawRotatedImage(g2d, this.weapon1, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour2.getWidth() / 2) - (this.weapon1.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour2.getHeight() / 4) - (this.weapon1.getHeight() / 2), x, y);
                } else if (this.defense.getEtatWeapon() == 2) {
                    drawRotatedImage(g2d, this.weapon2, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour2.getWidth() / 2) - (this.weapon2.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour2.getHeight() / 4) - (this.weapon2.getHeight() / 2), x, y);
                } else if (this.defense.getEtatWeapon() == 3) {
                    drawRotatedImage(g2d, this.weapon3, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour2.getWidth() / 2) - (this.weapon3.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour2.getHeight() / 4) - (this.weapon3.getHeight() / 2), x, y);
                } else if (this.defense.getEtatWeapon() == 4) {
                    drawRotatedImage(g2d, this.weapon4, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour2.getWidth() / 2) - (this.weapon4.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour2.getHeight() / 4) - (this.weapon4.getHeight() / 2), x, y);
                } else if (this.defense.getEtatWeapon() == 5) {
                    drawRotatedImage(g2d, this.weapon5, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour2.getWidth() / 2) - (this.weapon5.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour2.getHeight() / 4) - (this.weapon5.getHeight() / 2), x, y);
                } else if (this.defense.getEtatWeapon() == 6) {
                    drawRotatedImage(g2d, this.weapon6, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour2.getWidth() / 2) - (this.weapon6.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour2.getHeight() / 4) - (this.weapon6.getHeight() / 2), x, y);
                }
            } else if (this.defense.getNiveau() == 3) {
                g.drawImage(this.tour3, this.defense.getPosition().x * VueCase.tailleCase, this.defense.getPosition().y * VueCase.tailleCase, null);
                if (this.defense.getEtatWeapon() == 1) {
                    drawRotatedImage(g2d, this.weapon1, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour3.getWidth() / 2) - (this.weapon1.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour3.getHeight() / 4) - (this.weapon1.getHeight() / 2), x, y);
                } else if (this.defense.getEtatWeapon() == 2) {
                    drawRotatedImage(g2d, this.weapon2, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour3.getWidth() / 2) - (this.weapon2.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour3.getHeight() / 4) - (this.weapon2.getHeight() / 2), x, y);
                } else if (this.defense.getEtatWeapon() == 3) {
                    drawRotatedImage(g2d, this.weapon3, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour3.getWidth() / 2) - (this.weapon3.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour3.getHeight() / 4) - (this.weapon3.getHeight() / 2), x, y);
                } else if (this.defense.getEtatWeapon() == 4) {
                    drawRotatedImage(g2d, this.weapon4, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour3.getWidth() / 2) - (this.weapon4.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour3.getHeight() / 4) - (this.weapon4.getHeight() / 2), x, y);
                } else if (this.defense.getEtatWeapon() == 5) {
                    drawRotatedImage(g2d, this.weapon5, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour3.getWidth() / 2) - (this.weapon5.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour3.getHeight() / 4) - (this.weapon5.getHeight() / 2), x, y);
                } else if (this.defense.getEtatWeapon() == 6) {
                    drawRotatedImage(g2d, this.weapon6, (this.defense.getPosition().x * VueCase.tailleCase) + (this.tour3.getWidth() / 2) - (this.weapon6.getWidth() / 2), (this.defense.getPosition().y * VueCase.tailleCase) + (this.tour3.getHeight() / 4) - (this.weapon6.getHeight() / 2), x, y);
                }
            }
        }
    }
}
