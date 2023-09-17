package it.unibo.jtrs.controller.impl;

import it.unibo.jtrs.controller.api.Application;
import it.unibo.jtrs.controller.api.GameEngine;
import it.unibo.jtrs.view.impl.ApplicationPanel;

public class ApplicationImpl implements Application {

    private static final int FRAME_WIDTH = 900;
    private static final int FRAME_HEIGHT = 900;

    private final ApplicationPanel panel;
    private final GameEngine engine;
    private final ScoreController sC = new ScoreController();
    private final PreviewController pC = new PreviewController();
    private final GameController gC = new GameController();

    public ApplicationImpl() {
        this.panel = new ApplicationPanel(FRAME_WIDTH, FRAME_HEIGHT, this);
        this.engine = new GameEngineImpl(this);
        this.engine.gameLoop();
    }

    @Override
    public void update() {
    }

    @Override
    public void redraw() {
        this.panel.redraw();
    }

    @Override
    public ScoreController getScoreController() {
        return this.sC;
    }

    @Override
    public PreviewController getPreviewController() {
        return this.pC;
    }

    @Override
    public GameController getGameController() {
        return this.gC;
    }

}
