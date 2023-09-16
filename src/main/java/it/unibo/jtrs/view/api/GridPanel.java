package it.unibo.jtrs.view.api;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.unibo.jtrs.controller.api.Controller;
import it.unibo.jtrs.utils.Pair;

/**
 * This class model a graphical panel
 */
public abstract class GridPanel extends SubPanel {

    private Map<Pair<Integer, Integer>, JLabel> cells = new HashMap<>();
    private final JPanel preview;
    private final int rows;
    private final int cols;

    public GridPanel(Controller controller, final int rows, final int cols, final int margin) {
        super(controller);

        this.rows = rows;
        this.cols = cols;
        this.preview = new JPanel(new GridLayout(rows, cols));

        preview.setBorder(new EmptyBorder(margin, margin, margin, margin));
        this.setLayout(new GridLayout(1, 1));
        this.add(preview);

        this.initalize();
    }

    private void initalize() {
        for (int x = 0; x < this.rows; x++) {
            for (int y = 0; y < this.cols; y++) {
                final var lbl = new JLabel();
                lbl.setOpaque(true);
                lbl.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                this.preview.add(lbl);
                this.cells.put(new Pair<>(y, x), lbl);
            }
        }
    }

    protected Map<Pair<Integer, Integer>, JLabel> getCells() {
        return this.cells;
    }
    
}
