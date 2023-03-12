package Vue;

import Model.Arbre;
import Model.Grille;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class VueGrille extends JPanel implements Observer {
    private Grille grille;
    private final static int TAILLE = 10;
    private BufferedImage background1;
    private VueCase[][] vueCases;
    private ArrayList<VueJoueur> joueurs;
    private ArrayList<VuePotager> potagers;
    private ArrayList<VueArbre> arbres;
    private ArrayList<VueDefense> defenses;
    private ArrayList<VueMonstre> monstres;

    public VueGrille(Grille grille) {
        this.grille = grille;
        this.grille.addObserver(this);

        try {
            this.background1 = ImageIO.read(getClass().getClassLoader().getResource("Image/background1.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.vueCases = new VueCase[Grille.LARGEUR][Grille.HAUTEUR];
        this.joueurs = new ArrayList<>();
        this.potagers = new ArrayList<>();
        this.arbres = new ArrayList<>();
        this.defenses = new ArrayList<>();
        this.monstres = new ArrayList<>();

        //Initialisation de la vue des cases
        for (int i = 0; i < Grille.LARGEUR; i++) {
            for (int j = 0; j < Grille.HAUTEUR; j++) {
                this.vueCases[i][j] = new VueCase(this.grille.getCases()[i][j]);
            }
        }

        //Initialisation de la vue pour les joueurs
        for(int i = 0; i < grille.getVillageois().size(); i++){
            this.joueurs.add(new VueJoueur(grille.getVillageois().get(i)));
        }

        //Initialisation de la vue pour les potagers
        for(int i = 0; i < grille.getPotagers().size(); i++){
            this.potagers.add(new VuePotager(grille.getPotagers().get(i)));
        }

        //Initialisation de la vue pour les arbres
        for(int i = 0; i < grille.getArbres().size(); i++){
            this.arbres.add(new VueArbre(grille.getArbres().get(i)));
        }

        //Initialisation de la vue pour les défenses
        for(int i = 0; i < grille.getDefenses().size(); i++){
            this.defenses.add(new VueDefense(grille.getDefenses().get(i)));
        }

        //Initialisation de la vue pour les défenses
        for(int i = 0; i < grille.getMonstre().size(); i++){
            this.monstres.add(new VueMonstre(grille.getMonstre().get(i)));
        }

        Dimension dim = new Dimension(TAILLE*Grille.LARGEUR*16, TAILLE*Grille.HAUTEUR*10);
        this.setPreferredSize(dim);
        this.setOpaque(false); //Définir un fond transparant
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Dessiner le fond d'écran
        for(int x = Arbre.LARGEUR; x < Grille.LARGEUR - Arbre.LARGEUR; x += Arbre.LARGEUR) {
            for(int y = Arbre.HAUTEUR; y < Grille.HAUTEUR - Arbre.HAUTEUR; y += Arbre.HAUTEUR) {
                g.drawImage(this.background1, x*VueCase.tailleCase, y*VueCase.tailleCase, this);
            }
        }
        for(int i = 0; i < Grille.LARGEUR; i++){
            for(int j = 0; j < Grille.HAUTEUR; j++){
                this.vueCases[i][j].paintComponent(g);
            }
        }
        for(int i = 0; i < this.joueurs.size(); i++){
            this.joueurs.get(i).paintComponent(g);
        }
        for(int i = 0; i < this.potagers.size(); i++){
            this.potagers.get(i).paintComponent(g);
        }
        for(int i = 0; i < this.arbres.size(); i++){
            this.arbres.get(i).paintComponent(g);
        }
        for(int i = 0; i < this.defenses.size(); i++){
            this.defenses.get(i).paintComponent(g);
        }
        for(int i = 0; i < this.monstres.size(); i++){
            this.monstres.get(i).paintComponent(g);
        }
    }



    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
    }

    //Guetters:


    public ArrayList<VueMonstre> getMonstres() {
        return monstres;
    }

    //Setters:
    public void addMonstres(VueMonstre monstre) {
        this.monstres.add(monstre);
    }

    public void removeMonstre(int monstre){
        this.monstres.remove(monstre);
    }

}






