package it.unibo.jtrs.view.impl;

import static it.unibo.jtrs.utils.Constants.GRID_ROWS;
import static it.unibo.jtrs.utils.Constants.GRID_COLS;

import java.awt.Color;
import java.util.List;

import it.unibo.jtrs.controller.api.Controller;
import it.unibo.jtrs.controller.impl.GameController;
import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.view.api.GridPanel;

public class GamePanel extends GridPanel {

    public GamePanel(final Controller controller) {
        super(controller, GRID_ROWS, GRID_COLS, 20);
    }

    @Override
    public void update() {
        List<Tetromino> pieces = ((GameController) this.getController()).getStatus().getX();
        pieces.forEach(p -> {
            final Color color = Color.decode(p.getColor());
            this.getCells().forEach((k, v) -> {
                v.setBackground(p.getComponents(0, 0).contains(k) ? color : Color.GRAY);
            });
        });  
    }

    
}
