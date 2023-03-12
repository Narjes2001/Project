package Vue;

import Model.Case;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class VueCase extends JPanel implements Observer {
    private JPanel caseJoueur;
    private Case caseID;
    public static final int tailleCase = 2;

    public VueCase(Case caseID) {
        this.caseID = caseID;
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        this.caseID.addObserver(this);
        JPanel panelBas = new JPanel(new GridLayout());
        this.add(panelBas, BorderLayout.SOUTH);
        this.caseJoueur = new JPanel();
        this.setPreferredSize(new Dimension(tailleCase, tailleCase));
    }

    public void paintComponent(Graphics g) {
        super.paint(g);
        if(this.caseID.isOccupee()){
            if(this.caseID.isMonstre()){
                //g.setColor(Color.RED);
            }
            else if(this.caseID.isBatiment()){
                if(this.caseID.batimentType() == "HotelVille"){
                    g.setColor(Color.ORANGE);
                }
                else if(this.caseID.batimentType() == "Cabane"){
                    g.setColor(Color.YELLOW);
                }
                else{
                    //g.setColor(Color.MAGENTA);
                }
            }
            else{
                //g.setColor(Color.BLUE);
            }
        }
        else{
            //Couleur transparante
            Color c = new Color(0,0,1,1);
            g.setColor(c);
        }
        g.fillRect(this.caseID.getX()*tailleCase, this.caseID.getY()*tailleCase , tailleCase, tailleCase);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
    }
}
