package it.unibo.jtrs.view.impl;

import java.awt.Color;

import it.unibo.jtrs.view.api.GenericPanel;

/**
 * This class model the start panel presented to the user a te beginning
 * of the game.
 */
public class StartPanel extends GenericPanel {

    public static final long serialVersionUID = 4328743;

    /**
     * Constructor.
     */
    public StartPanel() {
        this.setBackground(Color.DARK_GRAY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void redraw() { }

}
