package it.unibo.jtrs.controller.impl;

import it.unibo.jtrs.controller.api.Application;
import it.unibo.jtrs.controller.api.Controller;
import it.unibo.jtrs.controller.api.GameEngine;
import it.unibo.jtrs.utils.Constants;
import it.unibo.jtrs.view.impl.GamePanel;

public class ApplicationImpl implements Application {

    private final GamePanel panel;
    private final GameEngine engine;
    private final Controller sC = new ScoreController();
    private final Controller pC = new PreviewController();
    private final Controller gC = new GameController();

    public ApplicationImpl() {
        this.panel = new GamePanel(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT, this);
        this.engine = new GameEngineImpl(this);
        this.engine.gameLoop();
    }

    @Override
    public void update() {
        //will deal with most of the work
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
