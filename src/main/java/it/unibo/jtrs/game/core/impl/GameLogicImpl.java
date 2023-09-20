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
    private long millis;

    /**
     * Constructor.
     *
     * @param application the application this logic should operates on
     */
    public GameLogicImpl(final Application application) {
        this.application = application;
        this.gameState = GameState.RUNNING;
        this.millis = System.currentTimeMillis();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isOver() {
        return this.gameState == GameState.OVER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void timeUpdate() {
        if (System.currentTimeMillis() - this.millis > 600 - 100 * this.application.getScoreController().getLevel()) {
            this.millis = System.currentTimeMillis();

            if (!this.application.getGameController().advance(Interaction.DOWN)) {

                final var countRemoved = this.application.getGameController().deleteRows();
                this.application.getScoreController().evaluate(countRemoved);

                final var next = this.application.getPreviewController().getCurrentTetromino();
                if (!this.application.getGameController().changePiece(next)) {
                    this.gameState = GameState.OVER;
                } else {
                    this.application.getPreviewController().nextTetromino();
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void keyboardUpdate(final KeyboardQuery keyboard) {

        if (keyboard.isUpPressed()) {
            this.application.getGameController().advance(Interaction.ROTATE);
        }
        if (keyboard.isLeftPressed()) {
            this.application.getGameController().advance(Interaction.LEFT);
        }
        if (keyboard.isRightPressed()) {
            this.application.getGameController().advance(Interaction.RIGHT);
        }
        if (keyboard.isDownPressed()) {
            this.application.getGameController().advance(Interaction.DOWN);
        }
    }

}

