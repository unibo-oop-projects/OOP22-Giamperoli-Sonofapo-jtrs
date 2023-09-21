package it.unibo.jtrs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

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
    private Tetromino lTetromino;

    /**
     * Initialize necessary field for the tests.
     */
    @BeforeEach
    public void init() {
        tTetromino = new TetrominoImpl(TetrominoData.T_COORD, 0, 0, TetrominoData.T_COLOR);
        lTetromino = new TetrominoImpl(TetrominoData.L_COORD, 0, 0, TetrominoData.L_COLOR);
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
     * Test Tetromino delete and its pack feature.
     */
    @Test
    public void testPackDelete() {

        tTetromino.rotate();
        tTetromino.delete(1);
        assertEquals(Set.of(new Pair<>(1, 2), new Pair<>(2, 2)),
            tTetromino.getComponents());

        lTetromino.rotate();
        lTetromino.delete(1);
        assertEquals(Set.of(new Pair<>(1, 1), new Pair<>(1, 2), new Pair<>(2, 2)),
            lTetromino.getComponents());
    }

}
