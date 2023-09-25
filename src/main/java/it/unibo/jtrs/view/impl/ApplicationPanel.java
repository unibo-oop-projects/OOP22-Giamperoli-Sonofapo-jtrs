package it.unibo.jtrs.view.impl;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JLayeredPane;
import javax.swing.OverlayLayout;

import it.unibo.jtrs.controller.api.Application;
import it.unibo.jtrs.game.core.inputs.KeyboardReader;
import it.unibo.jtrs.model.api.GameModel.GameState;
import it.unibo.jtrs.utils.ResourceLoader;
import it.unibo.jtrs.view.api.GenericPanel;
import it.unibo.jtrs.view.custom.Constants;

/**
 * A class modelling the main panel to be inserted in a frame.
 */
public class ApplicationPanel extends JLayeredPane {

    public static final long serialVersionUID = 4328743;

    private final transient Application application;

    private transient BufferedImage background;
    private final List<GenericPanel> panels = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param application the application this panel should show
     */
    public ApplicationPanel(final Application application) {
        this.setLayout(new OverlayLayout(this));

        this.application = application;
        final int offset = (int) (super.getSize().height * Constants.ApplicationPanel.HEIGHT_OFFSET);

        this.panels.add(GameState.START.ordinal(), new StartPanel());
        this.panels.add(GameState.RUNNING.ordinal(), new MainPanel(application));
        this.panels.add(GameState.PAUSE.ordinal(), new MessagePanel("PAUSE", "Press SPACE to resume", offset));
        this.panels.add(GameState.OVER.ordinal(), new MessagePanel("GAME OVER", "Press ESC to exit the game", offset));

        for (final GameState s : GameState.values()) {
            final var i = s.ordinal();
            this.panels.get(i).setVisible(false);
            this.add(this.panels.get(i), i);
        }

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
        final var state = this.application.getState();
        this.setActiveLayer(state.ordinal());
        if (state == GameState.RUNNING) {
            this.panels.get(state.ordinal()).redraw();
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

    private void setActiveLayer(final int layer) {
        for (int i = 0; i < this.panels.size(); i++) {
            this.panels.get(i).setVisible(i == layer);
        }
    }
}
