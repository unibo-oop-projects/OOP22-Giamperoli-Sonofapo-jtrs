package it.unibo.jtrs.model.api;

/**
 * An interface modelling the score of the game.
 */
public interface ScoreModel {

    /**
     * Returns the current level.
     *
     * @return the current level
     */
    int getLevel();

    /**
     * Returns the game score.
     *
     * @return the score
     */
    int getScore();

    /**
     * Evaluates the game score based on the deleted lines and the current level.
     *
     * @param lines the number of deleted lines
     */
    void evaluate(int lines);
}
