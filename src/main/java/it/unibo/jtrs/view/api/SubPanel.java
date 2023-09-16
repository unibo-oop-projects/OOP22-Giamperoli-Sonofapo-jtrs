package it.unibo.jtrs.view.api;

import javax.swing.JPanel;

import it.unibo.jtrs.controller.api.Controller;
/**
 * An abstract class representing a view. Each view update is based on a specific
 * controller and is able to update its state.
 */
public abstract class SubPanel extends JPanel {

    /**
     * The controller this view uses to perform its updates.
     */
    protected final Controller controller;

    /**
     * Create a Sub
     * @param controller
     */
    public SubPanel(Controller controller) {
        this.controller = controller;
    }

    /**
     * Updates all the components in this view.
     */
    public abstract void update();
}
