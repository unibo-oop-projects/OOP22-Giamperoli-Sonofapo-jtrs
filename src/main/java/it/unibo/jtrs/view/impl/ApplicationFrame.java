package it.unibo.jtrs.view.impl;

import javax.swing.JFrame;

/**
 * A class representing the main window. The windows is able to provide
 * a KeyboardQuery in order to detect direction key presses.
 */
public class ApplicationFrame extends JFrame {

    public static final long serialVersionUID = 4328743;

    /**
     * Constructor.
     *
     * @param panel the application panel
     */
    public ApplicationFrame(final ApplicationPanel panel) {
        super();

        this.add(panel);

        super.pack();
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
