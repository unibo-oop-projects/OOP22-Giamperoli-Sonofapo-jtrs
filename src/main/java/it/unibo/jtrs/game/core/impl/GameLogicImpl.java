package it.unibo.jtrs.game.core.impl;

import it.unibo.jtrs.controller.api.Application;
import it.unibo.jtrs.game.core.api.GameLogic;
import it.unibo.jtrs.game.core.api.KeyboardQuery;

/**
 * GameLogic implementation.
 */
public class GameLogicImpl implements GameLogic {

    private final Application application;

    /**
     * Constructor.
     *
     * @param application the application this logic should operates on
     */
    public GameLogicImpl(final Application application) {
       this.application = application;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isOver() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void timeUpdate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void keyboardUpdate(final KeyboardQuery keyboard) {
        if (keyboard.isUpPressed()) {
            application.getPreviewController().nextTetromino();
        }
    }

}

