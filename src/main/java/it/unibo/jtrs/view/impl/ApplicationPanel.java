package it.unibo.jtrs.view.impl;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.unibo.jtrs.controller.api.Application;
import it.unibo.jtrs.game.core.inputs.KeyboardReader;

/**
 * A class modelling the main panel to be inserted in a frame.
 */
public class ApplicationPanel extends JPanel {

    private static final int PADDING = 20;

    public static final long serialVersionUID = 4328743;

    private final PreviewPanel previewPanel;
    private final ScorePanel scorePanel;
    private final GamePanel gamePanel;

    /**
     * Constructor.
     *
     * @param application the application this panel should show
     */
    public ApplicationPanel(final Application application) {

        this.previewPanel = new PreviewPanel(application.getPreviewController());
        this.scorePanel = new ScorePanel(application.getScoreController());
        this.gamePanel = new GamePanel(application.getGameController());

        this.setLayout(new GridLayout(1, 2));
        this.setBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING));
        this.setBackground(Color.blue);

        final var panelL = new JPanel(new GridLayout());
        final var panelR = new JPanel(new GridLayout(2, 1));
        panelR.setOpaque(false);
        panelR.add(this.previewPanel);
        panelR.add(this.scorePanel);
        panelL.add(this.gamePanel);

        this.add(panelL);
        this.add(panelR);

        this.addKeyListener(new KeyboardReader(application));
        this.setFocusable(true);
    }

    /**
     * Redraws the application components.
     */
    public void redraw() {
        this.gamePanel.redraw();
        this.previewPanel.redraw();
        this.scorePanel.redraw();
    }
}
