package it.unibo.jtrs.controller.impl;

import it.unibo.jtrs.controller.api.Application;
import it.unibo.jtrs.controller.api.GameEngine;
import it.unibo.jtrs.utils.Costants;
import it.unibo.jtrs.view.api.GamePanel;
import it.unibo.jtrs.view.impl.GamePanelImpl;

public class ApplicationImpl implements Application {

    private final GamePanel panel;
    private GameEngine engine;

    public ApplicationImpl() {
        this.panel = new GamePanelImpl(Costants.FRAME_WIDTH, Costants.FRAME_HEIGHT, this);
        this.engine = new GameEngineImpl(this);
        this.engine.gameLoop();
    }

    @Override
    public void update() {
    }

    @Override
    public void redraw() {
        this.panel.redraw();
    }

}
