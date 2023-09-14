package it.unibo.jtrs.view.impl;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import it.unibo.jtrs.controller.api.Application;
import it.unibo.jtrs.view.api.GamePanel;

public class GamePanelImpl extends JFrame implements GamePanel {

    private final Application application;

    public GamePanelImpl(final int width, final int height, final Application application) {
        this.application = application;
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.setTitle("jTetris");
        this.setResizable(false);
        this.setVisible(true);

        JPanel background = new JPanel(new GridLayout(1,2));
        background.add(new ScorePanel(this.application.getScoreController()));
        
        this.getContentPane().add(background);
    }

    @Override
    public void redraw() {
    }
    
}
