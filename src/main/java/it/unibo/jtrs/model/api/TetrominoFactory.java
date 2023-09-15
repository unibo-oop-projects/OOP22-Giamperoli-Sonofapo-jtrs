package it.unibo.jtrs.model.api;

/**
 * A class modelling a factory of Tetrominoes. This factory should be able to
 * provide a random Tetromino each time until all different ones (7) are provided.
 * When this happens, the factory starts over providing a new random Tetromino.
 * 
 * Considering 3 Tetrominos possible (T1, T2, T3), "T1, T3, T2, T3, T1, T2, T2, etc." is a valid
 * sequence and "T1, T1, T3, T2, etc." is an invalid one.
 */
public interface TetrominoFactory {

	/**
	 * Provides a random Tetromino.
	 * 
	 * @return the random Tetromino
	 */
	public Tetromino getRandomTetromino();
	
}
