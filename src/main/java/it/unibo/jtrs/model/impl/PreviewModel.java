package it.unibo.jtrs.model.impl;

import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.model.api.TetrominoFactory;

public class PreviewModel {

	TetrominoFactory factory = new TetrominoFactoryImpl();

	public Tetromino next() {
		return factory.getRandomTetromino();
	}
	
}
