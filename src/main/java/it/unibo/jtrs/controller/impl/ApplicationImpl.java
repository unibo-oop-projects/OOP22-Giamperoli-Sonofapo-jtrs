package it.unibo.jtrs.controller.impl;

import it.unibo.jtrs.controller.api.Application;
import it.unibo.jtrs.controller.api.GameEngine;
import it.unibo.jtrs.view.impl.ApplicationPanel;

/**
 * Application implementation.
 */
public class ApplicationImpl implements Application {

    private final ApplicationPanel panel;
    private final GameEngine engine;
    private final ScoreController sC = new ScoreController();
    private final PreviewController pC = new PreviewController();
    private final GameController gC = new GameController();

    /**
     * Constructor.
     */
    public ApplicationImpl() {

        this.panel = new ApplicationPanel(this);
        this.engine = new GameEngineImpl(this);
        this.engine.gameLoop();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isRunning() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void redraw() {
        this.panel.redraw();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ScoreController getScoreController() {
        return this.sC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PreviewController getPreviewController() {
        return this.pC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameController getGameController() {
        return this.gC;
    }

}
