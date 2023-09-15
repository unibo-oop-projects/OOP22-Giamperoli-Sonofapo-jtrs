package it.unibo.jtrs.controller.impl;

import it.unibo.jtrs.controller.api.Controller;

public class GameController extends Controller {

    @Override
    public <X> X getStatus() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStatus'");
    }
    

    public int advance() {
        var linee = 3;
        return linee;
    }
}
