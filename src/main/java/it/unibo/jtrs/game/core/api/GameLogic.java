package it.unibo.jtrs.game.core.api;

/**
 * An interface modelling how the game should respond to human interaction.
 * The game should be able to run forever until the match is lost and change
 * its state based on how much time has passed.
 */
public interface GameLogic {

    /**
     * Check whether the game is over or not.
     *
     * @return true if game is running, false otherwise
     */
    boolean isOver();

    /**
     * Performs operation based on the flow of time.
     */
    void timeUpdate();

    /**
     * Request an interrupt to the game logic. This should be used to manage
     * tasks like pause, resume or similar.
     */
    void requestInterrupt();

}
