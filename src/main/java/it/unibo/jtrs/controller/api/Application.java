package it.unibo.jtrs.controller.api;

import java.util.List;

import it.unibo.jtrs.model.api.Tetromino;

public interface Application {

    public void update();

    public void redraw();

    public Controller<Integer> getScoreController();

    public Controller<Tetromino> getPreviewController();

    public Controller<List<Tetromino>> getPiecesController();
}
