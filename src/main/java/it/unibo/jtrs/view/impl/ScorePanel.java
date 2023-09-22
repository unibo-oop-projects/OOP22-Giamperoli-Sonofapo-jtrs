package it.unibo.jtrs.view.impl;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import it.unibo.jtrs.controller.impl.ScoreController;
import it.unibo.jtrs.view.api.View;

/**
 * The class models the score panel. This view must show the current level and score.
 */
public class ScorePanel extends JPanel implements View {

    public static final long serialVersionUID = 4328743;

    private final JLabel score;
    private final JLabel level;
    private final JLabel message;
    private final transient ScoreController controller;

    /**
     * Constructor.
     *
     * @param controller the score controller
     */
    public ScorePanel(final ScoreController controller) {
        this.controller = controller;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        this.setOpaque(false);

        this.level = new JLabel();
        this.score = new JLabel();
        this.message = new JLabel();
        this.add(this.level);
        this.add(this.score);
        this.add(this.message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void redraw() {
        this.level.setText("Livello: " + this.controller.getLevel());
        this.score.setText("Punteggio: " + this.controller.getScore());

        final var text = switch (this.controller.returnRemoved()) {
            case 1 -> "One Line!";
            case 2 -> "Two Lines!!";
            case 3 -> "Three Lines!!!";
            case 4 -> "TETRIS";
            default -> "";
        };
        this.message.setText(text);
    }

}
