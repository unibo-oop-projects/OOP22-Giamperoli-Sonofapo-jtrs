package it.unibo.jtrs.controller.impl;

import it.unibo.jtrs.controller.api.Application;
import it.unibo.jtrs.game.core.api.GameLogic;
import it.unibo.jtrs.game.core.impl.GameEngineImpl;
import it.unibo.jtrs.game.core.impl.GameLogicImpl;
import it.unibo.jtrs.view.impl.ApplicationFrame;
import it.unibo.jtrs.view.impl.ApplicationPanel;

/**
 * Application implementation.
 */
public class ApplicationImpl implements Application {

    private final GameLogic logic;
    private final ApplicationPanel panel;
    private final ApplicationFrame frame;
    private final ScoreController sC = new ScoreController();
    private final PreviewController pC = new PreviewController();
    private final GameController gC = new GameController();

    /**
     * Constructor.
     */
    public ApplicationImpl() {

        this.logic = new GameLogicImpl(this);
        this.panel = new ApplicationPanel(this);
        this.frame = new ApplicationFrame(this.panel);
        (new GameEngineImpl(this)).mainLoop();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
        this.logic.keyboardUpdate(this.frame.getKeyboard());
        this.logic.timeUpdate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isRunning() {
        return !this.logic.isOver();
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
