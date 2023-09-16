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
     * @param x horizontal translation
     * @param y vertical translation
     */
    void translate(int x, int y);

    /**
     * Return a set of coordinates indicating where the tetromino is placed eventually
     * ofsetted by an horizontal and vertical amounts, respectivly x and y.
     *
     * @param x horizontal displacement
     * @param y vertical displacement
     * @return the set of coordinates
     */
    Set<Pair<Integer, Integer>> getComponents(int x, int y);

    /**
     * Return the color assigend to the Tetromino.
     *
     * @return the color as an hexadecimal string
     */
    String getColor();
}
