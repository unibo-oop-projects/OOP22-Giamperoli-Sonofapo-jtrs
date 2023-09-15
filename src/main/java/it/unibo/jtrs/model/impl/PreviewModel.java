package it.unibo.jtrs.model.impl;

import it.unibo.jtrs.model.api.Model;
import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.model.api.TetrominoFactory;

public class PreviewModel implements Model<Tetromino> {

	TetrominoFactory factory = new TetrominoFactoryImpl();

	@Override
	public Tetromino get() {
		return factory.getRandomTetromino();
	}

	@Override
	public void set(Tetromino data) {
	}
	
}
