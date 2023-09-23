package it.unibo.jtrs.game.core.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import it.unibo.jtrs.controller.api.Application;
import it.unibo.jtrs.model.api.GameModel.Interaction;

/**
 * This class is able to detect which directional key is pressed.
 */
public class KeyboardReader implements KeyListener {

    private static final int SCAN_RATE = 50;

    private long millis;
    private final Application application;

    /**
     * Constructor.
     * 
     * @param application the application to send the commands to
     */
    public KeyboardReader(final Application application) {
        this.millis = System.currentTimeMillis();
        this.application = application;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void keyPressed(final KeyEvent e) {

        if (System.currentTimeMillis() - this.millis > SCAN_RATE) {

            this.millis = System.currentTimeMillis();
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                    application.getGameController().advance(Interaction.ROTATE);
                    break;
                case KeyEvent.VK_S:
                    application.getGameController().advance(Interaction.DOWN);
                    break;
                case KeyEvent.VK_A:
                    application.getGameController().advance(Interaction.LEFT);
                    break;
                case KeyEvent.VK_D:
                    application.getGameController().advance(Interaction.RIGHT);
                    break;
                case KeyEvent.VK_SPACE:
                    application.interrupt();
                    break;
                default:
            }
        }
    }

    @Override
    public void keyReleased(final KeyEvent e) { }

    @Override
    public void keyTyped(final KeyEvent e) { }

}
