package it.unibo.jtrs.model.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.utils.Pair;

public class TetrominoImpl implements Tetromino {

	private Set<Pair<Integer, Integer>> compontents;
	private Pair<Integer, Integer> pivot;

	public TetrominoImpl(Set<Pair<Integer, Integer>> initialComponents) {
		this.compontents = new HashSet<>(initialComponents);
		this.pivot = this.center();
	}

	@Override
	public void rotate() {
		this.compontents = this.compontents.stream()
			.map(c -> new Pair<>(c.getY() - pivot.getY() + pivot.getX(),
				pivot.getX() - c.getX() + pivot.getY()))
			.collect(Collectors.toSet());
	}

	@Override
	public void translate(int x, int y) {
		this.pivot = this.center();
		this.compontents = this.compontents.stream()
			.map(c -> new Pair<>(c.getX() + x, c.getY() + y))
			.collect(Collectors.toSet());
	}

	@Override
	public Set<Pair<Integer, Integer>> getComponents() {
		return Set.copyOf(this.compontents);
	}

	private Pair<Integer, Integer> center() {
		int maxX = this.compontents.stream().mapToInt(Pair::getX).max().getAsInt();
		int minX = this.compontents.stream().mapToInt(Pair::getX).min().getAsInt();
		int maxY = this.compontents.stream().mapToInt(Pair::getY).max().getAsInt();
		int minY = this.compontents.stream().mapToInt(Pair::getY).min().getAsInt();

		int wh = (int) Math.ceil((maxX - minX) / 2.0);
		int hh = (int) Math.ceil((maxY - minY) / 2.0);
		return new Pair<>(minX + wh, minY + hh);
	}
	
}
