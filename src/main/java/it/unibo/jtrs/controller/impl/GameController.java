package it.unibo.jtrs.controller.impl;

import java.util.List;
import java.util.Set;

import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.model.impl.GameModelImpl;
import it.unibo.jtrs.utils.TetrominoData;
import it.unibo.jtrs.model.api.GameModel.Interaction;

/**
 * GameController implementation.
 */
public class GameController {

    private final GameModelImpl model;

    /**
     * Constructor.
     */
    public GameController() {
        this.model = new GameModelImpl();
    }

    /**
     * Return a list of Tetrominoes in the grid.
     *
     * @return the list of Tetrominoes
     */
    public List<Tetromino> getPieces() {
        return this.model.getPieces();
    }

    /**
     * Return if the given interaction is successful.
     *
     * @param i the interaction
     * @return true on success, false otherwise
     */
    public boolean advance(final Interaction i) {
        return this.model.advance(i);
    }

    /**
     * Return if the given Tetromino has been addedd to the grid.
     *
     * @param next the Tetromino to be added
     * @return true on success, false otherwise
     */
    public boolean changePiece(final Tetromino next) {
        this.translateToCenter(next);
        return this.model.nextPiece(next);
    }

    /**
     * Return the number of lines deleted.
     *
     * @return the number of lines
     */
    public int deleteRows() {
        return this.model.deleteRows();
    }

    /**
     * Return the deleted lines.
     *
     * @return a set of lines
     */
    public Set<Integer> getDeletedLines() {
        return this.model.getDeletedLines();
    }

    private void translateToCenter(final Tetromino tetromino) {
        if (TetrominoData.I_COLOR.equals(tetromino.getColor())) {
            tetromino.translate(-1, 0);
        }
        tetromino.translate(0, GameModelImpl.GRID_COLS / 2 - 2);
    }

}
