package it.unibo.jtrs.controller.impl;

import java.util.List;

import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.model.impl.GameModelImpl;
import it.unibo.jtrs.model.api.GameModel.Interaction;

/**
 * GameController implementation.
 */
public class GameController {

    private final GameModelImpl model;

    /**
     * Constructor.
     *
     * @param first the first Tetromino
     */
    public GameController(final Tetromino first) {
        this.translateToCenter(first);
        this.model = new GameModelImpl(first);
    }

    /**
     * Returns a list of Tetrominoes in the grid.
     *
     * @return the list of Tetrominoes
     */
    public List<Tetromino> getPieces() {
        return this.model.getPieces();
    }

    /**
     * Returns if the given interaction is successful.
     *
     * @param i the interaction
     * @return true on success, false otherwise
     */
    public boolean advance(final Interaction i) {
        return this.model.advance(i);
    }

    /**
     * Returns if the given Tetromino has been addedd to the grid.
     *
     * @param next the Tetromino to be added
     * @return true on success, false otherwise
     */
    public boolean changePiece(final Tetromino next) {
        this.translateToCenter(next);
        return this.model.nextPiece(next);
    }

    /**
     * Returns the number of lines deleted.
     * 
     * @return the number of lines
     */
    public int deleteRows() {
        return this.model.deleteRows();
    }

    private void translateToCenter(final Tetromino tetromino) {
        tetromino.translate(0, GameModelImpl.GRID_COLS / 2 - 2);
    }

}
