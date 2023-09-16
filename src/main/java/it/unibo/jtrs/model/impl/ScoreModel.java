package it.unibo.jtrs.model.impl;

import it.unibo.jtrs.utils.Pair;

public class ScoreModel {

    private static final int LEVEL_FACTOR = 10;

    private int level;
    private int score;
    private int deletedLines;

    public ScoreModel() {
        this.level = 0;
        this.score = 0;
        this.deletedLines = 0;
    }

    public Pair<Integer, Integer> getStatus() {
        return new Pair<>(this.level, this.score);
    }

    public void evaluate(final int lines) {
        this.deletedLines = this.deletedLines + lines;
        this.setLevel();
    }

    private void setLevel() {
        this.level = this.deletedLines / ScoreModel.LEVEL_FACTOR;
    }

}
