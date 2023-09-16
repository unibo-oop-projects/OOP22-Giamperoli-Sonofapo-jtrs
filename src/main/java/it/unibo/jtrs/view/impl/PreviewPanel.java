package it.unibo.jtrs.view.impl;

import static it.unibo.jtrs.utils.Constants.PREVIEW_ROWS;
import static it.unibo.jtrs.utils.Constants.PREVIEW_COLS;

import java.awt.Color;

import it.unibo.jtrs.controller.api.Controller;
import it.unibo.jtrs.controller.impl.PreviewController;
import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.view.api.GridPanel;

/**
 * The class model a preview panel. This view must show the next Tetromino.
 */
public class PreviewPanel extends GridPanel {

    public PreviewPanel(final Controller controller) {
        super(controller, PREVIEW_ROWS, PREVIEW_COLS, 100); // TODO: remove magic number
        
        this.update();
    }

    @Override
    public void update() {
        final Tetromino t = ((PreviewController) this.getController()).getStatus();
        final Color color = Color.decode(t.getColor());
        this.getCells().forEach((k, v) -> {
            v.setBackground(t.getComponents(0, 0).contains(k) ? color : Color.GRAY);
        });
    }

}
