package it.unibo.jtrs.model.api;

/**
 * An interface modelling the score of the game.
 */
public interface ScoreModel {

    /**
     * Return the current level.
     *
     * @return the current level
     */
    int getLevel();

    /**
     * Return the game score.
     *
     * @return the score
     */
    int getScore();

    /**
     * Evaluate the game score based on the deleted lines and the current level.
     *
     * @param lines the number of deleted lines
     */
    void evaluate(int lines);

    /**
     * Return the number of deleted lines.
     * 
     * @return the number of lines
     */
    int getLines();
}
