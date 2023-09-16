package it.unibo.jtrs.model.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.model.api.TetrominoFactory;
import it.unibo.jtrs.utils.TetrominoData;

/**
 * This class implements the logic to provide a TetrominoFactory.
 */
public class TetrominoFactoryImpl implements TetrominoFactory {

    private List<Tetromino> bag;

    /**
     * Constructor.
     */
    public TetrominoFactoryImpl() {
        this.bag = this.initialize();
    }

    private List<Tetromino> initialize() {
        final Tetromino oPc = new TetrominoImpl(TetrominoData.O_COORD, TetrominoData.O_COLOR);
        final Tetromino lPc = new TetrominoImpl(TetrominoData.L_COORD, TetrominoData.L_COLOR);
        final Tetromino jPc = new TetrominoImpl(TetrominoData.J_COORD, TetrominoData.J_COLOR);
        final Tetromino iPc = new TetrominoImpl(TetrominoData.I_COORD, TetrominoData.I_COLOR);
        final Tetromino tPc = new TetrominoImpl(TetrominoData.T_COORD, TetrominoData.T_COLOR);
        final Tetromino zPc = new TetrominoImpl(TetrominoData.Z_COORD, TetrominoData.Z_COLOR);
        final Tetromino sPc = new TetrominoImpl(TetrominoData.S_COORD, TetrominoData.S_COLOR);

        return new ArrayList<>(List.of(oPc, lPc, jPc, iPc, tPc, zPc, sPc));
    }

    @Override
    public Tetromino getRandomTetromino() {
        if (this.bag.isEmpty()) {
            this.bag = this.initialize();
        }
        Collections.shuffle(this.bag);
        return bag.remove(0);
    }

}
