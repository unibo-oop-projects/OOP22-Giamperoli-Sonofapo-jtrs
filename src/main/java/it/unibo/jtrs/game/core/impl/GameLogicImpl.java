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
        if (this.application.getGameController().fallDown()) {
            this.application.getGameController().nextPiece(this.application.getPreviewController().getCurrentTetromino());
            this.application.getPreviewController().nextTetromino();
        }
        if (this.application.getGameController().checkPieceCollision()) {
            this.application.getGameController().nextPiece(this.application.getPreviewController().getCurrentTetromino());
            this.application.getPreviewController().nextTetromino();
        }
        this.application.getGameController().advance();
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

