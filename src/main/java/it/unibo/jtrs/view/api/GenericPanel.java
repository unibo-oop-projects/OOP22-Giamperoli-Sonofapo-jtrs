package it.unibo.jtrs.view.api;

import javax.swing.JPanel;

/**
 * A class that models a generic panel which has to be redrawn.
 */
public abstract class GenericPanel extends JPanel {

    /**
     * Redraw the panel.
     */
    public abstract void redraw();
}
