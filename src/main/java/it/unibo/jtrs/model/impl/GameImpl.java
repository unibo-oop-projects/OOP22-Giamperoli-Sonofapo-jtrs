package it.unibo.jtrs.model.impl;

import java.util.ArrayList;
import java.util.List;

import it.unibo.jtrs.model.api.Game;
import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.model.api.TetrominoFactory;

public class GameImpl implements Game {

    private List<Tetromino> pieces;
    private Tetromino current;
    private TetrominoFactory factory;

    public GameImpl() {
        this.pieces = new ArrayList<>();
        this.factory = null;
    }

    public void addPiece() {
        this.pieces.add(current);
        this.current = this.factory.getRandomTetromino();
    }

    @Override
    public List<Tetromino> getPieces() {
        return List.copyOf(this.pieces);
    }

    //TODO ale
    public boolean fallDown() {
        this.addPiece();
        return false;
    }

    //TODO anto
    public boolean checkCollision() {
        return false;
    }

    @Override
    public boolean isOver() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isOver'");
    }
    
}
