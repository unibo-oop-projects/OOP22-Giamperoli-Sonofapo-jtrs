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

    private Tetromino tetromino;

    /**
     * Initialize necessary field for the tests.
     */
    @BeforeEach
    public void init() {
        tetromino = new TetrominoImpl(TetrominoData.T_COORD, 0, 0, TetrominoData.T_COLOR);
    }

    /**
     * Test Tetromino rotation.
     */
    @Test
    public void testRotate() {
        tetromino.rotate();
        assertEquals(tetromino.getComponents(),
            Set.of(new Pair<>(1, 1), new Pair<>(0, 2), new Pair<>(1, 2), new Pair<>(2, 2)));
        tetromino.rotate();
        assertEquals(tetromino.getComponents(),
            Set.of(new Pair<>(2, 0), new Pair<>(2, 1), new Pair<>(2, 2), new Pair<>(1, 1)));
        tetromino.rotate();
        assertEquals(tetromino.getComponents(),
            Set.of(new Pair<>(0, 0), new Pair<>(1, 0), new Pair<>(2, 0), new Pair<>(1, 1)));
        tetromino.rotate(); // return to starting position after 4 rotation
        assertEquals(tetromino.getComponents(), TetrominoData.T_COORD);
    }

}
