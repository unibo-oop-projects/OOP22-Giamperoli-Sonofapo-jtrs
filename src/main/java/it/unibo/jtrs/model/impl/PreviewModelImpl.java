package it.unibo.jtrs.model.impl;

import it.unibo.jtrs.model.api.PreviewModel;
import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.model.api.TetrominoFactory;

/**
 * This class implements the preview model. This model should be able to provide
 * the next Tetromino according to game rules.
 */
public class PreviewModelImpl implements PreviewModel {

    private final TetrominoFactory factory = new TetrominoFactoryImpl();
    private Tetromino current = factory.getRandomTetromino();

    /**
    * {@inheritDoc}
    */
    @Override
    public void next() {
       this.current = this.factory.getRandomTetromino();
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public Tetromino current() {
        return this.current.copy();
    }

}
