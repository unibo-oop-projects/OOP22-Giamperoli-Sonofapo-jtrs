package it.unibo.jtrs.controller.impl;

import it.unibo.jtrs.model.impl.ScoreModel;

public class ScoreController {

    private final ScoreModel model;

    public ScoreController() {
        this.model = new ScoreModel();
    }

    public int getLevel() {
        return this.model.getLevel();
    }

    public int getScore() {
        return this.model.getScore();
    }

    public void evaluate(final int lines) {
        this.model.evaluate(lines);
    }
}
