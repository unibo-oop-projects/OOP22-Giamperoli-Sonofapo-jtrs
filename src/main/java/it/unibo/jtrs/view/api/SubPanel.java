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
    private final Controller controller;

    /**
     * Create a new SubPanel.
     * 
     * @param controller the controller this view should use
     */
    public SubPanel(final Controller controller) {
        this.controller = controller;
    }

    /**
     * Updates all the components in this view.
     */
    public abstract void update();

    /**
     * Return the current controller.
     * 
     * @return the controller
     */
    protected Controller getController() {
        return this.controller;
    }
}
