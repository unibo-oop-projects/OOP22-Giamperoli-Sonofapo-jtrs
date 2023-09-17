package it.unibo.jtrs.view.impl;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;

import it.unibo.jtrs.controller.impl.GameController;
import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.view.api.GridPanel;
import it.unibo.jtrs.view.api.View;

/**
 * The class models the game panel. This view must show the Tetronimos placed during the game.
 */
public class GamePanel extends JPanel implements View {

    private static final int GRID_ROWS = 20;
    private static final int GRID_COLS = 10;
    private static final int PADDING = 20;

    private final GridPanel game;
    private final transient GameController controller;

    /**
     * Constructor.
     *
     * @param controller the game controller
     */
    public GamePanel(final GameController controller) {
        this.controller = controller;
        
        this.game = new GridPanel(GRID_ROWS, GRID_COLS, PADDING);
        this.setLayout(new GridLayout());
        this.add(this.game);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void redraw() {
        final List<Tetromino> pieces = this.controller.getPieces();
        pieces.forEach(p -> {
            this.game.setCells(p.getComponents(0, 0), Color.decode(p.getColor()));
        });
    }

    
}
