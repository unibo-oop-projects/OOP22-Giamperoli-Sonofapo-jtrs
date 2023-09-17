package it.unibo.jtrs.game.core.api;

/**
 * An interface modelling whether the direction keys are pressed or not.
 */
public interface KeyboardQuery {

    /**
     * Check whether the up key is pressed.
     *
     * @return true if pressed, false otherwise
     */
    boolean isUpPressed();

    /**
     * Check whether the down key is pressed.
     *
     * @return true if pressed, false otherwise
     */
    boolean isDownPressed();

    /**
     * Check whether the left key is pressed.
     *
     * @return true if pressed, false otherwise
     */
    boolean isLeftPressed();

    /**
     * Check whether the down right is pressed.
     *
     * @return true if pressed, false otherwise
     */
    boolean isRightPressed();
}
