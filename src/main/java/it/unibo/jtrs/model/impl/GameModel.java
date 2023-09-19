package it.unibo.jtrs.model.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.utils.Pair;

/**
 * This class implements the game model. This model provides the Tetrominos placed
 * during the game and how the current Tetromino can move in the grid according
 * to the game rules.
 */
public class GameModel {

    public static final int GRID_ROWS = 20;
    public static final int GRID_COLS = 10;

    public enum Interaction {
        DOWN,
        LEFT, 
        RIGHT,
        ROTATE
    }

    private List<Tetromino> pieces;
    //private Set<Pair<Integer, Integer>> freeCells;

    /**
     * Constructor.
     * @param first the first Tetronimo to be placed
     */
    public GameModel(Tetromino first) {
        this.pieces = new ArrayList<>(List.of(first));
    }

    public List<Tetromino> getPieces() {
        return List.copyOf(this.pieces);
    }

    //Serve??
    public Tetromino getCurrentPiece() {
        return this.pieces.get(this.pieces.size() - 1);
    }

    public void nextPiece(Tetromino next) {     
        this.pieces.add(next);
    }

    public boolean advance(Interaction i) {
        Predicate<Set<Pair<Integer, Integer>>> predicate = c -> this.checkAvailablePosition(c); 
        Consumer<Tetromino> consumer = null;
        switch (i) {
            case ROTATE:
                consumer = Tetromino::rotate;
                break;
            case DOWN:
                consumer = t -> t.translate(0, 1);
                break;
            case LEFT:
                consumer = t -> t.translate(-1, 0);
                break;
            case RIGHT:
                consumer = t -> t.translate(1, 0);
                break;
        }
        return this.action(consumer, predicate);
    }

    private boolean action(Consumer<Tetromino> function, Predicate<Set<Pair<Integer, Integer>>> predicate) {
        var temp = new TetrominoFactoryImpl().getRandomTetromino(); // buttare via
        function.accept(temp);
        if (predicate.test(temp.getComponents())) {
            function.accept(this.getCurrentPiece());
            return true;
        }
        return false;
    }

    private boolean checkAvailablePosition(Set<Pair<Integer, Integer>> coords) {
        return this.checkLateralBound(coords) && 
            this.checkBottomBound(coords) && 
            !this.getCoordPieces().stream().anyMatch(c -> coords.contains(c));
    }

    private boolean checkLateralBound(Set<Pair<Integer, Integer>> coords) {
        return this.getXStats(coords).getMin() >= 0  && this.getXStats(coords).getMax() < GameModel.GRID_COLS;
    }

    public boolean checkBottomBound(Set<Pair<Integer, Integer>> coords) {
        return this.getYStats(coords).getMax() < GameModel.GRID_ROWS;
    }

    private IntSummaryStatistics getXStats(Set<Pair<Integer, Integer>> coords) {
        return coords.stream().collect(Collectors.summarizingInt(Pair::getX));
    }

    private IntSummaryStatistics getYStats(Set<Pair<Integer, Integer>> coords) {
        return coords.stream().collect(Collectors.summarizingInt(Pair::getY));
    }

    private Set<Pair<Integer, Integer>> getCoordPieces() {
        Set<Pair<Integer, Integer>> res = new HashSet<>();
        this.pieces.forEach(p -> res.addAll(p.getComponents()));
        return res;
    }

}
