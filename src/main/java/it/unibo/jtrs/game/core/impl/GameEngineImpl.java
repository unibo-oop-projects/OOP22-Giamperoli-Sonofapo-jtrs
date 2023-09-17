package it.unibo.jtrs.game.core.impl;

import it.unibo.jtrs.controller.api.Application;
import it.unibo.jtrs.game.core.api.GameEngine;

/**
 * GameEngine implementation.
 */
public class GameEngineImpl implements GameEngine {

    private final Application application;

    /**
     * Constructor.
     *
     * @param application the application to manage
     */
    public GameEngineImpl(final Application application) {
        this.application = application;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mainLoop() {
        while (this.application.isRunning()) {
            //draft
            try {
                this.application.update();
                this.application.redraw();
                Thread.sleep(1000);
            } catch (InterruptedException e) { }
        }
    }

}
