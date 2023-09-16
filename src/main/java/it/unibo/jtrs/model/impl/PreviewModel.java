package it.unibo.jtrs.model.impl;

import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.model.api.TetrominoFactory;

/**
 * This class implements the preview model. This model should be able to provide
 * the next Tetromino according to game rules.
 */
public class PreviewModel {

    private final TetrominoFactory factory = new TetrominoFactoryImpl();
    private Tetromino current = factory.getRandomTetromino();

    /**
     * Return the next Tetromino to show during gameplay.
     *
     * @return the Tetromino
     */
    public void next() {
        this.factory.getRandomTetromino();
    }

    /**
     * Return the current Tetromino.
     * 
     * @return the Tetromino
     */
    public Tetromino getCurrent() {
        return this.current;
    }

}
