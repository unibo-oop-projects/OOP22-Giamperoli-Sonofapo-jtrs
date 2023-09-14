package it.unibo.jtrs.model.impl;

import java.util.ArrayList;
import java.util.List;

import it.unibo.jtrs.model.api.Game;
import it.unibo.jtrs.model.api.Tetromino;

public class GameImpl implements Game {

    private List<Tetromino> pieces;
    private Tetromino current;

    public GameImpl() {
        this.pieces = new ArrayList<>();
    }

    public void addPiece() {
        this.pieces.add(current);
        this.current = null; //it will get the next piece
    }

    @Override
    public List<Tetromino> getPieces() {
        return List.copyOf(this.pieces);
    }

    public boolean fallDown() {
        return false;
    }

    public boolean checkCollision() {
        return false;
    }

    @Override
    public boolean isOver() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isOver'");
    }
    
}
