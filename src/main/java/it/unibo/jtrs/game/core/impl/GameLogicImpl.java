package it.unibo.jtrs.game.core.impl;

import it.unibo.jtrs.controller.api.Application;
import it.unibo.jtrs.game.core.api.GameLogic;
import it.unibo.jtrs.game.core.api.KeyboardQuery;

public class GameLogicImpl implements GameLogic{

    private final Application application;

    /**
     * Constructor.
     *
     * @param pC the preview controller
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

