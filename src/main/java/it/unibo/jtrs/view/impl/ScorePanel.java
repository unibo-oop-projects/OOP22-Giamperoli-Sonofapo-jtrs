package it.unibo.jtrs.view.impl;

import java.awt.Color;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import it.unibo.jtrs.controller.impl.ScoreController;
import it.unibo.jtrs.view.api.View;
import it.unibo.jtrs.view.custom.Label;

/**
 * The class models the score panel. This view must show the current level and score.
 */
public class ScorePanel extends JPanel implements View {

    public static final long serialVersionUID = 4328743;

    private static final String FONT = "Tetris.ttf";
    private static final float FONT_SIZE = 40f;
    private static final int INTERLINE = 20;

    private final Label level;
    private final Label score;
    private final Label message;
    private final transient ScoreController controller;

    /**
     * Constructor.
     *
     * @param controller the score controller
     */
    public ScorePanel(final ScoreController controller) {
        this.controller = controller;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setOpaque(false);

        final var levelTxt = new Label("LEVEL", FONT, FONT_SIZE, Color.WHITE);
        levelTxt.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        this.level = new Label(String.valueOf(this.controller.getLevel()), FONT, FONT_SIZE, Color.WHITE);
        this.level.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        final var scoreTxt = new Label("SCORE", FONT, FONT_SIZE, Color.WHITE);
        scoreTxt.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        this.score = new Label(String.valueOf(this.controller.getScore()), FONT, FONT_SIZE, Color.WHITE);
        this.score.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        this.message = new Label("", FONT, FONT_SIZE, Color.WHITE);
        this.message.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        this.add(levelTxt);
        this.add(this.level);
        this.add(Box.createVerticalStrut(INTERLINE));

        this.add(scoreTxt);
        this.add(this.score);
        this.add(Box.createVerticalStrut(INTERLINE));

        this.add(this.message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void redraw() {
        this.level.setText(String.valueOf(this.controller.getLevel()));
        this.score.setText(String.valueOf(this.controller.getScore()));

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
