package it.unibo.jtrs.view.impl;

import javax.swing.JFrame;

import it.unibo.jtrs.game.core.api.KeyboardQuery;
import it.unibo.jtrs.game.core.impl.KeyboardReader;

/**
 * A class representing the main window. The windows is able to provide
 * a KeyboardQuery in order to detect direction key presses.
 */
public class ApplicationFrame extends JFrame {

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

        super.pack();
        this.setVisible(true);
        this.setResizable(false);
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
