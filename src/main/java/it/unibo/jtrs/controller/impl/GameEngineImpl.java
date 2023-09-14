package it.unibo.jtrs.controller.impl;

import it.unibo.jtrs.controller.api.Application;
import it.unibo.jtrs.controller.api.GameEngine;

public class GameEngineImpl implements GameEngine {

    private final Application application;

    public GameEngineImpl(Application application) {
        this.application = application;
    }

    @Override
    public void gameLoop() {
        //TODO add condition
        while (true) {
            this.application.update();
            this.application.redraw();
        }

        //System.exit(0);

    }
    
}
