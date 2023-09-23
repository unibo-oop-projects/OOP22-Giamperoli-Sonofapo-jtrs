package it.unibo.jtrs.view.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

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

        this.level = this.customLabel("" + this.controller.getLevel());
        this.score = this.customLabel("" + this.controller.getScore());
        this.message = this.customLabel("" );

        this.add(this.customLabel("LEVEL"));
        this.add(this.level);

        this.add(this.customLabel("SCORE"));
        this.add(this.score);

        this.add(this.message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void redraw() {
        this.level.setText("" + this.controller.getLevel());
        this.score.setText("" + this.controller.getScore());

        final var text = switch (this.controller.returnRemoved()) {
            case 1 -> "One Line!";
            case 2 -> "Two Lines!!";
            case 3 -> "Three Lines!!!";
            case 4 -> "TETRIS";
            default -> "";
        };
        this.message.setText(text);
    }

    private JLabel customLabel(String text) {
        var custom = new JLabel(text);
        custom.setFont(this.customFont());
        custom.setForeground(Color.WHITE);
        return custom;
    }

    private Font customFont() {
        try {
            var file = new File("src/main/resources/Tetris.ttf");
            var font = Font.createFont(Font.TRUETYPE_FONT, file).deriveFont(40f);
            return font;
        } catch (FontFormatException | IOException ex) {
            return super.getFont();
        }
    }

}
