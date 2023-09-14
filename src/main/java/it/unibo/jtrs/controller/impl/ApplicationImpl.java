package it.unibo.jtrs.controller.impl;

import it.unibo.jtrs.controller.api.Application;
import it.unibo.jtrs.controller.api.GameEngine;
import it.unibo.jtrs.view.api.GamePanel;
import it.unibo.jtrs.view.impl.GamePanelImpl;

public class ApplicationImpl implements Application {

    private final GamePanel panel;
    private GameEngine engine;

    public ApplicationImpl() {
        this.panel = new GamePanelImpl(1000, 1000);
    }

    @Override
    public void start() {
        this.engine = new GameEngineImpl();
    }

    @Override
    public void updateGameView() {
        this.panel.redraw();
    }
    
}
