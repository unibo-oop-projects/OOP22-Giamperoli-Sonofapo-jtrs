package it.unibo.jtrs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.model.impl.TetrominoImpl;
import it.unibo.jtrs.utils.Pair;
import it.unibo.jtrs.utils.TetrominoData;

/**
 * Tetromino test class.
 */
@SuppressWarnings("PMD")
public class TetrominoTest {

    private Tetromino tTetromino;

    /**
     * Initialize necessary field for the tests.
     */
    @BeforeEach
    public void init() {
        tTetromino = new TetrominoImpl(TetrominoData.T_COORD, 0, 0, TetrominoData.T_COLOR);
    }

    /**
     * Test Tetromino rotation.
     */
    @Test
    public void testRotate() {

        tTetromino.rotate();
        assertEquals(Set.of(new Pair<>(1, 1), new Pair<>(0, 2), new Pair<>(1, 2), new Pair<>(2, 2)),
            tTetromino.getComponents());
        tTetromino.rotate();
        assertEquals(Set.of(new Pair<>(2, 0), new Pair<>(2, 1), new Pair<>(2, 2), new Pair<>(1, 1)),
            tTetromino.getComponents());
        tTetromino.rotate();
        assertEquals(Set.of(new Pair<>(0, 0), new Pair<>(1, 0), new Pair<>(2, 0), new Pair<>(1, 1)),
            tTetromino.getComponents());
        tTetromino.rotate(); // return to starting position after 4 rotation
        assertEquals(TetrominoData.T_COORD, tTetromino.getComponents());
    }

    /**
     * Test Tetromino component deletion.
     */
    @Test
    public void testDelete() {

        final var t1 = new TetrominoImpl(Set.of(new Pair<>(0, 2)), 0, 0, tTetromino.getColor());
        final var t2 = new TetrominoImpl(Set.of(new Pair<>(2, 2)), 0, 0, tTetromino.getColor());

        tTetromino.rotate();
        // delete some components and get the remaining Tetrominoes
        final var res = tTetromino.delete(1).stream().collect(Collectors.toList());
        final var map = res.stream().map(Tetromino::getComponents).collect(Collectors.toSet());

        assertEquals(true, map.contains(t1.getComponents()) && map.contains(t2.getComponents()));

        // delete the remaining components to test their total deletion
        final var c1 = res.get(0).delete(0);
        final var c2 = res.get(1).delete(2);

        assertEquals(true, c1.isEmpty());
        assertEquals(true, c2.isEmpty());
    }

}
