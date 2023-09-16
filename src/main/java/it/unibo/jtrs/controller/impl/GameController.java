package it.unibo.jtrs.controller.impl;

import java.util.List;

import it.unibo.jtrs.controller.api.Controller;
import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.model.impl.GameModel;
import it.unibo.jtrs.utils.Pair;
import it.unibo.jtrs.view.impl.GamePanel;

public class GameController extends Controller {

    private final GameModel model = new GameModel();

    public GameController() {
        this.setView(new GamePanel(this));
    }

    @Override
    public Pair<List<Tetromino>, Integer> getStatus() {
        return new Pair<>(this.model.getPieces(), 1);
    }

    @Override
    public void next(Object o) {
        this.setNext((Tetromino) o);
        this.advance();
    }

    private int advance() {
        return this.model.advance();
    }

    private void setNext(Tetromino next) {
        this.model.setNext(next);;
    }
}
