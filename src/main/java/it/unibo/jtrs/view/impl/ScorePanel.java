package it.unibo.jtrs.view.impl;

import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unibo.jtrs.controller.impl.ScoreController;
import it.unibo.jtrs.view.api.View;

/**
 * The class models the score panel. This view must show the current level and score.
 */
public class ScorePanel extends JPanel implements View {

    private final JLabel score;
    private final JLabel level;
    private final transient ScoreController controller;

    /**
     * Constructor.
     *
     * @param controller the score controller
     */
    public ScorePanel(final ScoreController controller) {
        this.controller = controller;

        this.level = new JLabel();
        this.score = new JLabel();
        this.add(this.level);
        this.add(this.score);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void redraw() {
        this.level.setText("Livello: " + this.controller.getLevel());
        this.score.setText("Punteggio: " + this.controller.getScore());
    }

}
