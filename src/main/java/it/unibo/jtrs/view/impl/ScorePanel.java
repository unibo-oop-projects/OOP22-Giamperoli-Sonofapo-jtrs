package it.unibo.jtrs.view.impl;

import javax.swing.JLabel;

import it.unibo.jtrs.controller.api.Controller;
import it.unibo.jtrs.controller.impl.ScoreController;
import it.unibo.jtrs.view.api.SubPanel;

public class ScorePanel extends SubPanel {

    private final JLabel score = new JLabel();
    private final JLabel level = new JLabel();

    public ScorePanel(final Controller controller) {
        super(controller);

        this.add(this.level);
        this.add(this.score);
    }

    @Override
    public void update() {
        var res = ((ScoreController) this.controller).getStatus();
        this.level.setText("Livello: " + res.getX());
        this.score.setText("Punteggio: " + res.getY());
    }

}
