package it.unibo.jtrs.model.impl;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import it.unibo.jtrs.model.api.Tetromino;
import it.unibo.jtrs.utils.Pair;

public class GameModel {

    public static final int GRID_ROWS = 20;
    public static final int GRID_COLS = 10;

    private List<Tetromino> pieces;

    public GameModel(Tetromino first) {
        this.pieces = new ArrayList<>(List.of(first));
    }

    public List<Tetromino> getPieces() {
        return List.copyOf(this.pieces);
    }

    public Tetromino getCurrentPiece() {
        return this.pieces.get(this.pieces.size() - 1);
    }

    public void nextPiece(Tetromino next) {
        this.pieces.add(next);
    }

    public void advance(int x, int y) {
        this.getCurrentPiece().translate(x, y);
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
    public boolean checkBottom() {
        return this.checkUnder(20); /////////////////////////////////////////////
    }

    //return if current touches pieces
    public boolean checkPieceCollision() {
        var c = this.getCoordPieces().stream().filter(p -> this.getCurrentPiece().getComponents(0, 0).stream().map(x -> x.getX()).collect(Collectors.toList()).contains(p.getX())); //?????????????????????????
        return this.checkUnder(c.collect(Collectors.summarizingInt(Pair::getY)).getMax());
    }

    //return if current touches boundaries
    public boolean checkBoundCollision() {
        return this.getCurrentXStats().getMin() == 0 || this.getCurrentXStats().getMax() == 9 - 1;//////////////////////////////////////////////////////////
    }

    private boolean checkUnder(int y) {
        return this.getCurrentYStats().getMax() == y - 1;
    }
    
    private IntSummaryStatistics getCurrentXStats() {
        return this.getCurrentPiece().getComponents(0, 0).stream().collect(Collectors.summarizingInt(Pair::getX));
    }

    private IntSummaryStatistics getCurrentYStats() {
        return this.getCurrentPiece().getComponents(0, 0).stream().collect(Collectors.summarizingInt(Pair::getY));
    }

    private List<Pair<Integer, Integer>> getCoordPieces() {
        List<Pair<Integer, Integer>> res = new ArrayList<>();
        this.pieces.forEach(p -> res.addAll(p.getComponents(0, 0)));
        return res;
    }

    //set di possibili coordinate libere in cui piazzare il pezzo
}
