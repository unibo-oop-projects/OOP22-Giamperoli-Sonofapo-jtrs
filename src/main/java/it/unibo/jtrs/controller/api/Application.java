package it.unibo.jtrs.controller.api;
/**
 * An interface modelling a jTetris application. The application must provide a way to
 * update its status, redraw its view and supply the controller it utilises.
 */
public interface Application {

    /**
     * Update the application status.
     */
    void update();

    /**
     * Redraw the application's graphical elements.
     */
    void redraw();

    /**
     * Return the controller which keeps track of the score.
     * 
     * @return the score controller
     */
    Controller getScoreController();

    /**
     * Return the controller which manages the preview (next Tetromino).
     * 
     * @return the preview controller
     */
    Controller getPreviewController();

    /**
     * Return the controllr which manages the game logic.
     * 
     * @return the game controller
     */
    Controller getGameController();
}
