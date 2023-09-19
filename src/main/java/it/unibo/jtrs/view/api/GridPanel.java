package it.unibo.jtrs.view.api;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.jtrs.utils.Pair;

/**
 * This class model a graphical grid panel.
 */
public class GridPanel extends JPanel {

    public static final long serialVersionUID = 4328743;

    @SuppressFBWarnings(justification = "This field need to be transient")
    private final transient Map<Pair<Integer, Integer>, Cell> cells = new HashMap<>();
    private final int rows;
    private final int cols;

    /**
     * Constructor.
     *
     * @param rows number of rows
     * @param cols number of columns
     * @param padding the amount of top padding
     */
    public GridPanel(final int rows, final int cols, final int padding) {

        this.rows = rows;
        this.cols = cols;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(padding, 0, 0, 0));

        this.initalize();
    }

    private void initalize() {
        for (int i = 0; i < this.rows; i++) {
            final JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
            for (int j = 0; j < this.cols; j++) {
                final var cell = new Cell();
                panel.add(cell);
                this.cells.put(new Pair<>(j, i), cell);
            }
            this.add(panel);
        }
    }

    /**
     * Update a map of coordinates, each with their specified color. Restore the
     * remaining cells with a default color.
     *
     * @param map the map to read from
     */
    public void setCells(final Map<Pair<Integer, Integer>, Color> map) {
        this.cells.forEach((k, v) -> {
            v.setBackground(map.keySet().contains(k) ? map.get(k) : Color.GRAY);
        });
    }

    /**
     * A class modelling a square cell. A cell behaves exactly as a JLabel and
     * has a fixed size and a thin border.
     */
    static class Cell extends JLabel {

        public static final long serialVersionUID = 4328743;

        private static final int SIZE = 32;

        /**
         * Constructor.
         */
        Cell() {
            this.setIcon(new Icon() {

                @Override
                public void paintIcon(final Component c, final Graphics g, final int x, final int y) { }

                @Override
                public int getIconWidth() {
                    return SIZE;
                }

                @Override
                public int getIconHeight() {
                    return SIZE;
                }
            });

            this.setOpaque(true);
            this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        }
    }

}
