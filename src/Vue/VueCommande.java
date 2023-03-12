package Vue;

import javax.swing.*;
import Model.Grille;
import Controler.Control;

import java.awt.*;

public class VueCommande extends JPanel {
    Control control;

    public VueCommande(Control control){
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        this.setSize(400,100);

        JButton planter = new JButton("Planter");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        this.add(planter, c);

        JButton recolter = new JButton("Récolter");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        this.add(recolter, c);

        JButton attaquer = new JButton("Attaquer");
        c.gridx = 2;
        c.gridy = 0;
        this.add(attaquer,c);

        /*JButton reparer = new JButton("Réparer");
        c.gridx = 0;
        c.gridy = 1;
        this.add(reparer,c);

        JButton construire = new JButton("Construire");
        c.gridx = 8;
        c.gridy = 0;
        this.add(construire,c);

        JButton manger = new JButton("Manger");
        c.gridx = 4;
        c.gridy = 0;
        this.add(manger,c);

        JButton repos = new JButton("Repos");
        c.gridx = 4;
        c.gridy = 1;
        this.add(repos,c);*/

        this.control = control;
        planter.addActionListener(this.control);
        planter.addKeyListener(this.control);
        recolter.addActionListener(this.control);
        recolter.addKeyListener(this.control);
        attaquer.addActionListener(this.control);
        attaquer.addKeyListener(this.control);
        /*reparer.addActionListener(this.control);
        construire.addActionListener(this.control);
        manger.addActionListener(this.control);
        repos.addActionListener(this.control);*/
    }
}
