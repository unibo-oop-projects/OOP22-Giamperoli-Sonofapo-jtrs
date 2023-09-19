package it.unibo.jtrs.model.impl;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.utils.Pair;

/**
 * Tetromino implementation.
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void rotate() {
        this.compontents = this.compontents.stream()
            .map(c -> new Pair<>(c.getY() - pivot.getY() + pivot.getX(),
                pivot.getX() - c.getX() + pivot.getY()))
            .collect(Collectors.toCollection(HashSet::new));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void translate(final int x, final int y) {
        this.pivot = this.center();
        this.compontents = this.compontents.stream()
            .map(c -> new Pair<>(c.getX() + x, c.getY() + y))
            .collect(Collectors.toCollection(HashSet::new));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Pair<Integer, Integer>> getComponents() {
        return Set.copyOf(this.compontents);
    }

    /**
     * Evaluate the Tetromino's pivot point at the current state. This is found
     * as a rectangle centroid.
     *
     * @return the pivot point
     */
    private Pair<Integer, Integer> center() {
        final var x = this.compontents.stream().collect(Collectors.summarizingInt(Pair::getX));
        final var y = this.compontents.stream().collect(Collectors.summarizingInt(Pair::getY));
        final int wh = (int) Math.ceil((x.getMax() - x.getMin()) / 2.0);
        final int hh = (int) Math.ceil((y.getMax() - y.getMin()) / 2.0);

        return new Pair<>(x.getMin() + wh, y.getMin() + hh);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getColor() {
        return this.color;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Tetromino copy() {
        return new TetrominoImpl(Set.copyOf(compontents), color);
    }

}
