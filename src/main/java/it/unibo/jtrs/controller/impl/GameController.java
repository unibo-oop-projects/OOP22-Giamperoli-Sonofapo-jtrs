package it.unibo.jtrs.controller.impl;

import java.util.List;

import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.model.impl.GameModel;
import it.unibo.jtrs.model.impl.TetrominoFactoryImpl;

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
        this.model.setNext((new TetrominoFactoryImpl()).getRandomTetromino());
        this.model.advance();
        return this.model.getPieces();
    }

}
