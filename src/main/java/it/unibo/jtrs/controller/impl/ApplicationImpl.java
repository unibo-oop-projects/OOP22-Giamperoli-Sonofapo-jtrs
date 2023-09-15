package it.unibo.jtrs.controller.impl;

import it.unibo.jtrs.controller.api.Application;
import it.unibo.jtrs.controller.api.Controller;
import it.unibo.jtrs.controller.api.GameEngine;
import it.unibo.jtrs.utils.Constants;
import it.unibo.jtrs.view.impl.GamePanel;

public class ApplicationImpl implements Application {

    private final GamePanel panel;
    private GameEngine engine;
    private final Controller scoreController;
    private final Controller previewController;
    private final Controller piecesController;

    public ApplicationImpl() {
		this.engine = new GameEngineImpl(this);
        this.scoreController = new ScoreController();
        this.previewController = new PreviewController();
        this.piecesController = new GameController();

        this.panel = new GamePanel(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT, this);
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
        return this.scoreController;
    }

    @Override
    public Controller getPreviewController() {
        return this.previewController;
    }

    @Override
    public Controller getGameController() {
        return this.piecesController;
    }

}
