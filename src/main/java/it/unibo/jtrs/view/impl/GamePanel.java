package it.unibo.jtrs.view.impl;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import it.unibo.jtrs.controller.api.Application;
import it.unibo.jtrs.view.api.SubPanel;

public class GamePanel extends JFrame {

    private final Application application;
	private final SubPanel previewPanel;
    private final SubPanel scorePanel;

    public GamePanel(final int width, final int height, final Application application) {
        this.application = application;
		this.previewPanel = application.getPreviewController().getView();
        this.scorePanel = application.getScoreController().getView();
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setTitle("jTetris");
        this.setResizable(false);
        this.setVisible(true);

        JPanel background = new JPanel(new GridLayout(1,2));
		background.add(new JPanel()); // main game

		JPanel side = new JPanel(new GridLayout(2,1));
		side.add(this.previewPanel);
        side.add(this.scorePanel);
		background.add(side);
        
        this.getContentPane().add(background);
    }

    public void redraw() {
        this.previewPanel.update();
        this.scorePanel.update();
    }
    
}
