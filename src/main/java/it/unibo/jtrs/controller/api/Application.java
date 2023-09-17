package it.unibo.jtrs.controller.api;

import it.unibo.jtrs.controller.impl.GameController;
import it.unibo.jtrs.controller.impl.PreviewController;
import it.unibo.jtrs.controller.impl.ScoreController;

/**
 * An interface modelling an application. An application should be able to update
 * its state and its graphics. The application should be also able to tell whether is
 * running or not.
 */
public interface Application {

    /**
     * Update application logic.
     */
    void update();

    /**
     * Update graphical component.
     */
    void redraw();

    /**
     * Check the application running status.
     *
     * @return true if running, false otherwise
     */
    boolean isRunning();

    /**
     * Returns the score controller.
     *
     * @return the controller
     */
    ScoreController getScoreController();

    /**
     * Returns the preview controller.
     *
     * @return the controller
     */
    PreviewController getPreviewController();

    /**
     * Return the game controller.
     *
     * @return the controller
     */
    GameController getGameController();
}
