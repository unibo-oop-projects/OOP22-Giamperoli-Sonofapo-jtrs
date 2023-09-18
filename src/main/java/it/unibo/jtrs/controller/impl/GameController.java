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
    public GameController(Tetromino first) {
        this.model = new GameModel(first);
    }

    public List<Tetromino> getPieces() {
        return this.model.getPieces();
    }

    public void advance() {
        if(!this.model.checkBottom()) {
            this.model.advance(0, 1);
        }
    }

    public boolean fallDown() {
        return this.model.checkBottom();
    }

    public boolean checkPieceCollision() {
        return this.model.checkPieceCollision();
    }

    public Tetromino getCurrentPiece() {
        return this.model.getCurrentPiece();
    }

    public void nextPiece(Tetromino next) {
        this.model.nextPiece(next);
    }

}
