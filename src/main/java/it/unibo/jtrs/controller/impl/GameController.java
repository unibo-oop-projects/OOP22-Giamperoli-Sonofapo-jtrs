package it.unibo.jtrs.controller.impl;

import java.util.List;

import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.model.impl.GameModel;
import it.unibo.jtrs.model.impl.GameModel.Interaction;

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

    public boolean advance(Tetromino next, Interaction i) { //interacion non qua
        var res = this.model.advance(i);
        if (!res && i == Interaction.DOWN) {
            this.model.nextPiece(next);
            return true;
        }
        return false;
    }

    public Tetromino getCurrentPiece() {
        return this.model.getCurrentPiece();
    }

}
