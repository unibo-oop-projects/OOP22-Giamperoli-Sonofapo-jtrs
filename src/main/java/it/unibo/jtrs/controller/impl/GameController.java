package it.unibo.jtrs.controller.impl;

import java.util.List;

import it.unibo.jtrs.controller.api.Controller;
import it.unibo.jtrs.model.api.Tetromino;

public class GameController extends Controller {

    @Override
    public List<Tetromino> getStatus() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStatus'");
    }

    public int advance() {
        var linee = 3;
        return linee;
    }

}
