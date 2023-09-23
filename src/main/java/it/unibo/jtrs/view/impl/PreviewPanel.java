package it.unibo.jtrs.view.impl;

import java.awt.Color;
import java.util.stream.Collectors;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import it.unibo.jtrs.controller.impl.PreviewController;
import it.unibo.jtrs.view.api.View;
import it.unibo.jtrs.view.custom.GridPanel;
import it.unibo.jtrs.view.custom.Label;

/**
 * The class models the preview panel. This view must show the next Tetromino.
 */
public class PreviewPanel extends JPanel implements View {

    public static final long serialVersionUID = 4328743;

    private static final int GRID_COLS = 5;
    private static final int GRID_ROWS = 4;
    private static final int PADDING = 100;
    private static final int INTERLINE = 20;
    private static final float FONT_SIZE = 30f;

    private final GridPanel preview;
    private final transient PreviewController controller;

    /**
     * Constructor.
     *
     * @param controller the preview controller
     */
    public PreviewPanel(final PreviewController controller) {
        this.controller = controller;

        this.setOpaque(false);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createVerticalStrut(PADDING));

        this.preview = new GridPanel(GRID_ROWS, GRID_COLS, 0);
        this.preview.setOpaque(false);
        this.preview.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        final JLabel label = new Label("NEXT", "Tetris.ttf", FONT_SIZE, Color.WHITE);
        label.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        this.add(label);
        this.add(Box.createVerticalStrut(INTERLINE));
        this.add(this.preview);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void redraw() {
        final var t = this.controller.getCurrentTetromino();
        t.translate(1, 1);
        final var c = t.getComponents()
            .stream()
            .collect(Collectors.toMap(k -> k, v -> Color.decode(t.getColor())));
        this.preview.setCells(c);
    }

}
