package it.unibo.jtrs.model.impl;

import it.unibo.jtrs.utils.Pair;

public class ScoreModel {

    private static final int LEVEL_FACTOR = 10;

    private int level;
    private int score;
    private int deletedLines;

    /**
     * Constructor.
     */
    public ScoreModel() {
        this.level = 0;
        this.score = 0;
        this.deletedLines = 0;
    }

    public Pair<Integer, Integer> getStatus() {
        return new Pair<>(this.level, this.score);
    }

    public int getLevel() {
        return this.level;
    }

    public int getScore() {
        return this.score;
    }

    public void evaluate(final int lines) {
        this.deletedLines = this.deletedLines + lines;
        this.setLevel();
        switch (lines) {
            case 1:
                this.score = this.score + 40 * (this.level + 1);
                break;
            case 2:
                this.score = this.score + 100 * (this.level + 1);
                break;
            case 3:
                this.score = this.score + 300 * (this.level + 1);
                break;
            case 4:
                this.score = this.score + 1200 * (this.level + 1);
                break;
        }
    }

    private void setLevel() {
        this.level = this.deletedLines / ScoreModel.LEVEL_FACTOR;
    }

}
