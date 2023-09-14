package it.unibo.jtrs.model.api;

import java.util.Set;

import it.unibo.jtrs.utils.Pair;

public interface Tetromino {
	
	public boolean rotate();

	public boolean translate(int x, int y);

	public Set<Pair<Integer, Integer>> getComponents();
}
