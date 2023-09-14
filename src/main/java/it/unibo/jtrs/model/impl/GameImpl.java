package it.unibo.jtrs.model.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.unibo.jtrs.model.api.Game;
import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.utils.Pair;    

public class GameImpl implements Game{

    private Map<Pair<Integer, Integer>, Tetromino> pieces;

    public GameImpl() {
        this.pieces = new HashMap<>();
    }

    @Override
    public List<Tetromino> getPieces() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPieces'");
    }

    @Override
    public boolean isOver() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isOver'");
    }
    
}
