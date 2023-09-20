package it.unibo.jtrs.model.api;

import java.util.Set;

import it.unibo.jtrs.utils.Pair;

/**
 * An interface modelling the most important piece of the game, the Tetromino.
 */
public interface Tetromino {

    /**
     * Rotate the Tetromino 90 degrees clockwise on its center of gravity.
     */
    void rotate();

    /**
     * Translate the Tetromino by a specific amount.
     *
     * @param x vertical translation
     * @param y horizontal translation
     */
    void translate(int x, int y);

    /**
     * Returns a set of coordinates indicating where the Tetromino is placed.
     * 
     * @return the set of coordinates
     */
    Set<Pair<Integer, Integer>> getComponents();

    /**
     * Return the color assigend to the Tetromino.
     *
     * @return the color as an hexadecimal string
     */
    String getColor();

    /**
     * Create a copy of the Tetromino.
     * 
     * @return the copy
     */
    Tetromino copy();
}
