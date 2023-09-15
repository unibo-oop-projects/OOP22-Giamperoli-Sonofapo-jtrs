package it.unibo.jtrs.model.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.model.api.TetrominoFactory;
import it.unibo.jtrs.utils.TetrominoData;

public class TetrominoFactoryImpl implements TetrominoFactory {

	private List<Tetromino> bag;

	public TetrominoFactoryImpl() {
		this.bag = this.initialize();
	}

	private List<Tetromino> initialize() {
		Tetromino O = new TetrominoImpl(TetrominoData.O_COORD, TetrominoData.O_COLOR);
		Tetromino L = new TetrominoImpl(TetrominoData.L_COORD, TetrominoData.L_COLOR);
		Tetromino J = new TetrominoImpl(TetrominoData.J_COORD, TetrominoData.J_COLOR);
		Tetromino I = new TetrominoImpl(TetrominoData.I_COORD, TetrominoData.I_COLOR);
		Tetromino T = new TetrominoImpl(TetrominoData.T_COORD, TetrominoData.T_COLOR);
		Tetromino Z = new TetrominoImpl(TetrominoData.Z_COORD, TetrominoData.Z_COLOR);
		Tetromino S = new TetrominoImpl(TetrominoData.S_COORD, TetrominoData.S_COLOR);

		return new ArrayList<>(List.of(O, L, J, I, T, Z, S));
	}

	@Override
	public Tetromino getRandomTetromino() {
		if (this.bag.size() < 1) {
			this.bag = this.initialize();
		}
		Collections.shuffle(this.bag);
		return bag.remove(0);
	}
	
}
