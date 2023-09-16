package it.unibo.jtrs.view.impl;

import static it.unibo.jtrs.utils.Constants.PREVIEW_ROWS;
import static it.unibo.jtrs.utils.Constants.PREVIEW_COLS;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;

import it.unibo.jtrs.controller.api.Controller;
import it.unibo.jtrs.controller.impl.PreviewController;
import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.utils.Pair;
import it.unibo.jtrs.view.api.SubPanel;

/**
 * The class model a preview panel. This view must show the next Tetromino.
 */
public class PreviewPanel extends SubPanel {

    Map<Pair<Integer, Integer>, JLabel> cells = new HashMap<>();

    public PreviewPanel(final Controller controller) {
        super(controller);

        this.setLayout(new GridLayout(PREVIEW_ROWS, PREVIEW_COLS));
        this.initalize();
        this.update();
        this.setVisible(true);
    }

    @Override
    public void update() {
        final Tetromino t = ((PreviewController) this.getController()).getStatus();
        final Color color = Color.decode(t.getColor());
        this.cells.forEach((k, v) -> {
            v.setBackground(t.getComponents(0, 0).contains(k) ? color : Color.GRAY);
        });
    }

    private void initalize() {
        for (int x = 0; x < PREVIEW_ROWS; x++) {
            for (int y = 0; y < PREVIEW_COLS; y++) {
                final var lbl = new JLabel();
                lbl.setOpaque(true);
                this.add(lbl);
                this.cells.put(new Pair<>(y, x), lbl);
            }
        }
    }

}
