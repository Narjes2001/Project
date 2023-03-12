package Vue;

import Model.Grille;
import Controler.Control;

import javax.swing.*;
import java.awt.*;

public class Affichage extends JPanel {
    public static final int FENETRE_HAUTEUR = 520;
    public static final int FENETRE_LARGEUR = 520;
    private VueGrille grille;

    public Affichage(Grille grille){
        this.grille = new VueGrille(grille);
        this.setPreferredSize(new Dimension(FENETRE_LARGEUR, FENETRE_HAUTEUR));
        this.setLayout(new BorderLayout());
        this.add(this.grille, BorderLayout.CENTER);
        this.setBackground(Color.WHITE);
        this.setFocusable(true);
    }

    //Guetter:
    public VueGrille getGrille() {
        return grille;
    }
}
