package it.unibo.jtrs.game.core.impl;

import it.unibo.jtrs.controller.api.Application;
import it.unibo.jtrs.game.core.api.GameLogic;
import it.unibo.jtrs.model.api.GameModel.GameState;
import it.unibo.jtrs.model.api.GameModel.Interaction;

/**
 * GameLogic implementation.
 */
public class GameLogicImpl implements GameLogic {

    private static final int IDLE_RATE = 800;
    private static final int MIN_IDLE = 150;
    private static final int RATE_FACTOR = 50;

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
        final var idleTime = IDLE_RATE - (MIN_IDLE + this.application.getScoreController().getLevel() * RATE_FACTOR);
        if (System.currentTimeMillis() - this.millis > Math.max(MIN_IDLE, idleTime)) {
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

}

