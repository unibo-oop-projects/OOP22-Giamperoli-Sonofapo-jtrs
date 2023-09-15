package it.unibo.jtrs.model.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.model.api.TetrominoFactory;
import it.unibo.jtrs.utils.Pair;

public class TetrominoFactoryImpl implements TetrominoFactory {

	private List<Tetromino> bag;

	public TetrominoFactoryImpl() {
		this.bag = this.initialize();
	}

	private List<Tetromino> initialize() {
		Tetromino O = new TetrominoImpl(Set.of(new Pair<>(0,0), new Pair<>(0,1), new Pair<>(1,0), new Pair<>(1,1)));
		Tetromino L = new TetrominoImpl(Set.of(new Pair<>(0,0), new Pair<>(0,1), new Pair<>(1,1), new Pair<>(2,1)));
		Tetromino J = new TetrominoImpl(Set.of(new Pair<>(0,1), new Pair<>(0,0), new Pair<>(1,0), new Pair<>(2,0)));
		Tetromino I = new TetrominoImpl(Set.of(new Pair<>(0,1), new Pair<>(1,1), new Pair<>(2,1), new Pair<>(3,1)));
		Tetromino T = new TetrominoImpl(Set.of(new Pair<>(0,0), new Pair<>(1,0), new Pair<>(2,0), new Pair<>(1,1)));
		Tetromino Z = new TetrominoImpl(Set.of(new Pair<>(0,1), new Pair<>(1,1), new Pair<>(1,0), new Pair<>(2,0)));
		Tetromino S = new TetrominoImpl(Set.of(new Pair<>(0,0), new Pair<>(1,0), new Pair<>(1,1), new Pair<>(2,1)));

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
