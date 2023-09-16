package it.unibo.jtrs.controller.impl;

import it.unibo.jtrs.controller.api.Application;
import it.unibo.jtrs.controller.api.Controller;
import it.unibo.jtrs.controller.api.GameEngine;
import it.unibo.jtrs.utils.Constants;
import it.unibo.jtrs.view.impl.ApplicationPanel;

public class ApplicationImpl implements Application {

    private final ApplicationPanel panel;
    private final GameEngine engine;
    private final ScoreController sC = new ScoreController();
    private final PreviewController pC = new PreviewController();
    private final GameController gC = new GameController();

    public ApplicationImpl() {
        this.panel = new ApplicationPanel(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT, this);
        this.engine = new GameEngineImpl(this);
        this.engine.gameLoop();
    }

    @Override
    public void update() {
        pC.next(null); // preview update
        var next = this.pC.getStatus(); // Tetromino to add into grid
        this.gC.next(next); // add to grid
        var res = this.gC.getStatus().getY();
        this.sC.next(res); // update score
    }

    @Override
    public void redraw() {
        this.panel.redraw();
    }

    @Override
    public Controller getScoreController() {
        return this.sC;
    }

    @Override
    public Controller getPreviewController() {
        return this.pC;
    }

    @Override
    public Controller getGameController() {
        return this.gC;
    }

}
