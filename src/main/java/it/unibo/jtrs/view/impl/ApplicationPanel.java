package it.unibo.jtrs.view.impl;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import it.unibo.jtrs.controller.api.Application;

public class ApplicationPanel extends JFrame {

    private final PreviewPanel previewPanel;
    private final ScorePanel scorePanel;
    private final GamePanel gamePanel;

    public ApplicationPanel(final int width, final int height, final Application application) {
        this.previewPanel = new PreviewPanel(application.getPreviewController());
        this.scorePanel = new ScorePanel(application.getScoreController());
        this.gamePanel = new GamePanel(application.getGameController());

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setTitle("jTetris");
        this.setResizable(false);
        this.setVisible(true);

        final JPanel background = new JPanel(new GridLayout(1, 2));
        background.add(this.gamePanel);

        final JPanel side = new JPanel(new GridLayout(2, 1));
        side.add(this.previewPanel);
        side.add(this.scorePanel);
        background.add(side);

        this.getContentPane().add(background);
    }

    public void redraw() {
        this.gamePanel.redraw();;
        this.previewPanel.redraw();
        this.scorePanel.redraw();
    }

}
