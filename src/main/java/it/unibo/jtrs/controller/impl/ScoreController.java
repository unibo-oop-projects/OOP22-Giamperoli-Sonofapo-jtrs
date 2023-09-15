package it.unibo.jtrs.controller.impl;

import it.unibo.jtrs.controller.api.Controller;
import it.unibo.jtrs.model.impl.ScoreModel;
import it.unibo.jtrs.utils.Pair;
import it.unibo.jtrs.view.api.SubPanel;
import it.unibo.jtrs.view.impl.ScorePanel;

public class ScoreController extends Controller {

    private final ScoreModel model;
    private final SubPanel view;

    public ScoreController() {
        this.model = new ScoreModel();
        this.view = new ScorePanel(this);
    }

    @Override
    public SubPanel getView() {
        return this.view;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public Pair<Integer, Integer> getStatus() {
        return this.model.getStatus();
    }

    public void evaluate(int lines) {
        this.model.evaluate(lines);
    }

}
