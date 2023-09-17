package it.unibo.jtrs.model.impl;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.utils.Pair;

public class GameModel {

    private List<Tetromino> pieces;
    private Tetromino current;
    private Tetromino next;

    public GameModel() {
        this.pieces = new ArrayList<>();
        this.current = null;
        this.next = null;
    }

    public List<Tetromino> getPieces() {
        return Stream.concat(this.pieces.stream(), Stream.of(this.current)).collect(Collectors.toList());
    }

    public Tetromino getCurrentPiece() {
        return this.current;
    }

    public int advance() {
        this.current = this.next;
        return 0;
    }

    public void setNext(Tetromino next) {
        this.next = next;
    }

    //return if current can be put in game grid
    public boolean isOver() {
        return false;
    }

    //return if current can rotate
    public boolean canRotate() {
        return false;
    }

    //return if current touches ground
    public boolean fallDown() {
        //draft
        if(this.checkPieceCollision()) {
            return true;
        }
        return false;
    }

    //return if current touches pieces
    public boolean checkPieceCollision() {

        return false;
    }

    //return if current touches boundaries
    public boolean checkBoundCollision() {
        //return this.getCurrentXStats().getMin() == 0 || this.getCurrentXStats().getMax() == Constants.GRID_COLS - 1;
        return false;
    }

    private IntSummaryStatistics getCurrentXStats() {
        return this.current.getComponents(0, 0).stream().collect(Collectors.summarizingInt(Pair::getX));
    }

    private IntSummaryStatistics getCurrentYStats() {
        return this.current.getComponents(0, 0).stream().collect(Collectors.summarizingInt(Pair::getY));
    }

    //possibile enumerazione per dire da che lato devo controllare la collisione
}
