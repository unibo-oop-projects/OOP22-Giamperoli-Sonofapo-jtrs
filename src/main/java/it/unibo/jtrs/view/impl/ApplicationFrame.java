package it.unibo.jtrs.view.impl;

import javax.swing.JFrame;

import it.unibo.jtrs.game.core.api.KeyboardQuery;
import it.unibo.jtrs.game.core.impl.KeyboardReader;

/**
 * A class representing the main window. The windows is able to provide
 * a KeyboardQuery in order to detect direction key presses.
 */
public class ApplicationFrame extends JFrame {

    private static final int FRAME_W = 800;
    private static final int FRAME_H = 800;

    public static final long serialVersionUID = 4328743;

    private final transient KeyboardReader keyboard;

    /**
     * Constructor.
     *
     * @param panel the application panel
     */
    public ApplicationFrame(final ApplicationPanel panel) {
        super();

        this.keyboard = new KeyboardReader();

        this.add(panel);

        this.setVisible(true);
        this.setResizable(false);
        this.setSize(FRAME_W, FRAME_H);
        this.addKeyListener(this.keyboard);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Get a KeyboardQuery of this window.
     *
     * @return the keyboard
     */
    public KeyboardQuery getKeyboard() {
        return this.keyboard;
    }

}
