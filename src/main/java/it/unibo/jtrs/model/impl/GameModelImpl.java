package it.unibo.jtrs.model.impl;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

import it.unibo.jtrs.model.api.GameModel;
import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.utils.Pair;

/**
 * GameModel implementation.
 */
public class GameModelImpl implements GameModel {

    /**
     * The number of grid's rows.
     */
    public static final int GRID_ROWS = 20;

    /**
     * The number of grid's columns.
     */
    public static final int GRID_COLS = 10;

    final private List<Tetromino> pieces;

    /**
     * Constructor.
     *
     * @param first the first Tetronimo to be placed
     */
    public GameModelImpl(final Tetromino first) {
        this.pieces = new ArrayList<>(List.of(first));
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public List<Tetromino> getPieces() {
        return List.copyOf(this.pieces);
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public boolean nextPiece(final Tetromino next) {
        this.pieces.add(next);
        if (this.collide(next.getComponents())) {
            this.pieces.remove(this.pieces.size() - 1);
            return false;
        }
        return true;
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public boolean advance(final Interaction i) {
        final Predicate<Set<Pair<Integer, Integer>>> predicate = c -> this.checkAvailablePosition(c);
        Consumer<Tetromino> consumer = switch (i) {
            case ROTATE -> Tetromino::rotate;
            case DOWN -> (t -> t.translate(0, 1));
            case LEFT -> (t -> t.translate(-1, 0));
            case RIGHT -> (t -> t.translate(1, 0));
        };
        return this.action(consumer, predicate);
    }

    private Tetromino getCurrentPiece() {
        return this.pieces.get(this.pieces.size() - 1);
    }

    private boolean action(final Consumer<Tetromino> function, final Predicate<Set<Pair<Integer, Integer>>> predicate) {
        final var tmp = this.getCurrentPiece().copy();
        function.accept(tmp);
        if (predicate.test(tmp.getComponents())) {
            function.accept(this.getCurrentPiece());
            return true;
        }
        return false;
    }

    private boolean checkAvailablePosition(final Set<Pair<Integer, Integer>> coords) {
        return this.inBound(coords) && !this.collide(coords);
    }

    private boolean inBound(final Set<Pair<Integer, Integer>> coords) {
        return this.getXStats(coords).getMin() >= 0
            && this.getXStats(coords).getMax() < GameModelImpl.GRID_COLS
            && this.getYStats(coords).getMax() < GameModelImpl.GRID_ROWS;
    }

    private IntSummaryStatistics getXStats(final Set<Pair<Integer, Integer>> coords) {
        return coords.stream()
            .mapToInt(Pair::getX)
            .summaryStatistics();
    }

    private IntSummaryStatistics getYStats(final Set<Pair<Integer, Integer>> coords) {
        return coords.stream()
            .mapToInt(Pair::getY)
            .summaryStatistics();
    }

    private boolean collide(final Set<Pair<Integer, Integer>> coords) {
        return this.pieces.subList(0, this.pieces.size() - 1)
            .stream()
            .flatMap(p -> p.getComponents().stream())
            .anyMatch(c -> coords.contains(c));
    }

}
