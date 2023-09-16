package it.unibo.jtrs.model.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.utils.Pair;

/**
 * This class implements how a Tetramino should work.
 */
public class TetrominoImpl implements Tetromino {

    private Set<Pair<Integer, Integer>> compontents;
    private Pair<Integer, Integer> pivot;
    private final String color;

    /**
     * Constructor.
     *
     * @param initialComponents the initial set of coordinates
     * @param color the color of the Tetromino
     */
    public TetrominoImpl(final Set<Pair<Integer, Integer>> initialComponents, final String color) {
        this.compontents = new HashSet<>(initialComponents);
        this.color = color;
        this.pivot = this.center();
    }

    @Override
    public void rotate() {
        this.compontents = this.compontents.stream()
            .map(c -> new Pair<>(c.getY() - pivot.getY() + pivot.getX(),
                pivot.getX() - c.getX() + pivot.getY()))
            .collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public void translate(final int x, final int y) {
        this.pivot = this.center();
        this.compontents = this.getComponents(x, y);
    }

    @Override
    public Set<Pair<Integer, Integer>> getComponents(final int x, final int y) {
        return this.compontents.stream()
            .map(c -> new Pair<>(c.getX() + x, c.getY() + y))
            .collect(Collectors.toCollection(HashSet::new));
    }

    /**
     * Evaluate the Tetromino's pivot point at the current state. This is found
     * as a rectangle centroid.
     *
     * @return the pivot point
     */
    private Pair<Integer, Integer> center() {
        var x = this.compontents.stream().collect(Collectors.summarizingInt(Pair::getX));
        var y = this.compontents.stream().collect(Collectors.summarizingInt(Pair::getY));
        int wh = (int) Math.ceil((x.getMax() - x.getMin()) / 2.0);
        int hh = (int) Math.ceil((y.getMax() - y.getMin()) / 2.0);

        return new Pair<>(x.getMin() + wh, y.getMin() + hh);
    }

    @Override
    public String getColor() {
        return this.color;
    }

}
