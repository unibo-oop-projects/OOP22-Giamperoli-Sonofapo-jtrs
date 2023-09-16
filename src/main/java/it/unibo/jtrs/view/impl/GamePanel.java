package it.unibo.jtrs.view.impl;

import static it.unibo.jtrs.utils.Constants.GRID_ROWS;
import static it.unibo.jtrs.utils.Constants.GRID_COLS;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;

import it.unibo.jtrs.controller.api.Controller;
import it.unibo.jtrs.controller.impl.GameController;
import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.utils.Pair;
import it.unibo.jtrs.view.api.SubPanel;

public class GamePanel extends SubPanel {

    Map<Pair<Integer, Integer>, JLabel> cells = new HashMap<>();

    public GamePanel(Controller controller) {
        super(controller);

        this.setLayout(new GridLayout(GRID_ROWS, GRID_COLS));
        this.initalize();
        this.update();
        this.setVisible(true);
    }

    @Override
    public void update() {
        List<Tetromino> pieces = ((GameController) this.getController()).getStatus();
        if(!pieces.isEmpty()) {
            pieces.forEach(p -> {
                final Color color = Color.decode(p.getColor());
                this.cells.forEach((k, v) -> {
                    v.setBackground(p.getComponents(0, 0).contains(k) ? color : Color.GRAY);
                });
            }); 
        }   
    }

    private void initalize() {
        for (int x = 0; x < GRID_ROWS; x++) {
            for (int y = 0; y < GRID_COLS; y++) {
                final var lbl = new JLabel();
                lbl.setOpaque(true);
                this.add(lbl);
                this.cells.put(new Pair<>(y, x), lbl);
            }
        }
    }
    
}
