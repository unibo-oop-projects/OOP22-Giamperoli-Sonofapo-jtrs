package it.unibo.jtrs.view.impl;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.stream.Collectors;

import javax.swing.JPanel;

import it.unibo.jtrs.controller.impl.PreviewController;
import it.unibo.jtrs.view.api.GridPanel;
import it.unibo.jtrs.view.api.View;

/**
 * The class models the preview panel. This view must show the next Tetromino.
 */
public class PreviewPanel extends JPanel implements View {

    public static final long serialVersionUID = 4328743;

    private static final int GRID_COLS = 5;
    private static final int GRID_ROWS = 3;
    private static final int PADDING = 50;

    private final GridPanel preview;
    private final transient PreviewController controller;

    /**
     * Constructor.
     *
     * @param controller the preview controller
     */
    public PreviewPanel(final PreviewController controller) {
        this.controller = controller;

        this.preview = new GridPanel(GRID_ROWS, GRID_COLS, PADDING);
        this.setLayout(new GridLayout());
        this.add(this.preview);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void redraw() {
        final var t = this.controller.getCurrentTetromino();
        final var c = t.getComponents()
            .stream()
            .collect(Collectors.toMap(k -> k, v -> Color.decode(t.getColor())));
        this.preview.setCells(c);
    }

}
