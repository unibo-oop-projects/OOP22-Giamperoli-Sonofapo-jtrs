package it.unibo.jtrs.view.impl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import it.unibo.jtrs.controller.api.Application;
import it.unibo.jtrs.game.core.inputs.KeyboardReader;
import it.unibo.jtrs.utils.ResourceLoader;
import it.unibo.jtrs.view.custom.Constants;
import it.unibo.jtrs.view.custom.Label;

/**
 * A class modelling the main panel to be inserted in a frame.
 */
public class ApplicationPanel extends JPanel {

    public static final long serialVersionUID = 4328743;

    private final transient Application application;
    private final PreviewPanel previewPanel;
    private final ScorePanel scorePanel;
    private final GamePanel gamePanel;
    private transient BufferedImage background;

    /**
     * Constructor.
     *
     * @param application the application this panel should show
     */
    public ApplicationPanel(final Application application) {
        this.application = application;

        this.previewPanel = new PreviewPanel(this.application.getPreviewController());
        this.scorePanel = new ScorePanel(this.application.getScoreController());
        this.gamePanel = new GamePanel(this.application.getGameController());

        this.setLayout(new GridLayout(1, 2));
        this.setBorder(new EmptyBorder(Constants.ApplicationPanel.PADDING,
            Constants.ApplicationPanel.PADDING,
            Constants.ApplicationPanel.PADDING,
            Constants.ApplicationPanel.PADDING));
        this.setBackground(Color.DARK_GRAY);

        final var panelL = new JPanel(new GridLayout());
        final var panelR = new JPanel(new GridLayout(2, 1));
        panelL.setOpaque(false);
        panelR.setOpaque(false);
        panelR.add(this.previewPanel);
        panelR.add(this.scorePanel);
        panelL.add(this.gamePanel);

        this.add(panelL);
        this.add(panelR);

        this.addKeyListener(new KeyboardReader(this.application));
        this.setFocusable(true);

        try {
            this.background = ImageIO.read(ResourceLoader.loadAsStream("background.jpg"));
        } catch (IOException e) {
            this.background = null;
        }
    }

    /**
     * Redraws the application components.
     */
    public void redraw() {
        switch (this.application.getState()) {
            case RUNNING:
                this.gamePanel.redraw();
                this.previewPanel.redraw();
                this.scorePanel.redraw();
                break;
            case PAUSE:
            //TODO
                break;
            case OVER:
                this.gameover();
                break;
            default:
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        if (this.background != null) {
            g.drawImage(this.background, 0, 0, this);
        }
    }

    private void gameover() {
        final int offset = (int) (this.getSize().height * Constants.ApplicationPanel.HEIGHT_OFFSET);
        this.removeAll();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(Box.createVerticalStrut(offset));

        final JLabel l1 = new Label("GAME OVER", Constants.ApplicationPanel.GAME_OVER_SIZE);
        l1.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        this.add(l1);
        this.add(Box.createVerticalStrut(Constants.ApplicationPanel.INTERLINE));

        final JLabel l2 = new Label("Press ESC to close the game", Constants.ApplicationPanel.EXIT_TEXT_SIZE);
        l2.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        this.add(l2);

        this.repaint();
        this.validate();
    }
}
