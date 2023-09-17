package it.unibo.jtrs.game.core.api;

/**
 * An interface modelling a game engine. The engine must create a game loop and run
 * it until the application has finished its operations.
 */
public interface GameEngine {

    /**
     * Start the engine gameloop.
     */
    void mainLoop();
}
