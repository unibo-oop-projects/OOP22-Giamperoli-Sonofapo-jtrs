package it.unibo.jtrs.game.core.impl;

import it.unibo.jtrs.controller.impl.PreviewController;
import it.unibo.jtrs.game.core.api.GameLogic;
import it.unibo.jtrs.game.core.api.KeyboardQuery;

public class GameLogicImpl implements GameLogic{

    private final PreviewController pC;

    /**
     * Constructor.
     *
     * @param pC the preview controller
     */
    public GameLogicImpl(final PreviewController pC) {
       this.pC = pC;
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
            pC.nextTetromino();
        }
    }

}

