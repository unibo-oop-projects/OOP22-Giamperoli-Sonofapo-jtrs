package it.unibo.jtrs.game.core.impl;

import it.unibo.jtrs.controller.api.Application;
import it.unibo.jtrs.game.core.api.GameLogic;
import it.unibo.jtrs.game.core.api.KeyboardQuery;
import it.unibo.jtrs.model.api.GameModel.GameState;
import it.unibo.jtrs.model.api.GameModel.Interaction;

/**
 * GameLogic implementation.
 */
public class GameLogicImpl implements GameLogic {

    private final Application application;
    private GameState gameState;

    /**
     * Constructor.
     *
     * @param application the application this logic should operates on
     */
    public GameLogicImpl(final Application application) {
        this.application = application;
        this.gameState = GameState.RUNNING;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isOver() { //non serve piu'
        return this.gameState == GameState.OVER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void timeUpdate() {
        if (!this.application.getGameController().advance(Interaction.DOWN)) {
            final var next = this.application.getPreviewController().getCurrentTetromino();
            if (!this.application.getGameController().changePiece(next)) {
                this.gameState = GameState.OVER;
            } else {
                this.application.getPreviewController().nextTetromino();
            }
        }
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

