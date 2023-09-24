package it.unibo.jtrs.game.core.impl;

import it.unibo.jtrs.controller.api.Application;
import it.unibo.jtrs.game.core.api.GameEngine;
import it.unibo.jtrs.utils.AudioEngine;

/**
 * GameEngine implementation.
 */
public class GameEngineImpl implements GameEngine {

    private static final int FRAMES = 60;
    private static final long PERIOD = (long) (1.0 / GameEngineImpl.FRAMES * 1000);

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
        AudioEngine.load("track-a.wav");
        while (this.application.isRunning()) {
            try {
                this.application.update();
                this.application.redraw();
                Thread.sleep(GameEngineImpl.PERIOD);
            } catch (InterruptedException e) { }
        }
        AudioEngine.stop();
        System.exit(0);
    }

}
