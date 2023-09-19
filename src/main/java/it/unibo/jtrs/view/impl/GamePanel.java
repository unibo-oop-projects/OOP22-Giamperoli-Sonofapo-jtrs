package it.unibo.jtrs.view.impl;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JPanel;

import it.unibo.jtrs.controller.impl.GameController;
import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.model.impl.GameModel;
import it.unibo.jtrs.utils.Pair;
import it.unibo.jtrs.view.api.GridPanel;
import it.unibo.jtrs.view.api.View;

/**
 * The class models the game panel. This view must show the Tetronimos placed during the game.
 */
public class GamePanel extends JPanel implements View {

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

        this.game = new GridPanel(GameModel.GRID_ROWS, GameModel.GRID_COLS, PADDING);
        this.setLayout(new GridLayout());
        this.add(this.game);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void redraw() {
        final List<Tetromino> pieces = this.controller.getPieces();
        final var result = pieces.stream()
            .flatMap(p -> p.getComponents()
                .stream().map(c -> new Pair<>(c, Color.decode(p.getColor()))))
                .collect(Collectors.toMap(Pair::getX, Pair::getY));
        this.game.setCells(result);
    }

}
