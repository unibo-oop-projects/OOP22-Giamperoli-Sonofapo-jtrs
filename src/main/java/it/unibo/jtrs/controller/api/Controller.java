package it.unibo.jtrs.controller.api;

import it.unibo.jtrs.view.api.SubPanel;

/**
 * An abstract class modelling a controller. Each controller must be able to provide
 * the view it is operating on and the current status of the model
 */
public abstract class Controller {

    /**
     * The view the controller is operating on.
     */
    protected SubPanel view;

    /**
     * Returns an object representing the current model status. This method
     * should be implemented through covariant return type to narrow down the
     * correct object instance.
     *
     * @return the status of the model
     */
    public abstract Object getStatus();

    /**
     * Return the view this controller is operating on.
     *
     * @return the view
     */
    public SubPanel getView() {
        return this.view;
    }
}
