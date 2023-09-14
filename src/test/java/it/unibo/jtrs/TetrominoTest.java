package it.unibo.jtrs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.model.impl.TetrominoImpl;
import it.unibo.jtrs.utils.Pair;

public class TetrominoTest {

	private Tetromino tetromino;
	private final Set<Pair<Integer, Integer>> initialComponents =
		Set.of(new Pair<>(0,0), new Pair<>(0,1), new Pair<>(1,1), new Pair<>(2,1));

	@BeforeEach
	public void init() {
		tetromino = new TetrominoImpl(initialComponents);
	}

	@Test
	public void testRotate() {
		tetromino.rotate();
		assertEquals(tetromino.getComponents(),
			Set.of(new Pair<>(1,2), new Pair<>(1,1), new Pair<>(1,0), new Pair<>(0,2)));
		tetromino.rotate();
		assertEquals(tetromino.getComponents(),
			Set.of(new Pair<>(2,2), new Pair<>(1,1), new Pair<>(2,1), new Pair<>(0,1)));
		tetromino.rotate();
		assertEquals(tetromino.getComponents(),
			Set.of(new Pair<>(1,2), new Pair<>(1,1), new Pair<>(1,0), new Pair<>(2,0)));
		tetromino.rotate();
		assertEquals(tetromino.getComponents(), initialComponents);
	}
	
}
