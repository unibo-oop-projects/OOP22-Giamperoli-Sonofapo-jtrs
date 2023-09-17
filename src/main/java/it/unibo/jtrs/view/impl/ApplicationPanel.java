package it.unibo.jtrs.view.impl;

import java.awt.GridLayout;

import javax.swing.JPanel;

import it.unibo.jtrs.controller.api.Application;

/**
 * A class modelling the main panel to be inserted in a frame.
 */
public class ApplicationPanel extends JPanel {

    public static final long serialVersionUID = 4328743;

    private final PreviewPanel preview;

    /**
     * Constructor.
     *
     * @param application the application this panel should show
     */
    public ApplicationPanel(final Application application) {

        this.preview = new PreviewPanel(application.getPreviewController());

        this.setLayout(new GridLayout());
        this.add(this.preview);
    }

    /**
     * Redraws the application components.
     */
    public void redraw() {
        this.preview.redraw();
    }
}
