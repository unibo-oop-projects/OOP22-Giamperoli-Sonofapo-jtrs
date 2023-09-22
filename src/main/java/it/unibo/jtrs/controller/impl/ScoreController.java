package it.unibo.jtrs.controller.impl;

import it.unibo.jtrs.model.impl.ScoreModelImpl;

/**
 * ScoreController implementation.
 */
public class ScoreController {

    private final ScoreModelImpl model;

    /**
     * Constructor.
     */
    public ScoreController() {
        this.model = new ScoreModelImpl();
    }

    /**
     * Return the current level.
     *
     * @return the current level
     */
    public int getLevel() {
        return this.model.getLevel();
    }

    /**
     * Return the score.
     *
     * @return the score
     */
    public int getScore() {
        return this.model.getScore();
    }

    /**
     * Evaluate a new score based on the number of lines completed.
     *
     * @param lines the number of lines
     */
    public void evaluate(final int lines) {
        this.model.evaluate(lines);
    }

    /**
     * Return the number of deleted rows.
     * 
     * @return the number of rows
     */
    public int returnRemoved() {
        return this.model.getLines();
    }
}
