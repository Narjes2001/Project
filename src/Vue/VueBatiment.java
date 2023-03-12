package Vue;

import Model.Batiment;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class VueBatiment extends JPanel implements Observer {
    private Batiment batiment;

    public VueBatiment(Batiment batiment){
        this.batiment = batiment;
        this.batiment.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
    }
}
