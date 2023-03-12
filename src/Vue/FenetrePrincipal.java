package Vue;

import javax.swing.*;
import java.awt.*;
import Controler.Control;
import Model.Grille;

public class FenetrePrincipal extends JFrame {
    public JFrame fenetre; //Déclaration de la fenêtre d'affichage
    public Control control; //Déclaration du control
    private VueCommande commande;
    public FenetrePrincipal(){
        this.fenetre = new JFrame("Projet_PCII");
        this.control = new Control();
        this.fenetre.setPreferredSize(new Dimension(Affichage.FENETRE_LARGEUR*2, (int) (Affichage.FENETRE_HAUTEUR*(1.2))));
        this.fenetre.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        this.fenetre.requestFocus();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        this.fenetre.add(this.control.getAffichage(),c);

        this.commande = new VueCommande(this.control);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        this.fenetre.add(this.commande,c);

        this.fenetre.pack();
        this.fenetre.setVisible(true);
        this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


}
