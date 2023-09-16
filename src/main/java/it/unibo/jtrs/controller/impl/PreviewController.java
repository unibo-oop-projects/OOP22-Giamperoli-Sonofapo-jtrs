package it.unibo.jtrs.controller.impl;

import it.unibo.jtrs.controller.api.Controller;
import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.model.impl.PreviewModel;
import it.unibo.jtrs.view.impl.PreviewPanel;

/**
 * This class models basic functionalities a PreviewController must have.
 * This controller should be able to work with its view and model in order to provide
 * the next Tetromino to show during the game.
 */
public class PreviewController extends Controller {

    private final PreviewModel model = new PreviewModel();

    /**
     * Constructor.
     */
    public PreviewController() {
        this.view = new PreviewPanel(this);
    }

    @Override
    public Tetromino getStatus() {
        return this.model.next();
    }

}
