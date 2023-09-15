package it.unibo.jtrs.controller.impl;

import java.util.List;

import it.unibo.jtrs.controller.api.Application;
import it.unibo.jtrs.controller.api.Controller;
import it.unibo.jtrs.controller.api.GameEngine;
import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.utils.Costants;
import it.unibo.jtrs.view.impl.GamePanel;

public class ApplicationImpl implements Application {

    private final GamePanel panel;
    private GameEngine engine;
    private final Controller<Integer> scoreController;
    private final Controller<Tetromino> previewController;
    private final Controller<List<Tetromino>> piecesController;

    public ApplicationImpl() {
		this.engine = new GameEngineImpl(this);
        this.scoreController = null;
        this.previewController = new PreviewController();
        this.piecesController = null;

        this.panel = new GamePanel(Costants.FRAME_WIDTH, Costants.FRAME_HEIGHT, this);
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
    public Controller<Integer> getScoreController() {
        return this.scoreController;
    }

    @Override
    public Controller<Tetromino> getPreviewController() {
        return this.previewController;
    }

    @Override
    public Controller<List<Tetromino>> getPiecesController() {
        return this.piecesController;
    }

}
