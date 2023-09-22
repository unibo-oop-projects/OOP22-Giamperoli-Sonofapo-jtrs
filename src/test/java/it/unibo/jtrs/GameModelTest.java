package it.unibo.jtrs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.jtrs.model.api.GameModel;
import it.unibo.jtrs.model.impl.GameModelImpl;
import it.unibo.jtrs.model.impl.TetrominoImpl;
import it.unibo.jtrs.utils.Pair;
import it.unibo.jtrs.utils.TetrominoData;

public class GameModelTest {

    private GameModel model;

     /**
     * Initialize necessary field for the tests.
     */
    @BeforeEach
    public void init() {
        this.model = new GameModelImpl(new TetrominoImpl(TetrominoData.O_COORD, 18, 0, TetrominoData.O_COLOR));
    }

    /**
     * Test delete two rows.
     */
    @Test
    public void testDeleteTwoRows() {
        this.model.nextPiece(new TetrominoImpl(TetrominoData.O_COORD, 18, 2, TetrominoData.O_COLOR));
        this.model.nextPiece(new TetrominoImpl(TetrominoData.O_COORD, 18, 4, TetrominoData.O_COLOR));
        this.model.nextPiece(new TetrominoImpl(TetrominoData.O_COORD, 18, 6, TetrominoData.O_COLOR));
        this.model.nextPiece(new TetrominoImpl(TetrominoData.O_COORD, 18, 8, TetrominoData.O_COLOR));
        this.model.nextPiece(new TetrominoImpl(TetrominoData.O_COORD, 16, 0, TetrominoData.O_COLOR));

        assertEquals(2, this.model.deleteRows());
        assertEquals(1, this.model.getPieces().size());
        assertEquals(Set.of(new Pair<>(18, 0), new Pair<>(18, 1), new Pair<>(19, 0), new Pair<>(19, 1)),
            this.model.getPieces().get(0).getComponents());
        
    }
}
