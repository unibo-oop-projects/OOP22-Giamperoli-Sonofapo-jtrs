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
     * Delete all the components from a Tetromino that are horizontally located
     * on the given position. Eventually split the Tetromino in smaller components
     * and return them as a set. If the Tetromino has no component in that position,
     * it is returned as is.
     * 
     * @param position the components' position to remove
     * @return the Tetromino, eventually splitted
     */
    Set<Tetromino> delete(int position);

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
