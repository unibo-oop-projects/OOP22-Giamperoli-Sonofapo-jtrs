package it.unibo.jtrs.view.impl;

import java.awt.GridLayout;

import javax.swing.JPanel;

import it.unibo.jtrs.controller.api.Application;

/**
 * A class modelling the main panel to be inserted in a frame.
 */
public class ApplicationPanel extends JPanel {

    public static final long serialVersionUID = 4328743;

    private final PreviewPanel previewPanel;
    private final ScorePanel scorePanel;
    private final GamePanel gamePanel;

    public ApplicationPanel(final int width, final int height, final Application application) {

        this.previewPanel = new PreviewPanel(application.getPreviewController());
        this.scorePanel = new ScorePanel(application.getScoreController());
        this.gamePanel = new GamePanel(application.getGameController());

        this.setLayout(new GridLayout());
        this.add(this.previewPanel);
        this.add(this.scorePanel);
        this.add(this.gamePanel);
    }

    /**
     * Redraws the application components.
     */
    public void redraw() {
        this.gamePanel.redraw();;
        this.previewPanel.redraw();
        this.scorePanel.redraw();
    }
}
