package it.unibo.jtrs.view.api;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

import javax.swing.BorderFactory;
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
    private final transient Map<Pair<Integer, Integer>, JLabel> cells = new HashMap<>();
    private final int rows;
    private final int cols;

    /**
     * Constructor.
     *
     * @param rows number of rows
     * @param cols number of columns
     * @param padding the amount of padding
     */
    public GridPanel(final int rows, final int cols, final int padding) {

        this.rows = rows;
        this.cols = cols;

        this.setLayout(new GridLayout(rows, cols));
        this.setBorder(new EmptyBorder(padding, padding, padding, padding));

        this.initalize();
    }

    private void initalize() {
        IntStream.range(0, this.rows)
            .mapToObj(i -> i)
            .flatMap(x -> IntStream.range(0, this.cols)
                .mapToObj(y -> new Pair<>(y, x)))
            .forEach(c -> {
                final var lbl = new JLabel();
                lbl.setOpaque(true);
                lbl.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                this.add(lbl);
                this.cells.put(c, lbl);
            });
    }

    /**
     * Update a set of cells specified with their coordinates with a new color.
     * Restore the other cells with a default color.
     *
     * @param components a set of coordinates
     * @param color the color to update
     */
    public void setCells(final Set<Pair<Integer, Integer>> components, final Color color) {
        this.cells.forEach((k, v) -> {
            v.setBackground(components.contains(k) ? color : Color.GRAY);
        });
    }

}
