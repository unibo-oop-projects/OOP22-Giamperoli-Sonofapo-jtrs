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
    public void rotate();

    /**
     * Translate the Tetromino by a specific amount.
     *
     * @param x horizontal translation
     * @param y vertical translation
     */
    public void translate(final int x, final int y);

    /**
     * Return a set of coordinates indicating where the tetromino is placed evantyally
     * ofsetted by an horizontal and vertical amounts, respectivly x and y.
     *
     * @param x horizontal displacement
     * @param y vertical displacement
     * @return the set of coordinates
     */
    public Set<Pair<Integer, Integer>> getComponents(final int x, final int y);

    /**
     * Return the color assigend to the Tetromino.
     *
     * @return the color as an hexadecimal string
     */
    public String getColor();
}
