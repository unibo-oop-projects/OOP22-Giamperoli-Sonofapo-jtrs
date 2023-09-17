package it.unibo.jtrs.controller.impl;

import java.util.List;

import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.model.impl.GameModel;

/**
 * GameController implementation.
 */
public class GameController {

    private final GameModel model;

    /**
     * Constructor.
     */
    public GameController() {
        this.model = new GameModel();
    }

    public List<Tetromino> getPieces() {
        return this.model.getPieces();
    }

}
