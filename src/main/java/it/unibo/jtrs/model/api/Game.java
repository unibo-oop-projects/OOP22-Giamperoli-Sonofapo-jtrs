package it.unibo.jtrs.model.api;

import java.util.List;

public interface Game {
    
    public List<Tetromino> getPieces();

    public boolean isOver();

    
}
