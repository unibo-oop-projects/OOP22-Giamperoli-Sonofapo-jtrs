package it.unibo.jtrs.game.core.impl;

import it.unibo.jtrs.controller.api.Application;
import it.unibo.jtrs.controller.impl.GameController;
import it.unibo.jtrs.controller.impl.PreviewController;
import it.unibo.jtrs.controller.impl.ScoreController;
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

    private long millis;
    private GameState gameState;

    // used for code readability purposes
    private final GameController gC;
    private final PreviewController pC;
    private final ScoreController sC;

    /**
     * Constructor.
     *
     * @param application the application this logic should operates on
     */
    public GameLogicImpl(final Application application) {
        this.gC = application.getGameController();
        this.pC = application.getPreviewController();
        this.sC = application.getScoreController();

        this.gC.changePiece(this.pC.getCurrentTetromino());
        this.pC.nextTetromino();
        this.gameState = GameState.PAUSE;
        this.millis = System.currentTimeMillis();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void timeUpdate() {
        final var idleTime = IDLE_RATE - (MIN_IDLE + this.sC.getLevel() * RATE_FACTOR);

        if (this.gameState == GameState.RUNNING 
            && System.currentTimeMillis() - this.millis > Math.max(MIN_IDLE, idleTime)) {

            this.millis = System.currentTimeMillis();
            if (!this.gC.advance(Interaction.DOWN)) {
                this.sC.evaluate(this.gC.deleteRows());
                if (this.gC.changePiece(this.pC.getCurrentTetromino())) {
                    this.pC.nextTetromino();
                } else {
                    this.gameState = GameState.OVER;
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void requestInterrupt() {
        if (this.gameState == GameState.RUNNING) {
            this.gameState = GameState.PAUSE;
        } else if(this.gameState == GameState.PAUSE) {
            this.gameState = GameState.RUNNING;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameState getState() {
        return this.gameState;
    }
}

