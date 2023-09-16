package it.unibo.jtrs.controller.impl;

import it.unibo.jtrs.controller.api.Controller;
import it.unibo.jtrs.model.impl.ScoreModel;
import it.unibo.jtrs.utils.Pair;
import it.unibo.jtrs.view.impl.ScorePanel;

public class ScoreController extends Controller {

    private final ScoreModel model = new ScoreModel();

    public ScoreController() {
        this.view = new ScorePanel(this);
    }

    @Override
    public Pair<Integer, Integer> getStatus() {
        return this.model.getStatus();
    }

    public void evaluate(int lines) {
        this.model.evaluate(lines);
    }

}
